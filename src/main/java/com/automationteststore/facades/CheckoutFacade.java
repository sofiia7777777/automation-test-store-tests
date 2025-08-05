package com.automationteststore.facades;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.checkout.CheckoutConfirmationPage;
import com.automationteststore.pages.checkout.CheckoutEntryPage;
import com.automationteststore.pages.checkout.GuestCheckoutFormPage;
import com.automationteststore.pages.checkout.OrderCompletedPage;
import org.openqa.selenium.WebDriver;

public class CheckoutFacade {
    private WebDriver driver;

    public CheckoutFacade(WebDriver driver) {
        this.driver = driver;
    }

    public OrderCompletedPage completeGuestCheckout(GuestCheckoutInfo guestInfo) {
        CartPage cartPage = new CartPage(driver);
        CheckoutEntryPage checkoutEntryPage = cartPage.clickCheckout();
        GuestCheckoutFormPage guestCheckoutFormPage = checkoutEntryPage.selectGuestCheckoutAndContinue();
        guestCheckoutFormPage.fillCheckoutForm(guestInfo);
        CheckoutConfirmationPage confirmationPage = guestCheckoutFormPage.clickContinue();

        return confirmationPage.clickConfirmOrder();
    }
}
