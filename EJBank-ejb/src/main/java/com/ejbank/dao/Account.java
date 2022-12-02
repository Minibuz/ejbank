package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @Column(name="balance", nullable=false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "accountFrom", fetch = FetchType.LAZY)
    private Set<Transaction> transactionFrom;

    @OneToMany(mappedBy = "accountTo", fetch = FetchType.LAZY)
    private Set<Transaction> transactionTo;

    public Account() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<Transaction> getTransactionFrom() {
        return transactionFrom;
    }
    public void setTransactionFrom(Set<Transaction> transactionFrom) {
        this.transactionFrom = transactionFrom;
    }
    public Set<Transaction> getTransactionTo() {
        return transactionTo;
    }
    public void setTransactionTo(Set<Transaction> transactionTo) {
        this.transactionTo = transactionTo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + customer +
                ", accountTypeId=" + accountType +
                ", balance=" + balance +
                '}';
    }
}
