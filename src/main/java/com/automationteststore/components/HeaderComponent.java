package com.automationteststore.components;

import com.automationteststore.core.BaseComponent;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderComponent extends BaseComponent {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginOrRegister(){
        click(By.cssSelector("#customer_menu_top a"));
        return new LoginPage(driver);
    }

    public CartPage clickCart() {
        click(By.id("cart"));
        return new CartPage(driver);
    }

    public String getWelcomeMessage() {
        return getText(By.cssSelector("#customernav div"));
    }

    public boolean isUserLoggedIn() {
        String href = find(By.cssSelector("#customer_menu_top a"))
                .getAttribute("href");
        return href.contains("account/account");
    }
}
