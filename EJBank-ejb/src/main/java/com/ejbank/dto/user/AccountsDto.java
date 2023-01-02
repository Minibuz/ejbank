package com.ejbank.dto.user;

import java.util.List;

public record AccountsDto(List<AccountDto> accounts, String error) {
}
