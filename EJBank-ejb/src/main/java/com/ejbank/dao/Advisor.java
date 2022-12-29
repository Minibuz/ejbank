package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_advisor")
@DiscriminatorValue(value = "advisor")
public class Advisor extends User implements Serializable {

    @OneToMany(mappedBy = "advisor", fetch = FetchType.LAZY)
    private Set<Customer> customers;

    public Advisor() {
    }

    public Advisor(String login, String password, String email, String firstname, String lastname, String type, Set<Customer> customers) {
        super(login, password, email, firstname, lastname, type);
        this.customers = customers;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Advisor{" +
                "customers=" + customers +
                '}';
    }
}
