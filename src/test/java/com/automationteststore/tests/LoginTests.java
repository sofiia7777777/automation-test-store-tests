package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BaseTest{

    @Test
    public void verifyUserCanSuccessfullyLoginWithValidCredentials(){
        SoftAssert softAssert = new SoftAssert();
        HeaderComponent header = homePage.getHeaderComponent();
        LoginPage loginPage = header.clickLoginOrRegister();
        loginPage.loginAs("James", "123456");
        String welcomeMessage = header.getWelcomeMessage();
        boolean isUserLoggedIn = header.isUserLoggedIn();

        softAssert.assertEquals(welcomeMessage, "Welcome back James", "The Welcome Message is incorrect");
        softAssert.assertTrue(isUserLoggedIn, "User is not logged in");
        softAssert.assertAll();
    }
}
