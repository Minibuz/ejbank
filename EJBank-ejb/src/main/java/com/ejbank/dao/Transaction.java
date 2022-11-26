package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ejbank_transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="account_id_from", nullable=false)
    //TODO : add foreign key
    private Integer accountIdFrom;

    @Column(name="account_id_to", nullable=false)
    //TODO : add foreign key
    private Integer accountIdTo;

    @Column(name="author", nullable=false)
    //TODO : add foreign key
    private Integer author;

    @Column(name="amount", nullable=false)
    private BigDecimal amount;

    @Column(name="comment", nullable=false)
    private String comment;

    @Column(name="applied", nullable=false)
    private Byte applied;

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable=false)
    private Date date;

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAccountIdFrom() {
        return accountIdFrom;
    }
    public void setAccountIdFrom(Integer account_id_from) {
        this.accountIdFrom = account_id_from;
    }
    public Integer getAccountIdTo() {
        return accountIdTo;
    }
    public void setAccountIdTo(Integer account_id_to) {
        this.accountIdTo = account_id_to;
    }
    public Integer getAuthor() {
        return author;
    }
    public void setAuthor(Integer author) {
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
    public Byte getApplied() {
        return applied;
    }
    public void setApplied(Byte applied) {
        this.applied = applied;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(accountIdFrom, that.accountIdFrom) && Objects.equals(accountIdTo, that.accountIdTo) && Objects.equals(author, that.author) && Objects.equals(amount, that.amount) && Objects.equals(comment, that.comment) && Objects.equals(applied, that.applied) && Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, accountIdFrom, accountIdTo, author, amount, comment, applied, date);
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountIdFrom=" + accountIdFrom +
                ", accountIdTo=" + accountIdTo +
                ", author=" + author +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", applied=" + applied +
                ", date=" + date +
                '}';
    }
}
