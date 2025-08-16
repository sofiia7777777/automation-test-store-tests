package com.automationteststore.core.actions;

import com.automationteststore.utils.WaitConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefaultUIActions implements UIActions{
    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = WaitConfig.getDefaultTimeout();
    private static final int FLUENT_WAIT_TIMEOUT = WaitConfig.getFluentWaitTimeout();
    private static final int FLUENT_WAIT_POLLING = WaitConfig.getFluentWaitPolling();

    public DefaultUIActions(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    @Override
    public void inputText(By locator, String text) {
        waitForElementToBeVisible(locator).sendKeys(text);
    }

    @Override
    public String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }



    private WebDriverWait getWait(int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    private WebDriverWait getWait() {
        return getWait(DEFAULT_TIMEOUT);
    }

    private WebElement waitForElementToBeVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    public WebElement waitForElementToLoad(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(FLUENT_WAIT_POLLING))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
