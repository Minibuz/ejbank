package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
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
    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }
    public Set<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "advisor=" + advisor +
                ", accounts=" + accounts +
                '}';
    }
}
