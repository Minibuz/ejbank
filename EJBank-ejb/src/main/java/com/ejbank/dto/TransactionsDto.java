package com.ejbank.dto;

import java.util.List;

public record TransactionsDto(int total, List<TransactionDto> transactions, String error) {
}
