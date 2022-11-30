package com.ejbank.dto;

import com.ejbank.dao.User;

public class UserInfo {
    private final String firstName;
    private final String lastName;

    public UserInfo(User user) {
        this.firstName = user.getFirstname();
        this.lastName = user.getLastname();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
