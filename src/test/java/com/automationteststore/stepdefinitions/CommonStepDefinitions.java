package com.automationteststore.stepdefinitions;

import com.automationteststore.hooks.Hooks;
import com.automationteststore.pages.HomePage;
import com.automationteststore.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CommonStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        driver.get("https://automationteststore.com/");
    }

    @When("^I select category \"([A-Z ]+)\" and subcategory \"(.+)\"$")
    public void iSelectCategoryAndSubcategory(String category, String subCategory) {
        homePage.selectCategory(category);
        homePage.selectSubCategory(subCategory);
    }

    @When("I select the product {string}")
    public void iSelectTheProduct(String productName) {
        productPage = homePage.selectProduct(productName);
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addToCart();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
