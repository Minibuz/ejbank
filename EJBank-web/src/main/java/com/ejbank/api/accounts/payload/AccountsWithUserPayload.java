package com.ejbank.api.accounts.payload;

import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.dto.AccountWithUserDto;
import com.ejbank.dto.AccountsWithUserDto;

import java.util.List;
import java.util.Objects;

public class AccountsWithUserPayload {

    private final List<AccountWithUserPayload> accounts;

    private final String error;

    private AccountsWithUserPayload(List<AccountWithUserPayload> accounts, String error) {

        this.accounts= Objects.requireNonNull(accounts);
        this.error=Objects.requireNonNull(error);
    }

    public static AccountsWithUserPayload AccountsWithUserFromDTO(List<AccountWithUserDto> accounts, String error){
        return new AccountsWithUserPayload(accounts.stream()
                .map(accountWithUser ->
                        new AccountWithUserPayload(
                                new AccountPayload(
                                        accountWithUser.getId(),
                                        accountWithUser.getType(),
                                        accountWithUser.getAmount()
                                ),
                                new UserPayload(accountWithUser.getFirstName(), "")
                        )).toList(),error);
    }

    public List<AccountWithUserPayload> getAccounts(){
        return accounts;
    }

}
