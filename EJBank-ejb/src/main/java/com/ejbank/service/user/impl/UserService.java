package com.ejbank.service.user.impl;

import com.ejbank.dao.AccountType;
import com.ejbank.dao.Customer;
import com.ejbank.dao.User;
import com.ejbank.dto.AccountDto;
import com.ejbank.dto.AccountsDto;
import com.ejbank.dto.UserInfo;
import com.ejbank.service.user.UserServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Stateless
@LocalBean
public class UserService implements UserServiceLocal, Serializable {

    @PersistenceContext(unitName = "EJBankPU")
    private EntityManager em;

    @Override
    public UserInfo getUser(Integer id) {
        var userDao = em.find(User.class, id);
        return new UserInfo(userDao);
    }

    @Override
    public AccountsDto getAccounts(Integer id) {
        var userDao = em.find(User.class, id);
        if ( userDao instanceof Customer customer ) {
            var accounts = customer.getAccounts();
            var accountsDto = accounts.stream().map(AccountDto::new).toList();
            return new AccountsDto(accountsDto, null);
        }
        return new AccountsDto(List.of(), "That user is not a customer.");
    }
}
