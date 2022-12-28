package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ejbank_transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name="account_id_from", nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountFrom;

    @JoinColumn(name="account_id_to", nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountTo;

    @JoinColumn(name="author", nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @Column(name="amount", nullable=false)
    private BigDecimal amount;

    @Column(name="comment", nullable=false)
    private String comment;

    @Column(name="applied", nullable=false)
    private Boolean applied;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false)
    private Date date;

    public Transaction() {
    }

    public Transaction(Account accountFrom, Account accountTo, User author, BigDecimal amount, String comment, Boolean applied, Date date) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.author = author;
        this.amount = amount;
        this.comment = comment;
        this.applied = applied;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Account getAccountFrom() {
        return accountFrom;
    }
    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }
    public Account getAccountTo() {
        return accountTo;
    }
    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Boolean getApplied() {
        return applied;
    }
    public void setApplied(Boolean applied) {
        this.applied = applied;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountIdFrom=" + accountFrom +
                ", accountIdTo=" + accountTo +
                ", author=" + author +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", applied=" + applied +
                ", date=" + date +
                '}';
    }
}
