package com.ejbank.service.transaction;

import com.ejbank.dto.ValidatedTransactionDto;

import javax.ejb.Local;

@Local
public interface TransactionServiceLocal {

    ValidatedTransactionDto validateTransaction(Integer transactionId, boolean isApprove, Integer authorId);
}
