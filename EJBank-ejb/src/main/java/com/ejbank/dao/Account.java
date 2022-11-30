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

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @Column(name="balance", nullable=false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "accountFrom")
    private Set<Transaction> transactionFrom;

    @OneToMany(mappedBy = "accountTo")
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(customer, account.customer) && Objects.equals(accountType, account.accountType) && Objects.equals(balance, account.balance);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, customer, accountType, balance);
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
