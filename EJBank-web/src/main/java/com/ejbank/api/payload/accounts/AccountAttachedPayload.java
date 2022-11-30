package com.ejbank.api.payload.accounts;

import java.math.BigDecimal;

public class AccountAttachedPayload {

    private final AccountWithUserPayload account;
    private final int validation;

    public AccountAttachedPayload(AccountWithUserPayload account, int validation) {
        this.account = account;
        this.validation=validation;
    }

    public int getId() {
        return account.getId();
    }
    public String getUser(){return account.getUser();}
    public String getType() {
        return account.getType();
    }
    public BigDecimal getAmount() {
        return account.getAmount();
    }
    public int getValidation(){return validation;}
}
