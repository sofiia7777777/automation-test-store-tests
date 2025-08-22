package com.automationteststore.stepdefinitions;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.model.User;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.LoginPage;
import com.automationteststore.service.UserCreator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class LoginStepDefinitions {
    private HomePage homePage;
    private final HeaderComponent header;
    private LoginPage loginPage;

    private final SoftAssert softAssert = new SoftAssert();

    public LoginStepDefinitions(CommonStepDefinitions commonSteps) {
        this.homePage = commonSteps.getHomePage();
        this.header = homePage.getHeaderComponent();
    }

    @When("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage = header.clickLoginOrRegister();
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        User testUser = UserCreator.withCredentialsFromEnvironment();
        loginPage.login(testUser);
    }

    @Then("I should see a welcome message with my username")
    public void iShouldSeeAWelcomeMessageWithMyUsername() {
        String welcomeMessage = header.getWelcomeMessage();
        User testUser = UserCreator.withCredentialsFromEnvironment();
        softAssert.assertEquals(welcomeMessage, "Welcome back " + testUser.getUsername(), "The Welcome Message is incorrect");
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        softAssert.assertTrue(header.isUserLoggedIn(), "User is not logged in");
        softAssert.assertAll();
    }
}
