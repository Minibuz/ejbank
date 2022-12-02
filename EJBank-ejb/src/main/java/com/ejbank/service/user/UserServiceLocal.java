package com.ejbank.service.user;

import com.ejbank.dao.User;
import com.ejbank.dto.AccountDto;
import com.ejbank.dto.AccountsDto;
import com.ejbank.dto.AccountsWithUserDto;
import com.ejbank.dto.UserInfo;

import javax.ejb.Local;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Local
public interface UserServiceLocal {

    UserInfo getUser(Integer id);

    AccountsDto getAccounts(Integer id);

    Integer getNotificationCount(Integer id);

    AccountsWithUserDto getAccountsWithUser(Integer id);
}
