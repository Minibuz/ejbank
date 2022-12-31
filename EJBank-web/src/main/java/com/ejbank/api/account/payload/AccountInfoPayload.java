package com.ejbank.api.account.payload;



import com.ejbank.api.user.payload.UserPayload;

import java.math.BigDecimal;

public class AccountInfoPayload {

    private final UserPayload owner;
    private final UserPayload advisor;
    private final BigDecimal rate;
    private final BigDecimal interest;
    private final BigDecimal amount;

    private final String error;


    public AccountInfoPayload(UserPayload owner, UserPayload advisor, BigDecimal rate, BigDecimal interest, BigDecimal amount,String error) {
        this.owner=owner;
        this.advisor=advisor;
        this.rate=rate;
        this.interest=interest;
        this.amount = amount;
        this.error = error;
    }

    public String getOwner() {
        return owner.toString();
    }

    public String getAdvisor() {
        return advisor.toString();
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
