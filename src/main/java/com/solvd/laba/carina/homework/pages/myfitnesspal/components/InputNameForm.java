package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class InputNameForm extends AbstractUIObject {
    @FindBy(css = "input[data-testid=\"newName\"]")
    ExtendedWebElement nameInput;

    @FindBy(css = "div.css-ubj0kb > button")
    ExtendedWebElement nextButton;

    public InputNameForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void inputName(String name){
        nameInput.type(name);
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.invisibilityOf(nameInput), Duration.ofSeconds(3));
        return nameInput.isVisible(Duration.ofSeconds(1));
    }
}
