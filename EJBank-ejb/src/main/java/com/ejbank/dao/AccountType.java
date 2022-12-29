package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_account_type")
public class AccountType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name", length=50, nullable=false)
    private String name;

    @Column(name="rate", nullable=false)
    private BigDecimal rate;

    @Column(name="overdraft", nullable=false)
    private Integer overdraft;

    @OneToMany(mappedBy = "accountType", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public AccountType() {
    }

    public AccountType(String name, BigDecimal rate, Integer overdraft, Set<Account> accounts) {
        this.name = name;
        this.rate = rate;
        this.overdraft = overdraft;
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    public Integer getOverdraft() {
        return overdraft;
    }
    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }
    public Set<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", overdraft=" + overdraft +
                '}';
    }
}
