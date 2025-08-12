package com.automationteststore.components;

import com.automationteststore.core.BaseUIObject;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends BaseUIObject {

    protected BaseComponent(WebDriver driver) {
        super(driver);
    }
}
