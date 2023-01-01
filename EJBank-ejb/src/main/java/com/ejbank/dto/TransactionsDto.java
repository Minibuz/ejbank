package com.ejbank.dto;

import java.util.List;

public class TransactionsDto {
    private final int total;
    private final List<TransactionDto> transactions;
    private final String error;

    public TransactionsDto(int total, List<TransactionDto> transactions, String error) {
        this.total = total;
        this.transactions = transactions;
        this.error = error;
    }

    public int getTotal() {
        return total;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public String getError() {
        return error;
    }
}
