package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Height;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Weight;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;

public class Demographic_2 extends AbstractUIObject {
    private HeightUnitOptionSelector heightUnitOptionSelector;
    private WeightUnitOptionSelector weightUnitOptionSelector;

    /**
     * The button that appears below height inputs to change unit of measure
     */
    @FindBy(xpath="//label[contains(@for, 'Height')]/../../../following-sibling::button")
    private ExtendedWebElement heightUnitsChange;

    /**
     * The button that appears below weight inputs to change unit of measure
     */
    @FindBy(xpath="//label[contains(@for, 'weight')]/../../../following-sibling::button")
    private ExtendedWebElement weightUnitsChange;

    @FindBy(css = "nav > div > button[type='submit']")
    private ExtendedWebElement submitButton;

    public Demographic_2(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSubmitButton(){
        submitButton.click(3);
    }

    public boolean isPagePresent(){
        waitUntil(ExpectedConditions.stalenessOf(heightUnitsChange), Duration.ofSeconds(3));
        return heightUnitsChange.isPresent(1);
    }

    public void enterWeight(Account account){
        WeightUnitSelector selector;
        Weight weight = account.getWeight();

        switch(weightUnitOptionSelector){
            case KILOGRAM: getInput(WeightUnitSelector.KILOGRAM)
                    .type(String.valueOf(weight.getKilograms())); break;
            case POUND: getInput(WeightUnitSelector.POUND)
                    .type(String.valueOf(weight.getPounds(false))); break;
            case STONE:
                double[] stonesPounds = weight.getStonesPounds();

                String stones = String.valueOf(stonesPounds[0]);
                String pounds = String.valueOf(
                        BigDecimal.valueOf(stonesPounds[1]).setScale(2, RoundingMode.HALF_EVEN)
                );

                getInput(WeightUnitSelector.STONE).type(stones);
                getInput(WeightUnitSelector.POUND_STONE).type(pounds);
                break;
        }
    }

    public void enterGoalWeight(Account account){
        GoalWeightSelector selector;
        Weight weight = account.getGoalWeight();

        switch(weightUnitOptionSelector){
            case KILOGRAM: getInput(GoalWeightSelector.KILOGRAM)
                    .type(String.valueOf(weight.getKilograms())); break;
            case POUND: getInput(GoalWeightSelector.POUND)
                    .type(String.valueOf(weight.getPounds(false))); break;
            case STONE:
                double[] stonesPounds = weight.getStonesPounds();

                String stones = String.valueOf(stonesPounds[0]);
                String pounds = String.valueOf(
                        BigDecimal.valueOf(stonesPounds[1]).setScale(2, RoundingMode.HALF_EVEN)
                );

                getInput(GoalWeightSelector.STONE).type(stones);
                getInput(GoalWeightSelector.POUND_STONE).type(pounds);
                break;
        }
    }

    public void enterHeight(Account account){
        Height height = account.getHeight();

        switch(heightUnitOptionSelector){
            case CENTIMETER: getInput(HeightUnitSelector.CENTIMETER)
                    .type(String.valueOf(height.getCentimeters())); break;
            case FEET_INCH:
                String feet = String.valueOf(height.getFeet());
                String inch = String.valueOf(
                        BigDecimal.valueOf(height.getInches()).setScale(2, RoundingMode.HALF_EVEN)
                );

                getInput(HeightUnitSelector.FEET).type(feet);
                getInput(HeightUnitSelector.INCH).type(inch);
                break;
        }
    }

    public ExtendedWebElement getInput(SelectableItem option){
        return new ExtendedWebElement(
                By.cssSelector(String.format("input[name='%s']", option.getText())),
                option.getText(), getDriver(), getSearchContext());
    }

    public void clickHeightUnitChangeButton(){
        heightUnitsChange.click();
    }

    public void clickWeightUnitChangeButton(){
        weightUnitsChange.click();
    }

    public void setHeightUnitOptionSelector(HeightUnitOptionSelector heightUnitOptionSelector) {
        this.heightUnitOptionSelector = heightUnitOptionSelector;
    }

    public void setWeightUnitOptionSelector(WeightUnitOptionSelector weightUnitOptionSelector) {
        this.weightUnitOptionSelector = weightUnitOptionSelector;
    }
}
