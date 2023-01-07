package com.ejbank.service.account.impl;

import com.ejbank.dao.*;
import com.ejbank.dto.account.*;
import com.ejbank.service.account.AccountServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class AccountService implements AccountServiceLocal {

    @PersistenceContext(unitName = "EJBankPU")
    private EntityManager em;

    @Override
    public ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount, Integer authorId) {

        var accountSource = em.find(Account.class, sourceId);
        if(accountSource == null) {
            return new ValidityCheckDto(false, amount, BigDecimal.ZERO, null, "Error: Source account doesn't exist");
        }

        var accountReceiver = em.find(Account.class, receiverId);
        if(accountReceiver == null) {
            return new ValidityCheckDto(false, amount, BigDecimal.ZERO, null, "Error: Receiving account doesn't exist");
        }

        var balanceSource = accountSource.getBalance();
        var balanceReceiver = accountReceiver.getBalance();
        var balanceSourceAfter = balanceSource.subtract(amount);
        var balanceReceiverAfter = balanceReceiver.add(amount);
        var isNotPossible = balanceSourceAfter.signum()==-1;
        var message = !isNotPossible?"Can do good":"Error : can't do";
        return new ValidityCheckDto(!isNotPossible, balanceSourceAfter, balanceReceiverAfter, message, null);
    }

    @Override
    public AppliedTransactionDto applyTransaction(Integer authorId, Integer sourceId, Integer receiverId, BigDecimal amount, String comment) {
        var accountSource = em.find(Account.class, sourceId);
        if(accountSource == null) {
            return new AppliedTransactionDto(false, "Error: Source account doesn't exist");
        }

        var accountReceiver = em.find(Account.class, receiverId);
        if(accountReceiver == null) {
            return new AppliedTransactionDto(false, "Error: Receiving account doesn't exist");
        }

        var user = em.find(User.class, authorId);
        if( user instanceof Customer && amount.compareTo(new BigDecimal(1000)) > 0) {
            var newTransaction = new Transaction(accountSource, accountReceiver, user, amount, comment, false, new Date());
            em.persist(newTransaction);
            return new AppliedTransactionDto(true, "Transaction need validation");
        }

        var newTransaction = new Transaction(accountSource, accountReceiver, user, amount, comment, true, new Date());
        em.persist(newTransaction);

        var balanceFrom = accountSource.getBalance();
        var balanceTo = accountReceiver.getBalance();
        accountSource.setBalance(balanceFrom.subtract(amount));
        accountReceiver.setBalance(balanceTo.add(amount));

        return new AppliedTransactionDto(true, "Transaction was applied");
    }

    @Override
    public AccountDetailDto accountDetail(Integer accountId, Integer userId) {

        var account = em.find(Account.class, accountId);

        if(account == null){
           return  new AccountDetailDto(null,null,null,"Error: this account doesn't exist");
        }

        var owner = account.getCustomer();
        if(owner == null){
            return new AccountDetailDto(null,null,null,"Error: this account doesn't have a owner :c");
        }

        var adviser = owner.getAdvisor();

        if(adviser == null){
            return new AccountDetailDto(null,null,null,"Error: this account doesn't have a adviser 8)");
        }

        if( userId == null || (!userId.equals(adviser.getId()) && !userId.equals(owner.getId()))){
            return new AccountDetailDto(null,null,null,"Error: this user doesn't have access to this account");
        }
        return new AccountDetailDto(account,owner,adviser,null);
    }

    @Override
    public TransactionsDto getTransactions(Integer accountId, Integer offset, Integer userId) {
        var account = em.find(Account.class, accountId);
        var user = em.find(User.class, userId);

        if(account == null) {
            return new TransactionsDto(0, List.of(), "Error: Account does not exist");
        }
        if(account.getCustomer().getId().intValue() != userId.intValue() && account.getCustomer().getAdvisor().getId().intValue() != userId.intValue()) {
            return new TransactionsDto(0 , List.of(), "Error: This user cannot access this account");
        }

        var qry = em.createQuery("""
SELECT tran
FROM Transaction tran
WHERE ( tran.accountFrom.id = :id OR tran.accountTo.id = :id )
ORDER BY tran.date desc
""");
        qry.setParameter("id", accountId)
                .setMaxResults(10)
                .setFirstResult(offset);
        List<Transaction> results = qry.getResultList();

        var qryTotal = em.createQuery("SELECT count(tran) FROM Transaction tran WHERE ( tran.accountFrom.id = :id OR tran.accountTo.id = :id )");
        qryTotal.setParameter("id", accountId);
        var result = (Long) qryTotal.getSingleResult();

        return new TransactionsDto(result.intValue(),
                results.stream().map(trs -> {
                    var state = "APPLYED";
                    if(!trs.getApplied()) {
                        if( user instanceof Customer ) {
                            state = "WAITING_APPROVE";
                        }
                        if( user instanceof Advisor) {
                            state = "TO_APPROVE";
                        }
                    }
                    return new TransactionDto(
                        trs.getId(),
                        trs.getDate(),
                        trs.getAccountFrom().getAccountType().getName(),
                        trs.getAccountTo().getAccountType().getName(),
                        trs.getAccountTo().getCustomer().getFirstname(),
                        trs.getAmount(),
                        trs.getAuthor().getFirstname() + " " + trs.getAuthor().getLastname(),
                        trs.getComment(),
                            state
                        );
                }).toList(),
                null);
    }
}
