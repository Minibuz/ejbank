package com.ejbank.service.account;

import com.ejbank.dto.account.AccountDetailDto;
import com.ejbank.dto.account.AppliedTransactionDto;
import com.ejbank.dto.account.TransactionsDto;
import com.ejbank.dto.account.ValidityCheckDto;

import javax.ejb.Local;
import java.math.BigDecimal;

@Local
public interface AccountServiceLocal {

    ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount, Integer authorId);

    AppliedTransactionDto applyTransaction(Integer authorId, Integer sourceId, Integer receiverId, BigDecimal amount, String comment);

    AccountDetailDto accountDetail(Integer accountId, Integer userId);

    TransactionsDto getTransactions(Integer accountId, Integer offset, Integer userId);

}
