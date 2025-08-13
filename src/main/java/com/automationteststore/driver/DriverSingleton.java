package com.automationteststore.driver;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            String browser = System.getProperty("browser");

            if (browser == null) {
                throw new IllegalStateException("Browser type is not specified!");
            }

            driver = BrowserFactory.createDriver(browser);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
