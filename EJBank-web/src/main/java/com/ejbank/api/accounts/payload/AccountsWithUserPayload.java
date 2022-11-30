package com.ejbank.api.accounts.payload;

import java.util.List;

public class AccountsWithUserPayload {

    private final List<AccountWithUserPayload> accounts;

    public AccountsWithUserPayload(List<AccountWithUserPayload> accounts ) {
        this.accounts= accounts;
    }

    public List<AccountWithUserPayload> getAccounts(){
        return accounts;
    }

}
