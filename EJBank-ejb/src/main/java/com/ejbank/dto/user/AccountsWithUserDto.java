package com.ejbank.dto.user;

import java.util.List;

public record AccountsWithUserDto(List<AccountWithUserDto> accounts, String error) {
}
