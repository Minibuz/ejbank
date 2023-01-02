package com.ejbank.api.accounts.payload;

import com.ejbank.api.user.payload.UserPayload;
import com.ejbank.dto.user.AccountsWithInfoDto;

import java.util.List;
import java.util.Objects;

public class AccountsAttachedPayload {

    private final List<AccountAttachedPayload> accounts;
    private final String error;


    private AccountsAttachedPayload(List<AccountAttachedPayload> accounts, String error) {
        this.accounts= Objects.requireNonNull(accounts);
        this.error = error;
    }


    public static AccountsAttachedPayload AccountsFromDTO(AccountsWithInfoDto list){
        var accounts = list.accounts();
        var error = list.error();
        return new AccountsAttachedPayload(accounts
                .stream()
                .map(accountWithInfo ->
                        new AccountAttachedPayload(
                                new AccountPayload(
                                        accountWithInfo.getId(),
                                        accountWithInfo.getType(),
                                        accountWithInfo.getAmount()
                                ),
                                new UserPayload(accountWithInfo.getFirstName(), ""),
                                accountWithInfo.getValidation()
                        )).toList(),
                error);
    }

    public List<AccountAttachedPayload> getAccounts(){
        return accounts;
    }

    public String getError() {
        return error;
    }
}
