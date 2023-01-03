package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ejbank_customer")
@DiscriminatorValue(value = "customer")
public class Customer extends User implements Serializable {

    @JoinColumn(name="advisor_id", nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Advisor advisor;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Account> accounts;

    public Customer() {
    }

    public Advisor getAdvisor() {
        return advisor;
    }
    public Set<Account> getAccounts() {
        return accounts;
    }
}
