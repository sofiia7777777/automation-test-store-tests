package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String text) {
        log.info("Selecting category: " + text);
        By categoryLink = By.linkText(text);
        click(categoryLink);
    }

    public void selectSubCategory(String text) {
        log.info("Selecting subcategory: " + text);
        By categoryLink = By.linkText(text);
        click(categoryLink);
    }

    public ProductPage selectProduct(String text) {
        log.info("Selecting product: " + text);
        By productLink = By.linkText(text);
        waitForElementToLoad(productLink).click();
        return new ProductPage(driver);
    }
}
