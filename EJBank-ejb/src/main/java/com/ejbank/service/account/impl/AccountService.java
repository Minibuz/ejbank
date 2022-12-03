package com.ejbank.service.account.impl;

import com.ejbank.dao.Account;
import com.ejbank.dao.Transaction;
import com.ejbank.dao.User;
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
    public ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount) {
        var accountSource = em.find(Account.class, sourceId);
        var accountReceiver = em.find(Account.class, receiverId);
        if(accountSource != null && accountReceiver != null) {
            var balanceSource = accountSource.getBalance();
            var balanceReceiver = accountReceiver.getBalance();
            var balanceSourceAfter = balanceSource.subtract(amount);
            var balanceReceiverAfter = balanceReceiver.add(amount);
            var isNotPossible = balanceSourceAfter.signum()==-1;
            var message = !isNotPossible?"Can do good":"Error : can't do";
            return new ValidityCheckDto(!isNotPossible, balanceSourceAfter, balanceReceiverAfter, message, "");
        }
        return new ValidityCheckDto(false, amount, null, null, "Error: Id doesn't exist");
    }

    @Override
    public AppliedTransactionDto applyTransaction(Integer authorId, Integer sourceId, Integer receiverId, BigDecimal amount, String comment) {
        var accountSource = em.find(Account.class, sourceId);
        var accountReceiver = em.find(Account.class, receiverId);
        var author = em.find(User.class, authorId);
        if(accountSource != null && accountReceiver != null) {
            var newTransaction = new Transaction();
            newTransaction.setAccountFrom(accountSource);
            newTransaction.setAccountTo(accountReceiver);
            newTransaction.setAmount(amount);
            newTransaction.setAuthor(author);
            newTransaction.setApplied(false);
            newTransaction.setComment(comment);
            newTransaction.setDate(new Date());
            em.persist(newTransaction);
            return new AppliedTransactionDto(true, "Was apply - Need validation now");
        }
        return new AppliedTransactionDto(false, "Wasn't apply");
    }
}
