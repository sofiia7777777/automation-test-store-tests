package com.automationteststore.driver;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            String browser = System.getProperty("browser");
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
