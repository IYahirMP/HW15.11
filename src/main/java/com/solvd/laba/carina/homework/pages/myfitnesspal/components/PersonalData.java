package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Country;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.ModalOption;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonalData extends AbstractUIObject {
    @FindBy(css="input[value='M']")
    ExtendedWebElement maleOption;

    @FindBy(css="input[value='F']")
    ExtendedWebElement femaleOption;

    @FindBy(css="input#birthday")
    ExtendedWebElement birthdaySelector;

    @FindBy(css="div[aria-labelledby=\"country-selector-label\"]")
    ExtendedWebElement countrySelector;

    @FindBy(css = "button[type='submit']")
    ExtendedWebElement submitButton;

    public PersonalData(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterGender(Account account){
        switch(account.getGender()){
            case MALE: maleOption.click(); break;
            case Female: femaleOption.click(); break;
        }
    }

    public void enterBirthDate(Account account){
        String birthDay = account.getBirthDay().format(DateTimeFormatter.ofPattern("MM/dd/yyy"));
        birthdaySelector.type(birthDay);
    }

    public void enterCountry(Account account){
        countrySelector.click();
        ExtendedWebElement countrySelector = getCountryButton(account.getCountry());
        countrySelector.click();
    }

    public ExtendedWebElement getCountryButton(Country option){
        return new ExtendedWebElement(
                By.cssSelector(String.format("li[role='option'][data-value='%s']", option.getValue())),
                option.name(),
                getDriver(),
                getSearchContext());
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public boolean isPagePresent(){
        waitUntil(ExpectedConditions.invisibilityOf(countrySelector), Duration.ofSeconds(3));
        return countrySelector.isVisible(1);
    }
}
