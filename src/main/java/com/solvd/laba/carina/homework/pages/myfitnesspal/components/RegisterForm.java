package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegisterForm extends AbstractUIObject {
    @FindBy(css = "input[name='email']")
    ExtendedWebElement emailInput;

    @FindBy(css = "input[name='password']")
    ExtendedWebElement passwordInput;

    @FindBy(css = "input[name='termsConsent']")
    ExtendedWebElement termsConsentBox;

    @FindBy(css = "button[type='submit']")
    ExtendedWebElement submitButton;

    public RegisterForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterEmail(String email) {
        emailInput.type(email);
    }

    public void enterPassword(String password) {
        passwordInput.type(password);
    }

    public void checkTermsConsent() {
        termsConsentBox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.stalenessOf(emailInput), Duration.ofSeconds(3));
        return emailInput.isVisible(1);
    }
}
