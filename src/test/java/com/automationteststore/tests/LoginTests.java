package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.model.User;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.service.UserCreator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BaseTest{

    @Test
    public void verifyUserCanSuccessfullyLoginWithValidCredentials(){
        SoftAssert softAssert = new SoftAssert();

        HeaderComponent header = homePage.getHeaderComponent();
        LoginPage loginPage = header.clickLoginOrRegister();

        User testUser = UserCreator.withCredentialsFromEnvironment();
        loginPage.login(testUser);

        String welcomeMessage = header.getWelcomeMessage();
        boolean isUserLoggedIn = header.isUserLoggedIn();

        softAssert.assertEquals(welcomeMessage, "Welcome back " + testUser.getUsername(), "The Welcome Message is incorrect");
        softAssert.assertTrue(isUserLoggedIn, "User is not logged in");
        softAssert.assertAll();
    }
}
