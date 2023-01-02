package com.ejbank.dto.user;

import com.ejbank.dao.Account;

import java.math.BigDecimal;

public class AccountDto {
    private final Integer id;
    private final String type;
    private final BigDecimal amount;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.type = account.getAccountType().getName();
        this.amount = account.getBalance();
    }

    public Integer getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public BigDecimal getAmount() {
        return amount;
    }
}
