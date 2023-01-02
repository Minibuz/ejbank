package com.ejbank.api.accounts.payload;

import com.ejbank.dto.user.AccountDto;

import java.util.List;
import java.util.Objects;

public class AccountsPayload {


    private final List<AccountPayload> accounts;

    private final String error;

    private AccountsPayload(List<AccountPayload> accounts, String error) {
        this.accounts= Objects.requireNonNull(accounts);
        this.error = error;
    }

    public static AccountsPayload AccountsFromDTO(List<AccountDto> accounts, String error){
        return new AccountsPayload(accounts.stream()
                            .map(accountDto ->
                                    new AccountPayload(accountDto.getId(),
                                            accountDto.getType(),
                                            accountDto.getAmount()))
                            .toList(),error);
    }

    public List<AccountPayload> getAccounts(){
        return accounts;
    }

    public String getError() {
        return error;
    }
}
