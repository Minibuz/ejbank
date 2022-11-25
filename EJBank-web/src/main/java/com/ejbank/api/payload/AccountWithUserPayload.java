package com.ejbank.api.payload;

import java.math.BigDecimal;

public class AccountWithUserPayload {

    private final AccountPayload account;
    private final UserPayload user;

    public AccountWithUserPayload(AccountPayload account, UserPayload user) {
        this.account = account;
        this.user = user;
    }

    public Long getId_account() {
        return account.getId();
    }
    public String getUser(){return user.toString();}
    public String getType() {
        return account.getType();
    }
    public BigDecimal getAmount() {
        return account.getAmount();
    }
}
