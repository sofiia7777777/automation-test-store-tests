package com.automationteststore.tests;

import com.automationteststore.facades.CheckoutFacade;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.model.Product;
import com.automationteststore.pages.*;
import com.automationteststore.pages.checkout.OrderCompletedPage;
import com.automationteststore.service.GuestCheckoutInfoReader;
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
        product.addToCart();

        CheckoutFacade checkoutFacade = new CheckoutFacade(driver);
        GuestCheckoutInfo guestInfo = GuestCheckoutInfoReader.getUserCheckoutInfo();
        OrderCompletedPage orderCompletedPage = checkoutFacade.completeGuestCheckout(guestInfo);

        String confirmationMessage = orderCompletedPage.getMessage();

        softAssert.assertEquals(confirmationMessage, "Your order has been successfully processed!", "No confirmation message is displayed");
        softAssert.assertAll();
    }
}
