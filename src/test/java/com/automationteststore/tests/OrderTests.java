package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrderTests extends BaseTest{

    @Test
    public void verifyUserCanPurchaseProductSuccessfully(){
        SoftAssert softAssert = new SoftAssert();
        homePage.selectCategory("BOOKS");
        homePage.selectSubCategory("Paperback");
        ProductPage product = homePage.selectProduct("ALLEGIANT BY VERONICA ROTH");
        CartPage cartPage = product.addToCart();
        CheckoutEntryPage checkoutEntryPage = cartPage.clickCheckout();
        GuestCheckoutFormPage guestCheckoutFormPage = checkoutEntryPage.selectGuestCheckoutAndContinue();
        GuestCheckoutInfo guestInfo = new GuestCheckoutInfo(
                "James", "Smith", "james@example.com",
                "123 Main St", "Bristol", "444117", "Bristol", "United Kingdom"
        );
        guestCheckoutFormPage.fillCheckoutForm(guestInfo);
        CheckoutConfirmationPage checkoutConfirmationPage = guestCheckoutFormPage.clickContinue();
        OrderCompletedPage orderCompletedPage = checkoutConfirmationPage.clickConfirmOrder();
        String confirmationMessage = orderCompletedPage.getMessage();

        softAssert.assertEquals(confirmationMessage, "Your order has been successfully processed!", "No confirmation message is displayed");
        softAssert.assertAll();
    }
}
