package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_advisor")
@DiscriminatorValue(value = "customer")
public class Advisor extends User implements Serializable {

    @OneToMany(mappedBy = "advisor")
    private Set<Customer> customers;

    public Set<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Advisor advisor = (Advisor) o;
        return Objects.equals(customers, advisor.customers);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customers);
    }
    @Override
    public String toString() {
        return "Advisor{" +
                "customers=" + customers +
                '}';
    }
}
