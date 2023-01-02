package com.ejbank.service.account;

import com.ejbank.dto.account.AccountDetailDto;
import com.ejbank.dto.account.AppliedTransactionDto;
import com.ejbank.dto.account.TransactionsDto;
import com.ejbank.dto.account.ValidityCheckDto;

import javax.ejb.Local;
import java.math.BigDecimal;

@Local
public interface AccountServiceLocal {

    /**
     * Check the validity of a transaction looking at the balance in the database.
     *
     * @param sourceId
     *          {@link Integer}
     * @param receiverId
     *          {@link Integer}
     * @param amount
     *          {@link BigDecimal}
     * @param authorId
     *          {@link Integer}
     * @return
     *          {@link ValidityCheckDto}
     */
    ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount, Integer authorId);

    /**
     * Register a transaction. Will also apply it unless the author is a customer and the amount is >1000€.
     *
     * @param authorId
     *          {@link Integer}
     * @param sourceId
     *          {@link Integer}
     * @param receiverId
     *          {@link Integer}
     * @param amount
     *          {@link BigDecimal}
     * @param comment
     *          {@link String}
     * @return
     *          {@link AppliedTransactionDto}
     */
    AppliedTransactionDto applyTransaction(Integer authorId, Integer sourceId, Integer receiverId, BigDecimal amount, String comment);


    /**
     * Get the details of one account.
     *
     * @param accountId
     *          {@link Integer}
     * @param userId
     *          {@link Integer}
     * @return
     *          {@link AccountDetailDto}
     */
    AccountDetailDto accountDetail(Integer accountId, Integer userId);

    /**
     * Get 10 transactions of one account from the offset. Ordered by date of insertion.
     *
     * @param accountId
     *          {@link Integer}
     * @param offset
     *          {@link Integer}
     * @param userId
     *          {@link Integer}
     * @return
     *          {@link TransactionsDto}
     */
    TransactionsDto getTransactions(Integer accountId, Integer offset, Integer userId);

}
