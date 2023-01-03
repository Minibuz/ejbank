package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ejbank_user")
@DiscriminatorValue(value = "none")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="firstname", length=50, nullable=false)
    private String firstname;

    @Column(name="lastname", length=50, nullable=false)
    private String lastname;

    @Column(name="type", length=50, nullable=false)
    private String type;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

    public User() {
    }

    public Integer getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getType() {
        return type;
    }
}
