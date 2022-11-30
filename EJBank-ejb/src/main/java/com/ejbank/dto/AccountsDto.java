package com.ejbank.dto;

import java.util.List;

public record AccountsDto(List<AccountDto> accounts, String error) {
}
