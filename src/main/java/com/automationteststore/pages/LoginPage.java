package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAs(String username, String password) {
        inputText(By.id("loginFrm_loginname"), username);
        inputText(By.id("loginFrm_password"), password);
        click(By.xpath("//button[normalize-space()='Login']"));
    }
}
