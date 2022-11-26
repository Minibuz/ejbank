package com.ejbank.service;

import com.ejbank.dao.User;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

    //TODO : Change, this is just a test
    User getUser(Integer id);
}
