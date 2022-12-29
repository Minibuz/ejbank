package com.ejbank.dto;

import java.util.List;

public record AccountsWithInfoDto(List<AccountWithInfoDto> accounts, String error) {
}
