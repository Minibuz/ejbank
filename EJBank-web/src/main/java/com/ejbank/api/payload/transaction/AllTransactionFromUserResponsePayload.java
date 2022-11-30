package com.ejbank.api.payload.transaction;

import com.ejbank.api.payload.UserPayload;

import java.math.BigDecimal;

public class AllTransactionFromUserResponsePayload {
    private final int transaction_id;
    private final int source_id;
    private final int destination_id;
    private final UserPayload destination_user;
    private final BigDecimal amount;
    private final UserPayload author;
    private final String comment;
    private final String state;



    public AllTransactionFromUserResponsePayload(int transaction_id,int source_id,int destination_id, UserPayload destination_user, BigDecimal amount, UserPayload author, String comment, String state) {
        this.transaction_id = transaction_id;
        this.source_id=source_id;
        this.destination_id=destination_id;
        this.destination_user= destination_user;
        this.amount=amount;
        this.author=author;
        this.comment=comment;
        this.state=state;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getSource_id() {
        return source_id;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public UserPayload getDestination_user() {
        return destination_user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public UserPayload getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public String getState() {
        return state;
    }
}
