package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreateUsernameForm extends AbstractUIObject {
    @FindBy(css = "input[id='Create a username']")
    ExtendedWebElement usernameInput;

    @FindBy(css = "button[type='submit']")
    ExtendedWebElement submitButton;

    public CreateUsernameForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterUsername(String username){
        usernameInput.type(username);
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.stalenessOf(usernameInput), Duration.ofSeconds(3));
        return usernameInput.isVisible(1);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
