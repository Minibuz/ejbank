package com.ejbank.service.account;

import com.ejbank.dto.AccountDetailDto;
import com.ejbank.dto.AppliedTransactionDto;
import com.ejbank.dto.ValidityCheckDto;

import javax.ejb.Local;
import java.math.BigDecimal;

@Local
public interface AccountServiceLocal {

    ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount, Integer authorId);

    AppliedTransactionDto applyTransaction(Integer authorId, Integer sourceId, Integer receiverId, BigDecimal amount, String comment);

    AccountDetailDto accountDetail(Integer accountId, Integer userId);

}
