package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ConsentsForm extends AbstractUIObject {
    @FindBy(css = "input[aria-label='Accept All']")
    ExtendedWebElement acceptAllBox;

    @FindBy(css = "input[aria-label='Sensitive Data Processing']")
    ExtendedWebElement sensitiveDataProcessingBox;

    @FindBy(css = "input[aria-label='Transfer Outside of Country/Region']")
    ExtendedWebElement transferOutsideOfCountryBox;

    @FindBy(css = "button[type='submit']")
    ExtendedWebElement submitButton;

    public ConsentsForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void acceptAll() {
        acceptAllBox.click();
    }

    public void sensitiveDataProcessing() {
        sensitiveDataProcessingBox.click();
    }

    public void transferOutsideOfCountry() {
        transferOutsideOfCountryBox.click();
    }

    public void finish(){
        submitButton.click();
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.stalenessOf(acceptAllBox), Duration.ofSeconds(20));
        return acceptAllBox.isVisible(1);
    }
}
