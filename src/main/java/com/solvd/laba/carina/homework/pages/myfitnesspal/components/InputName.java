package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InputName extends AbstractUIObject {
    @FindBy(css = "input[data-testid=\"newName\"]")
    ExtendedWebElement nameInput;

    @FindBy(css = "div.css-ubj0kb > button")
    ExtendedWebElement nextButton;

    public InputName(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void inputName(String name){
        nameInput.type(name);
    }

    public void clickNextButton(){
        nextButton.click();
    }
}
