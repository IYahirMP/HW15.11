package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BigStep extends AbstractUIObject {
    @FindBy(css = "button>span")
    ExtendedWebElement continueButton;

    @FindBy(css = "a[href='/account/create/goals']")
    ExtendedWebElement backButton;

    public BigStep(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isPagePresent(){
        waitUntil(ExpectedConditions.invisibilityOf(backButton), Duration.ofSeconds(3));
        return backButton.isVisible(Duration.ofSeconds(3));
    }
}
