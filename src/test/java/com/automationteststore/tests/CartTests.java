package com.automationteststore.tests;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.model.Product;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.ProductPage;
import com.automationteststore.service.ProductCreator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTests extends BaseTest{

    @Test
    public void verifyUserCanAddProductToCart(){
        SoftAssert softAssert = new SoftAssert();

        Product expectedProduct = ProductCreator.createProduct();

        homePage.selectCategory(expectedProduct.getCategory());
        homePage.selectSubCategory(expectedProduct.getSubCategory());

        ProductPage productPage = homePage.selectProduct(expectedProduct.getName());
        productPage.addToCart();

        HeaderComponent header = homePage.getHeaderComponent();
        CartPage cartPage = header.clickCart();

        String actualTitle = cartPage.getProductTitle();
        String actualPrice = cartPage.getProductPrice();

        softAssert.assertEquals(actualTitle, "Allegiant by Veronica Roth", "The Product Title is incorrect");
        softAssert.assertEquals(actualPrice, "$" + expectedProduct.getPrice(), "The Product Price is incorrect");
        softAssert.assertAll();
    }
}
