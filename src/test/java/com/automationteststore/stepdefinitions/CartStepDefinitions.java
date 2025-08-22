package com.automationteststore.stepdefinitions;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.HomePage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class CartStepDefinitions {
    private final HomePage homePage;
    private CartPage cartPage;
    private final SoftAssert softAssert = new SoftAssert();

    public CartStepDefinitions(CommonStepDefinitions commonSteps) {
        this.homePage = commonSteps.getHomePage();
    }

    @Then("I should see the product {string} in my cart")
    public void iShouldSeeTheProductInMyCart(String expectedTitle) {
        HeaderComponent header = homePage.getHeaderComponent();
        cartPage = header.clickCart();
        String actualTitle = cartPage.getProductTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "The Product Title is incorrect");
    }

    @Then("^the product price should be (\\$[0-9]+\\.[0-9]{2})$")
    public void theProductPriceShouldBe(String expectedPrice) {
        String actualPrice = cartPage.getProductPrice();
        softAssert.assertEquals(actualPrice, expectedPrice, "The Product Price is incorrect");
        softAssert.assertAll();
    }
}
