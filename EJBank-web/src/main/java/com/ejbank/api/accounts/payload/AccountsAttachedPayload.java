package com.ejbank.api.accounts.payload;

import java.util.List;

public class AccountsAttachedPayload {

    private final List<AccountAttachedPayload> accounts;

    public AccountsAttachedPayload(List<AccountAttachedPayload> accounts ) {
        this.accounts= accounts;
    }

    public List<AccountAttachedPayload> getAccounts(){
        return accounts;
    }

}
