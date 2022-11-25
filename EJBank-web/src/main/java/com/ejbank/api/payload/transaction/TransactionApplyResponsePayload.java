package com.ejbank.api.payload.transaction;

import java.math.BigDecimal;

public class TransactionApplyResponsePayload {

    private final boolean result;
    private final String message;



    public TransactionApplyResponsePayload(boolean result,String message) {
        this.result =result;

        this.message=message;
    }

    public boolean isResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
