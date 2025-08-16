package com.automationteststore.utils;

public class CredentialsProvider {
    private static final String USERNAME_ENV = "TESTDATA_USER_NAME";
    private static final String PASSWORD_ENV = "TESTDATA_USER_PASSWORD";

    public static String getUsername() {
        String username = System.getenv(USERNAME_ENV);

        if(username == null){
            throw new IllegalStateException("Environment variable " + USERNAME_ENV + " is not specified");
        }

        return username;
    }

    public static String getPassword() {
        String password = System.getenv(PASSWORD_ENV);

        if(password == null){
            throw new IllegalStateException("Environment variable " + PASSWORD_ENV + " is not specified");
        }

        return password;
    }
}
