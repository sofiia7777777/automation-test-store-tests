package com.automationteststore.utils;

import com.automationteststore.service.TestDataReader;

public class WaitConfig {

    private static final int DEFAULT_TIMEOUT = TestDataReader.getIntTestData("default.timeout");
    private static final int FLUENT_WAIT_TIMEOUT = TestDataReader.getIntTestData("fluent.wait.timeout");
    private static final int FLUENT_WAIT_POLLING = TestDataReader.getIntTestData("fluent.wait.polling");

    public static int getDefaultTimeout() {
        return DEFAULT_TIMEOUT;
    }

    public static int getFluentWaitTimeout() {
        return FLUENT_WAIT_TIMEOUT;
    }

    public static int getFluentWaitPolling() {
        return FLUENT_WAIT_POLLING;
    }
}
