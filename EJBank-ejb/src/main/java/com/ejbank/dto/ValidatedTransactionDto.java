package com.ejbank.dto;

public record ValidatedTransactionDto(boolean result, String message, String error) {
}
