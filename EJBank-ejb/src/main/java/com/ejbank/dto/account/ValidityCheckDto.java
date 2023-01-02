package com.ejbank.dto.account;

import java.math.BigDecimal;

public record ValidityCheckDto(boolean result, BigDecimal accountSender, BigDecimal accountReceiver, String message, String error) {
}
