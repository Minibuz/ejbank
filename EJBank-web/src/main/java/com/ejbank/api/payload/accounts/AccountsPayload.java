package com.ejbank.api.payload.accounts;

import java.util.List;

public class AccountsPayload {

    private final List<AccountPayload> accounts;

    public AccountsPayload(List<AccountPayload> accounts ) {
        this.accounts= accounts;
    }

    public List<AccountPayload> getAccounts(){
        return accounts;
    }

}
