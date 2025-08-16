package com.automationteststore.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }

    public static int getIntTestData(String key) {
        return Integer.parseInt(getTestData(key));
    }
}
