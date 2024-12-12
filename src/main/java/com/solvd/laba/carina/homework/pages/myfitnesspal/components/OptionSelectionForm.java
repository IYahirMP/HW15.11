package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class OptionSelectionForm extends AbstractUIObject {
    @FindBy(css = "div>button[type='submit']")
    ExtendedWebElement submitButton;

    @FindBy(css = "button[value]")
    ExtendedWebElement someButton;


    public OptionSelectionForm(WebDriver driver) {
        super(driver);
    }

    public OptionSelectionForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public void clickSubmitButton() {
        submitButton.click();
    }

    public ExtendedWebElement getDynamicButton(SelectableItem option){
        return new ExtendedWebElement(
                By.cssSelector(String.format("button[value='%s']", option.getText())),
                option.getText(),
                getDriver(),
                getSearchContext());
    }

    public void clickOptionButton(SelectableItem option){
        ExtendedWebElement barrierButton = getDynamicButton(option);
        barrierButton.clickByJs();
    }

    public boolean isOptionClicked(SelectableItem option){
        ExtendedWebElement barrierButton = getDynamicButton(option);
        return barrierButton
                .getAttribute("aria-pressed")
                .equals("true");
    }

    public boolean isModalPage(){
        waitUntil(ExpectedConditions.invisibilityOf(someButton), Duration.ofSeconds(30));
        return someButton.isVisible(1);
    }
}
