package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage extends BasePage {

    public OrderCompletedPage(WebDriver driver) {
        super(driver);
    }

    public String getMessage(){
        String message = waitForElementToLoad(By.cssSelector(".contentpanel section p:nth-child(3)")).getText().trim();
        return message;
    }
}
