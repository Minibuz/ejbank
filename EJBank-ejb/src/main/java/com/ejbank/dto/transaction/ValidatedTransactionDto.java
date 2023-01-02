package com.ejbank.dto.transaction;

public record ValidatedTransactionDto(boolean result, String message, String error) {
}
