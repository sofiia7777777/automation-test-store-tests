package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import com.automationteststore.model.GuestCheckoutInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GuestCheckoutFormPage extends BasePage {

    public GuestCheckoutFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutForm(GuestCheckoutInfo info) {
        inputText(By.id("guestFrm_firstname"), info.getFirstName());
        inputText(By.id("guestFrm_lastname"), info.getLastName());
        inputText(By.id("guestFrm_email"), info.getEmail());
        inputText(By.id("guestFrm_address_1"), info.getAddress());
        inputText(By.id("guestFrm_city"), info.getCity());

        inputText(By.id("guestFrm_postcode"), info.getZipCode());

        Select countrySelect = new Select(find(By.id("guestFrm_country_id")));
        countrySelect.selectByVisibleText(info.getCountry());

        Select regionSelect = new Select(find(By.id("guestFrm_zone_id")));
        regionSelect.selectByVisibleText(info.getRegion());
    }

    public CheckoutConfirmationPage clickContinue(){
        find(By.xpath("//button[normalize-space()='Continue']")).click();
        return new CheckoutConfirmationPage(driver);
    }
}
