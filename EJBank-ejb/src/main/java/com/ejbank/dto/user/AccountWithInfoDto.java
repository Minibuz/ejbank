package com.ejbank.dto.user;

import java.math.BigDecimal;

public class AccountWithInfoDto {

    private final Integer id;
    private final String firstName;
    private final String type;
    private final BigDecimal amount;
    private final Integer validation;

    public AccountWithInfoDto(Integer id, String firstName, String type, BigDecimal amount, Integer validation) {
        this.id = id;
        this.firstName = firstName;
        this.type = type;
        this.amount = amount;
        this.validation = validation;
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

    public Integer getValidation() {
        return validation;
    }
}
