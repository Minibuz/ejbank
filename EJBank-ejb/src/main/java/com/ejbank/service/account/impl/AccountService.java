package com.ejbank.service.account.impl;

import com.ejbank.dao.Account;
import com.ejbank.dao.Customer;
import com.ejbank.dao.Transaction;
import com.ejbank.dao.User;
import com.ejbank.dto.AccountDetailDto;
import com.ejbank.dto.AppliedTransactionDto;
import com.ejbank.dto.ValidityCheckDto;
import com.ejbank.service.account.AccountServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;

@Stateless
@LocalBean
public class AccountService implements AccountServiceLocal {

    @PersistenceContext(unitName = "EJBankPU")
    private EntityManager em;

    @Override
    public ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount, Integer authorId) {
        var user = em.find(User.class, authorId);
        if( user instanceof Customer && amount.compareTo(new BigDecimal(1000)) > 0) {
            return new ValidityCheckDto(false, amount, null, null, "Error: Customer cannot make a transfer of more than 1.000 euros.");
        }

        var accountSource = em.find(Account.class, sourceId);
        if(accountSource == null) {
            return new ValidityCheckDto(false, amount, null, null, "Error: Source account doesn't exist");
        }

        var accountReceiver = em.find(Account.class, receiverId);
        if(accountReceiver == null) {
            return new ValidityCheckDto(false, amount, null, null, "Error: Receiving account doesn't exist");
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
        var owner = account.getCustomer();
        var adviser = owner.getAdvisor();

        return new AccountDetailDto(account,owner,adviser,null);

    }
}
