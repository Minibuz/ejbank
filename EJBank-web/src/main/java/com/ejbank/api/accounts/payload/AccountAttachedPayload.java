package com.ejbank.api.accounts.payload;

import com.ejbank.api.user.payload.UserPayload;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountAttachedPayload {
    private final AccountPayload account;
    private final UserPayload user;
    private final int validation;

    public AccountAttachedPayload(AccountPayload account, UserPayload user, int validation) {
        this.account = Objects.requireNonNull(account);
        this.user = Objects.requireNonNull(user);
        this.validation=validation;
    }

    public int getId() {
        return account.getId();
    }
    public String getUser(){return user.toString();}
    public String getType() {
        return account.getType();
    }
    public BigDecimal getAmount() {
        return account.getAmount();
    }
    public int getValidation(){return validation;}
}
