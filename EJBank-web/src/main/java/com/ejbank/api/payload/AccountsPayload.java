package com.ejbank.api.payload;

import java.math.BigDecimal;
import java.util.ArrayList;
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
