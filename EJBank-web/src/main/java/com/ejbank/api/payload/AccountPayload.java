package com.ejbank.api.payload;

import java.math.BigDecimal;

public class AccountPayload {

    private final Long id_account;
    private final String type;
    private final BigDecimal amount;

    public AccountPayload(Long id_account, String type, BigDecimal amount) {
        this.id_account = id_account ;
        this.type =type;
        this.amount = amount;
    }

    public Long getId() {
        return id_account;
    }
    public String getType() {
        return type;
    }
    public BigDecimal getAmount() {
        return amount;
    }
}
