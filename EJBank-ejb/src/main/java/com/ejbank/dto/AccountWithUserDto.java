package com.ejbank.dto;

import java.math.BigDecimal;

public class AccountWithUserDto {

    private final Integer id;
    private final String firstName;
    private final String type;
    private final BigDecimal amount;

    public AccountWithUserDto(Integer id, String firstName, String type, BigDecimal amount) {
        this.id = id;
        this.firstName = firstName;
        this.type = type;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
