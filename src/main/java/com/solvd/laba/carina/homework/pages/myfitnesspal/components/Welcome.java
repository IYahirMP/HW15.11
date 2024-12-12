package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Welcome extends AbstractUIObject {
    @FindBy(css = "div > button")
    ExtendedWebElement continueButton;

    public Welcome(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
