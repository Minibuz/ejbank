package com.ejbank.service.impl;

import com.ejbank.dao.User;
import com.ejbank.service.UserServiceLocal;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Objects;

@Stateless
@LocalBean
public class UserService implements UserServiceLocal, Serializable {

    @PersistenceContext(unitName = "EJBankPU")
    private EntityManager em;

    @Override
    public User getUser(Integer id) {
        return em.find(User.class, id);
    }

    public void saveUser(User user) {
        em.persist(Objects.requireNonNull(user));
    }
}
