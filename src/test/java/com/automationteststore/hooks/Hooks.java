package com.automationteststore.hooks;

import com.automationteststore.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
