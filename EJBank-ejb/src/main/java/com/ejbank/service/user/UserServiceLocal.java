package com.ejbank.service.user;

import com.ejbank.dao.User;
import com.ejbank.dto.*;

import javax.ejb.Local;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Local
public interface UserServiceLocal {

    UserInfo getUser(Integer id);

    AccountsDto getAccounts(Integer id);

    Long getNotificationCount(Integer id);

    AccountsWithUserDto getAccountsWithUser(Integer id);

    AccountsWithInfoDto getAccountsAttached(Integer id);
}
