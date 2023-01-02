package com.ejbank.service.transaction;

import com.ejbank.dto.transaction.ValidatedTransactionDto;

import javax.ejb.Local;

@Local
public interface TransactionServiceLocal {

    /**
     * Use to validate a transaction by an advisor.
     *
     * @param transactionId
     *          {@link Integer}
     * @param isApprove
     *          {@link Boolean}
     * @param authorId
     *          {@link Integer}
     * @return
     *          {@link ValidatedTransactionDto}
     */
    ValidatedTransactionDto validateTransaction(Integer transactionId, boolean isApprove, Integer authorId);
}
