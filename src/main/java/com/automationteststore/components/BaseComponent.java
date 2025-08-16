package com.automationteststore.components;

import com.automationteststore.core.actions.DefaultUIActions;
import com.automationteststore.core.base.BaseUIObject;
import com.automationteststore.core.decorator.LoggingUIActionsDecorator;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends BaseUIObject {

    protected BaseComponent(WebDriver driver) {
        super(driver, new LoggingUIActionsDecorator(new DefaultUIActions(driver)));
    }
}
