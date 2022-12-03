package com.ejbank.dto;

import java.math.BigDecimal;

public record ValidityCheckDto(boolean result, BigDecimal accountSender, BigDecimal accountReceiver, String message, String error) {
}
