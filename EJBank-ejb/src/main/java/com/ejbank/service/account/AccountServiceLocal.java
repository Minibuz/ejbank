package com.ejbank.service.account;

import com.ejbank.dto.ValidityCheckDto;

import javax.ejb.Local;
import java.math.BigDecimal;

@Local
public interface AccountServiceLocal {

    ValidityCheckDto checkValidity(Integer sourceId, Integer receiverId, BigDecimal amount);
}
