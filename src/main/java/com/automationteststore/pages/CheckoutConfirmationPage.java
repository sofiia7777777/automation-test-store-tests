package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutConfirmationPage extends BasePage {

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderCompletedPage clickConfirmOrder(){
        find(By.id("checkout_btn")).click();
        return new OrderCompletedPage(driver);
    }
}
