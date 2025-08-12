package com.automationteststore.pages;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.core.BaseUIObject;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseUIObject {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
    }
}
