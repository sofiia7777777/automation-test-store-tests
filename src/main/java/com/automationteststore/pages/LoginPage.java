package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import com.automationteststore.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
        log.info("Login started for user: " + user.getUsername());

        log.debug("Entering username: " + user.getUsername());
        inputText(By.id("loginFrm_loginname"), user.getUsername());

        log.debug("Entering password: " + user.getPassword());
        inputText(By.id("loginFrm_password"), user.getPassword());

        log.info("Clicking Login button");
        click(By.xpath("//button[normalize-space()='Login']"));
    }
}
