package com.ejbank.api.payload.transaction;

import java.math.BigDecimal;

public class TransactionPreviewResponsePayload {

    private final boolean result;
    private final BigDecimal before ;
    private final BigDecimal after;
    private final String message;



    public TransactionPreviewResponsePayload(boolean result, BigDecimal before,BigDecimal after,String message) {
        this.result =result;
        this.before =before;
        this.after=after;
        this.message=message;
    }

    public boolean isResult() {
        return result;
    }

    public BigDecimal getBefore() {
        return before;
    }

    public BigDecimal getAfter() {
        return after;
    }

    public String getMessage() {
        return message;
    }
}
