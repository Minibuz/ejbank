package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @OneToMany(mappedBy = "accountType", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public AccountType() {
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getRate() {
        return rate;
    }
}
