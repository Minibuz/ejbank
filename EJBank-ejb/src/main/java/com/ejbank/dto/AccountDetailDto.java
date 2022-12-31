package com.ejbank.dto;

import com.ejbank.dao.Account;
import com.ejbank.dao.User;

import java.math.BigDecimal;

public class AccountDetailDto {

    private final User owner;
    private final User advisor;
    private final BigDecimal rate;
    private final BigDecimal interest;
    private final BigDecimal amount;

    private final String error;


    public AccountDetailDto(Account account, User owner, User advisor, String error) {
        this.owner = owner;
        this.advisor = advisor;
        this.rate = account.getAccountType().getRate();
        this.interest = account.getBalance().multiply(this.rate).divide(BigDecimal.valueOf(100));
        this.amount = account.getBalance();
        this.error = error;
    }

    public User getOwner() {
        return owner;
    }

    public User getAdvisor() {
        return advisor;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getError() {
        return error;
    }
}
