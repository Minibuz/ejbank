package com.ejbank.api.transaction.payload;

public class TransactionValidationResponsePayload {

    private final boolean result;
    private final String message;



    public TransactionValidationResponsePayload(boolean result, String message) {
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
