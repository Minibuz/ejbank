package com.ejbank.service.user;

import com.ejbank.dto.user.AccountsDto;
import com.ejbank.dto.user.AccountsWithInfoDto;
import com.ejbank.dto.user.AccountsWithUserDto;
import com.ejbank.dto.user.UserInfo;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

    UserInfo getUser(Integer id);

    AccountsDto getAccounts(Integer id);

    Long getNotificationCount(Integer id);

    AccountsWithUserDto getAccountsWithUser(Integer id);

    AccountsWithInfoDto getAccountsAttached(Integer id);
}
