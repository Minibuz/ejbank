package com.ejbank.service.user;

import com.ejbank.dto.user.AccountsDto;
import com.ejbank.dto.user.AccountsWithInfoDto;
import com.ejbank.dto.user.AccountsWithUserDto;
import com.ejbank.dto.user.UserInfo;

import javax.ejb.Local;

@Local
public interface UserServiceLocal {

    /**
     * Get the info of the user.
     *
     * @param id
     *          {@link Integer} the id of the user
     * @return
     *          {@link UserInfo}
     */
    UserInfo getUser(Integer id);

    /**
     * Get the accounts associated with the user.
     *
     * @param id
     *          {@link Integer} the id of the user
     * @return
     *          {@link AccountsDto}
     */
    AccountsDto getAccounts(Integer id);

    /**
     * Get all the notifications associated with the user.
     *
     * @param id
     *          {@link Integer} the id of the user
     * @return
     *          {@link Long}
     */
    Long getNotificationCount(Integer id);

    /**
     * Get all the accounts associated with one user. That user can be an advisor and this method will
     * return all the accounts of his related customers.
     *
     * @param id
     *          {@link Integer} the id of the user
     * @return
     *          {@link AccountsWithUserDto}
     */
    AccountsWithUserDto getAccountsWithUser(Integer id);

    /**
     * Get all the accounts associated with one user including the number of transactions that needs to be validated.
     * That user can be an advisor and this method will return all the accounts of his related customers.
     *
     * @param id
     *          {@link Integer} the id of the user
     * @return
     *          {@link AccountsWithInfoDto}
     */
    AccountsWithInfoDto getAccountsAttached(Integer id);
}
