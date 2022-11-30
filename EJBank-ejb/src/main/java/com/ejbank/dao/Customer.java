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
    @ManyToOne
    private Advisor advisor;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(advisor, customer.advisor) && Objects.equals(accounts, customer.accounts);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), advisor, accounts);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "advisor=" + advisor +
                ", accounts=" + accounts +
                '}';
    }
}
