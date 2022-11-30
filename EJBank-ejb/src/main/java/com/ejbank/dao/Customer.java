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

    @OneToOne
    private User user;

    @JoinColumn(name="advisor_id", nullable=false)
    @ManyToOne
    private Advisor advisor;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Advisor getAdvisor() {
        return advisor;
    }
    public void setAdvisor(Advisor advisor) {
        this.advisor = this.advisor;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(advisor, customer.advisor);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, advisor);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", advisorId=" + advisor +
                '}';
    }
}
