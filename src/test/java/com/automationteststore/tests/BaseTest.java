package com.automationteststore.tests;

import com.automationteststore.driver.DriverSingleton;
import com.automationteststore.pages.HomePage;
import com.automationteststore.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected final String URL = "https://automationteststore.com/";
    protected HomePage homePage;


    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}