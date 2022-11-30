package com.ejbank.service.user;

import com.ejbank.dao.User;
import com.ejbank.dto.UserInfo;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

    UserInfo getUser(Integer id);
}
