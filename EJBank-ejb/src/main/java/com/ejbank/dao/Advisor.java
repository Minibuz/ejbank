package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ejbank_advisor")
public class Advisor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "advisor")
    private Set<Customer> customers;

    @OneToOne
    private User user;

    public Advisor() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advisor advisor = (Advisor) o;
        return Objects.equals(id, advisor.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Advisor{" +
                "id=" + id +
                '}';
    }
}
