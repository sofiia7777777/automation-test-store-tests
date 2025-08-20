package com.automationteststore.stepdefinitions;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.facades.CheckoutFacade;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.checkout.OrderCompletedPage;
import com.automationteststore.service.GuestCheckoutInfoReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class OrderStepDefinitions {
    private final WebDriver driver;
    private final HomePage homePage;
    private CheckoutFacade checkoutFacade;
    private OrderCompletedPage orderCompletedPage;
    private GuestCheckoutInfo guestInfo;
    private final SoftAssert softAssert = new SoftAssert();

    public OrderStepDefinitions(CommonStepDefinitions commonSteps) {
        this.homePage = commonSteps.getHomePage();
        this.driver = commonSteps.getDriver();
    }

    @And("I proceed to checkout as guest")
    public void iProceedToCheckoutAsGuest() {
        HeaderComponent header = homePage.getHeaderComponent();
        header.clickCart();
        checkoutFacade = new CheckoutFacade(driver);
    }

    @And("I provide guest information")
    public void iProvideGuestInformation() {
        guestInfo = GuestCheckoutInfoReader.getUserCheckoutInfo();
    }

    @And("I confirm the order")
    public void iConfirmTheOrder() {
        orderCompletedPage = checkoutFacade.completeGuestCheckout(guestInfo);
    }

    @Then("^I should see the order confirmation message \"([^\"]+)\"$")
    public void iShouldSeeTheOrderConfirmationMessage(String expectedMessage) {
        String actualMessage = orderCompletedPage.getMessage();
        softAssert.assertEquals(actualMessage, expectedMessage, "No confirmation message is displayed");
        softAssert.assertAll();
    }
}
