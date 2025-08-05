package com.automationteststore.core.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface UIActions {
    void click(By locator);
    void inputText(By locator, String text);
    String getText(By locator);

    WebElement find(By locator);
    WebElement waitForElementToLoad(By locator);
}
