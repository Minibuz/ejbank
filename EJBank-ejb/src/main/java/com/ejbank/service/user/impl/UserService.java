package com.ejbank.service.user.impl;

import com.ejbank.dao.AccountType;
import com.ejbank.dao.Advisor;
import com.ejbank.dao.Customer;
import com.ejbank.dao.User;
import com.ejbank.dto.*;
import com.ejbank.service.user.UserServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
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
        List<AccountDto> accounts = new ArrayList<>();
        if ( userDao instanceof Customer customer ) {
            accounts.addAll(getAccount(customer));
        }
        if( userDao instanceof Advisor advisor ) {
            var customers = advisor.getCustomers();
            accounts.addAll(customers.stream().flatMap(customer ->
                getAccount(customer).stream()).toList());
        }
        return new AccountsDto(accounts, accounts.isEmpty()?null:"Error");
    }

    private static List<AccountDto> getAccount(Customer customer) {
        var accounts = customer.getAccounts();
        return accounts.stream().map(AccountDto::new).toList();
    }

    @Override
    public Integer getNotificationCount(Integer id) {
        var userDao = em.find(User.class, id);
        return userDao.getTransactions()
                .stream()
                .filter(transaction -> !transaction.getApplied())
                .toList().size();
    }

    @Override
    public AccountsWithUserDto getAccountsWithUser(Integer id) {
        var userDao = em.find(User.class, id);
        List<AccountWithUserDto> accountsWithUser = new ArrayList<>();
        if ( userDao instanceof Customer customer ) {
            accountsWithUser.addAll(getAccountWithUser(customer));
        }
        if( userDao instanceof Advisor advisor ) {
            var customers = advisor.getCustomers();
            accountsWithUser.addAll(customers.stream().flatMap(customer ->
                getAccountWithUser(customer).stream()).toList());
        }
        return new AccountsWithUserDto(accountsWithUser, accountsWithUser.isEmpty()?null:"Error");
    }

    private static List<AccountWithUserDto> getAccountWithUser(Customer customer) {
        var accounts = customer.getAccounts();
        var name = customer.getFirstname();
        return accounts.stream().map(account -> new AccountWithUserDto(account.getId(), name, account.getAccountType().getName(), account.getBalance())).toList();
    }
}
