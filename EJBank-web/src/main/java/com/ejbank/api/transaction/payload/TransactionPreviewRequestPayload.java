package com.ejbank.api.transaction.payload;

import java.math.BigDecimal;

public class TransactionPreviewRequestPayload {

    private  int source;
    private  int destination;
    private  int author;
    private  BigDecimal amount;


    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getAuthor() {
        return author;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
