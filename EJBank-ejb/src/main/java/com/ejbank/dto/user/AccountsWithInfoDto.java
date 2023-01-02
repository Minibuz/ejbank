package com.ejbank.dto.user;

import java.util.List;

public record AccountsWithInfoDto(List<AccountWithInfoDto> accounts, String error) {
}
