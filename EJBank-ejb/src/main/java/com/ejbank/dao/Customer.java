package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="advisor_id", nullable=false)
    //TODO : add foreign key
    private Integer advisorId;

    @OneToMany(mappedBy = "customer_id")
    private Set<Account> accounts;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAdvisorId() {
        return advisorId;
    }
    public void setAdvisorId(Integer advisorId) {
        this.advisorId = advisorId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(advisorId, customer.advisorId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, advisorId);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", advisorId=" + advisorId +
                '}';
    }
}
