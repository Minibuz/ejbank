package com.ejbank.api.accounts.payload;



import com.ejbank.api.user.payload.UserPayload;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountWithUserPayload {

    private final AccountPayload account;
    private final UserPayload user;

    public AccountWithUserPayload(AccountPayload account, UserPayload user) {
        this.account = Objects.requireNonNull(account);
        this.user = user;
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
}
