package com.ejbank.service.user.impl;

import com.ejbank.dao.*;
import com.ejbank.dto.*;
import com.ejbank.service.user.UserServiceLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        return new AccountsDto(accounts, accounts.isEmpty()?"Error":null);
    }

    private static List<AccountDto> getAccount(Customer customer) {
        var accounts = customer.getAccounts();
        return accounts.stream().map(AccountDto::new).toList();
    }

    @Override
    public Long getNotificationCount(Integer id) {
        var userDao = em.find(User.class, id);

        Query qry = null;
        if( userDao instanceof Customer ) {
            qry = em.createQuery("SELECT count(tran) " +
                    "FROM Customer cst, Account act, Transaction tran " +
                    "WHERE " +
                    "cst.id = :id " +
                    "AND " +
                    "tran.applied = false " +
                    "AND " +
                    "act.customer.id = cst.id " +
                    "AND " +
                    "( tran.accountFrom.id = act.id OR tran.accountTo.id = act.id )");
        } else if ( userDao instanceof Advisor ) {
            qry = em.createQuery("SELECT count(tran) " +
                    "FROM Advisor adv, Customer cst, Account act, Transaction tran " +
                    "WHERE " +
                    "adv.id = :id " +
                    "AND " +
                    "tran.applied = false " +
                    "AND " +
                    "cst.advisor.id = adv.id " +
                    "AND " +
                    "act.customer.id = cst.id " +
                    "AND " +
                    "( tran.accountFrom.id = act.id OR tran.accountTo.id = act.id )");
        } else {
            throw new IllegalArgumentException();
        }
        qry.setParameter("id", id);
        return (Long) qry.getSingleResult();
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

    @Override
    public AccountsWithInfoDto getAccountsAttached(Integer id) {
        var userDao = em.find(User.class, id);
        List<AccountWithInfoDto> accountsWithUser = new ArrayList<>();
        if ( userDao instanceof Customer customer ) {
            accountsWithUser.addAll(getAccountWithInfo(customer));
        }
        if( userDao instanceof Advisor advisor ) {
            var customers = advisor.getCustomers();
            accountsWithUser.addAll(customers.stream().flatMap(customer ->
                    getAccountWithInfo(customer).stream()).toList());
        }
        return new AccountsWithInfoDto(accountsWithUser, "");
    }

    private List<AccountWithInfoDto> getAccountWithInfo(Customer customer) {
        var accounts = customer.getAccounts();
        var name = customer.getFirstname();
        return accounts.stream()
                .map(account -> {
                    Query qry = em.createQuery("SELECT count(tran) " +
                            "FROM Transaction tran " +
                            "WHERE " +
                            "tran.applied = false " +
                            "AND " +
                            "( tran.accountFrom.id = :id OR tran.accountTo.id = :id )");
                    Long toValidate = (Long) qry.setParameter("id", account.getId()).getSingleResult();
                    return new AccountWithInfoDto(account.getId(), name, account.getAccountType().getName(), account.getBalance(), toValidate.intValue());
                }).toList();
    }
}
