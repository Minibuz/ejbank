package com.ejbank.dto.account;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDto {

    private final Integer id;
    private final String date;
    private final String source;
    private final String destination;
    private final String destination_user;
    private final BigDecimal amount;
    private final String author;
    private final String comment;
    private final String state;

    public TransactionDto(Integer id, Date date, String source, String destination, String destinationUser, BigDecimal amount, String author, String comment, String state) {
        this.id = id;
        this.date = date.toString();
        this.source = source;
        this.destination = destination;
        this.destination_user = destinationUser;
        this.amount = amount;
        this.author = author;
        this.comment = comment;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_user() {
        return destination_user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public String isState() {
        return state;
    }
}
