package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCart() {
        By addToCartButton = By.xpath("//a[normalize-space()='Add to Cart']");
        click(addToCartButton);
        return new CartPage(driver);
    }
}
