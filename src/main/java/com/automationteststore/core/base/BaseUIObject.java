package com.automationteststore.core.base;

import com.automationteststore.core.actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseUIObject {
    protected final UIActions ui;
    protected final WebDriver driver;

    protected BaseUIObject(WebDriver driver, UIActions ui) {
        this.driver = driver;
        this.ui = ui;
    }

    protected void click(By locator) {
        ui.click(locator);
    }

    protected void inputText(By locator, String text) {
        ui.inputText(locator, text);
    }

    protected String getText(By locator) {
        return ui.getText(locator);
    }

    protected WebElement find(By locator) {
        return ui.find(locator);
    }

    protected WebElement waitForElementToLoad(By locator) {
        return ui.waitForElementToLoad(locator);
    }
}
