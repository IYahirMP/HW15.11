package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BigStepModal extends AbstractUIObject {
    @FindBy(css = "div>button[type='submit']")
    ExtendedWebElement continueButton;

    @FindBy(css = "a[href='/account/create/goals']")
    ExtendedWebElement backButton;

    public BigStepModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickContinueButton() {
        waitUntil(ExpectedConditions.visibilityOf(continueButton), Duration.ofSeconds(20));
        continueButton.click(Duration.ofSeconds(3));
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.invisibilityOf(backButton), Duration.ofSeconds(3));
        return backButton.isVisible(Duration.ofSeconds(3));
    }
}
