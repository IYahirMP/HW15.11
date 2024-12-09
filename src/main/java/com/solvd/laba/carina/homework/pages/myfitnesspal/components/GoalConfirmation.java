package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GoalConfirmation extends AbstractUIObject {
    @FindBy(css = "button[type='submit']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//a[contains(@href, 'options')]")
    private ExtendedWebElement backButton;

    public GoalConfirmation(WebDriver driver) {
        super(driver);
    }

    public GoalConfirmation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickNextButton() {
        nextButton.click();
    }
    public void clickBackButton() {
        backButton.click();
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.invisibilityOf(backButton), Duration.ofSeconds(3));
        return backButton.isVisible(1);
    }
}
