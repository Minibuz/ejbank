package com.ejbank.api.accounts.payload;

import com.ejbank.dto.AccountDto;

import java.util.List;
import java.util.Objects;

public class AccountsAttachedPayload {

    private final List<AccountAttachedPayload> accounts;
    private final String error;


    private AccountsAttachedPayload(List<AccountAttachedPayload> accounts, String error) {
        this.accounts= Objects.requireNonNull(accounts);
        this.error = Objects.requireNonNull(error);
    }

    // TODO activate the mapper when DTO is create

//    public static AccountsAttachedPayload AccountsFromDTO(List<AccountAttachedPayload> accounts, String error){
//        return new AccountsAttachedPayload(accounts.stream()
//                               .map(accountWithUser ->
//                        new AccountWithUserPayload(
//                                new AccountPayload(
//                                        accountWithUser.getId(),
//                                        accountWithUser.getType(),
//                                        accountWithUser.getAmount()
//                                ),
//                                new UserPayload(accountWithUser.getFirstName(), ""),
//                                accountWithUser.getValidation()
//                        ))
//                .toList(),error);
//    }

    public List<AccountAttachedPayload> getAccounts(){
        return accounts;
    }

}
