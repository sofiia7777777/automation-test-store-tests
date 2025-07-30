package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        By productName = By.cssSelector("td.align_left a");
        return waitForElementToLoad(productName).getText();
    }

    public String getProductPrice() {
        By productPrice = By.cssSelector("tr td:nth-child(6)");
        return waitForElementToLoad(productPrice).getText();
    }

    public CheckoutEntryPage clickCheckout(){
        find(By.id("cart_checkout1")).click();
        return new CheckoutEntryPage(driver);
    }
}
