package com.ejbank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
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

    @Column(name="login", length=8, nullable=false)
    private String login;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="email", nullable=false)
    private String email;

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

    public User(String login, String password, String email, String firstname, String lastname, String type, Set<Transaction> transactions) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
        this.transactions = transactions;
    }

    public User(String login, String password, String email, String firstname, String lastname, String type) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Set<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
