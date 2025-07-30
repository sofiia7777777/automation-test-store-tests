package com.automationteststore.pages;

import com.automationteststore.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutEntryPage extends BasePage {

    public CheckoutEntryPage(WebDriver driver) {
        super(driver);
    }

    public GuestCheckoutFormPage selectGuestCheckoutAndContinue() {
        find(By.id("accountFrm_accountguest")).click();
        find(By.xpath("//button[normalize-space()='Continue']")).click();
        return new GuestCheckoutFormPage(driver);
    }
}
