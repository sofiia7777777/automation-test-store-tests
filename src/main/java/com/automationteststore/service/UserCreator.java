package com.automationteststore.service;

import com.automationteststore.model.User;
import com.automationteststore.utils.CredentialsProvider;

public class UserCreator {

    public static User withCredentialsFromEnvironment() {
        return new User(
                CredentialsProvider.getUsername(),
                CredentialsProvider.getPassword()
        );
    }
}
