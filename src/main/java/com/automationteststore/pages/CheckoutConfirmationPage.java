package com.automationteststore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutConfirmationPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CheckoutConfirmationPage.class);

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderCompletedPage clickConfirmOrder(){
        log.info("Confirming order");
        find(By.id("checkout_btn")).click();
        return new OrderCompletedPage(driver);
    }
}
