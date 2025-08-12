package com.automationteststore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CartPage.class);

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
        log.info("Proceeding to checkout");
        find(By.id("cart_checkout1")).click();
        return new CheckoutEntryPage(driver);
    }
}
