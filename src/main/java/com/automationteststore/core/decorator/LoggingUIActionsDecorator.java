package com.automationteststore.core.decorator;

import com.automationteststore.core.actions.UIActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoggingUIActionsDecorator implements UIActions {
    private final UIActions wrapped;
    private static final Logger log = LogManager.getLogger(LoggingUIActionsDecorator.class);

    public LoggingUIActionsDecorator(UIActions wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void click(By locator) {
        log.trace("Clicking element: {}", locator);
        wrapped.click(locator);
    }

    @Override
    public void inputText(By locator, String text) {
        log.trace("Typing into element: {} Text: {}", locator, text);
        wrapped.inputText(locator, text);
    }

    @Override
    public String getText(By locator) {
        log.trace("Getting text from element: {}", locator);
        return wrapped.getText(locator);
    }

    @Override
    public WebElement find(By locator) {
        return wrapped.find(locator);
    }

    @Override
    public WebElement waitForElementToLoad(By locator) {
        return wrapped.waitForElementToLoad(locator);
    }
}
