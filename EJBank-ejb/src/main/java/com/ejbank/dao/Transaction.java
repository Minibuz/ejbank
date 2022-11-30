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
    @ManyToOne
    private Account accountFrom;

    @JoinColumn(name="account_id_to", nullable=false)
    @ManyToOne
    private Account accountTo;

    @JoinColumn(name="author", nullable=false)
    @ManyToOne
    private User author;

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
        return Objects.equals(id, that.id) && Objects.equals(accountFrom, that.accountFrom) && Objects.equals(accountTo, that.accountTo) && Objects.equals(author, that.author) && Objects.equals(amount, that.amount) && Objects.equals(comment, that.comment) && Objects.equals(applied, that.applied) && Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, accountFrom, accountTo, author, amount, comment, applied, date);
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
