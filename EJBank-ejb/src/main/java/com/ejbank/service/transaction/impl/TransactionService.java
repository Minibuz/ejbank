package com.ejbank.service.transaction.impl;

import com.ejbank.dao.Advisor;
import com.ejbank.dao.Customer;
import com.ejbank.dao.Transaction;
import com.ejbank.dao.User;
import com.ejbank.dto.ValidatedTransactionDto;
import com.ejbank.service.transaction.TransactionServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Stateless
@LocalBean
public class TransactionService implements TransactionServiceLocal, Serializable {

    @PersistenceContext(unitName = "EJBankPU")
    private EntityManager em;

    @Override
    public ValidatedTransactionDto validateTransaction(Integer transactionId, boolean isApprove, Integer authorId) {
        var userDao = em.find(User.class, authorId);
        if(userDao == null) {
            return new ValidatedTransactionDto(false, "", "Error : No advisor with that id");
        }
        if( userDao instanceof Customer ) {
            return new ValidatedTransactionDto(false, "", "Error : Not an advisor");
        }

        var transaction = em.find(Transaction.class, transactionId);
        if(transaction == null) {
            return new ValidatedTransactionDto(false, "", "Error : Transaction does not exist");
        }

        var advisor = (Advisor) userDao;
        var accountFrom = transaction.getAccountFrom();

        if(!accountFrom.getCustomer().getAdvisor().equals(advisor)) {
            return new ValidatedTransactionDto(false, "", "Error : Advisor is not in charge of the client who did this transaction");
        }

        var accountTo = transaction.getAccountFrom();

        transaction.setApplied(true);
        var balanceFrom = accountFrom.getBalance();
        var balanceTo = accountTo.getBalance();
        var amount = transaction.getAmount();
        accountFrom.setBalance(balanceFrom.subtract(amount));
        accountTo.setBalance(balanceTo.add(amount));

        return new ValidatedTransactionDto(true, "Transaction is validate", "");
    }
}
