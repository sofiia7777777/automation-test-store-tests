package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.ProductPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTests extends BaseTest{

    @Test
    public void verifyUserCanAddProductToCart(){
        SoftAssert softAssert = new SoftAssert();
        homePage.selectCategory("BOOKS");
        homePage.selectSubCategory("Paperback");
        ProductPage product = homePage.selectProduct("ALLEGIANT BY VERONICA ROTH");
        product.addToCart();
        HeaderComponent header = homePage.getHeaderComponent();
        CartPage cartPage = header.clickCart();
        String productTitle = cartPage.getProductTitle();
        String productPrice = cartPage.getProductPrice();

        softAssert.assertEquals(productTitle, "Allegiant by Veronica Roth", "The Product Title is incorrect");
        softAssert.assertEquals(productPrice, "$7.99", "The Product Price is incorrect");
        softAssert.assertAll();
    }
}
