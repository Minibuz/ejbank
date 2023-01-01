package com.ejbank.service.transaction;

import com.ejbank.dto.ValidatedTransactionDto;

public interface TransactionServiceLocal {

    ValidatedTransactionDto validateTransaction(Integer transactionId, boolean isApprove, Integer authorId);
}
