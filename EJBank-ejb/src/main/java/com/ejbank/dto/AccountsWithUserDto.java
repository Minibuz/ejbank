package com.ejbank.dto;

import java.util.List;

public record AccountsWithUserDto(List<AccountWithUserDto> accounts, String error) {
}
