package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.model.Product;
import com.automationteststore.pages.*;
import com.automationteststore.service.GuestCheckoutInfoCreator;
import com.automationteststore.service.ProductCreator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrderTests extends BaseTest{

    @Test
    public void verifyUserCanPurchaseProductSuccessfully(){
        SoftAssert softAssert = new SoftAssert();

        Product expectedProduct = ProductCreator.createProduct();

        homePage.selectCategory(expectedProduct.getCategory());
        homePage.selectSubCategory(expectedProduct.getSubCategory());

        ProductPage product = homePage.selectProduct(expectedProduct.getName());
        CartPage cartPage = product.addToCart();

        CheckoutEntryPage checkoutEntryPage = cartPage.clickCheckout();
        GuestCheckoutFormPage guestCheckoutFormPage = checkoutEntryPage.selectGuestCheckoutAndContinue();

        GuestCheckoutInfo guestInfo = GuestCheckoutInfoCreator.withDefaultInfo();
        guestCheckoutFormPage.fillCheckoutForm(guestInfo);

        CheckoutConfirmationPage checkoutConfirmationPage = guestCheckoutFormPage.clickContinue();
        OrderCompletedPage orderCompletedPage = checkoutConfirmationPage.clickConfirmOrder();

        String confirmationMessage = orderCompletedPage.getMessage();

        softAssert.assertEquals(confirmationMessage, "Your order has been successfully processed!", "No confirmation message is displayed");
        softAssert.assertAll();
    }
}
