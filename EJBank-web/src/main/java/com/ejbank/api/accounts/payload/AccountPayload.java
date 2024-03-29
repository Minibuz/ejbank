package com.ejbank.api.accounts.payload;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountPayload {

    private final int id_account;
    private final String type;
    private final BigDecimal amount;

    public AccountPayload(int id_account, String type, BigDecimal amount) {
        this.id_account = id_account ;
        this.type = Objects.requireNonNull(type);
        this.amount = Objects.requireNonNull(amount);
    }

    public int getId() {
        return id_account;
    }
    public String getType() {
        return type;
    }
    public BigDecimal getAmount() {
        return amount;
    }
}
