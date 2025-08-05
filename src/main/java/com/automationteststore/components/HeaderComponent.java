package com.automationteststore.components;

import com.automationteststore.core.base.BaseComponent;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderComponent extends BaseComponent {
    private static final Logger log = LogManager.getLogger(HeaderComponent.class);

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginOrRegister(){
        log.info("Clicking 'Login or register' button");
        click(By.cssSelector("#customer_menu_top a"));
        return new LoginPage(driver);
    }

    public CartPage clickCart() {
        log.info("Opening Cart Page");
        click(By.id("cart"));
        return new CartPage(driver);
    }

    public String getWelcomeMessage() {
        return getText(By.cssSelector("#customernav div"));
    }

    public boolean isUserLoggedIn() {
        String href = find(By.cssSelector("#customer_menu_top a")).getAttribute("href");
        return href.contains("account/account");
    }
}
