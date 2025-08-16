package com.automationteststore.pages;

import com.automationteststore.components.HeaderComponent;
import com.automationteststore.core.actions.DefaultUIActions;
import com.automationteststore.core.base.BaseUIObject;
import com.automationteststore.core.decorator.LoggingUIActionsDecorator;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseUIObject {

    protected BasePage(WebDriver driver) {
        super(driver, new LoggingUIActionsDecorator(new DefaultUIActions(driver)));
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
    }
}
