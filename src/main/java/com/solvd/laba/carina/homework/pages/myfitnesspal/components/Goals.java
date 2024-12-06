package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Goals extends AbstractUIObject {
    @FindBy(css = "button[value='lose_weight']")
    ExtendedWebElement loseWeightButton;

    @FindBy(css = "button[value='maintain_weight']")
    ExtendedWebElement maintainWeightButton;

    @FindBy(css = "button[value='gain_weight']")
    ExtendedWebElement gainWeightButton;

    @FindBy(css = "button[value='gain_muscle']")
    ExtendedWebElement gainMuscleButton;

    @FindBy(css = "button[value='modify_diet']")
    ExtendedWebElement modifyDietButton;

    @FindBy(css = "button[value='manage_stress']")
    ExtendedWebElement manageStressButton;

    @FindBy(css = "button[value='increase_step_count']")
    ExtendedWebElement increaseStepCountButton;

    @FindBy(css = "div>button[type='submit']")
    ExtendedWebElement submitButton;

    public Goals(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickLoseWeightButton() {
        loseWeightButton.click();
    }

    public void clickMaintainWeightButton() {
        maintainWeightButton.click();
    }

    public void clickGainWeightButton() {
        gainWeightButton.click();
    }

    public void clickGainMuscleButton() {
        gainMuscleButton.click();
    }

    public void clickModifyDietButton() {
        modifyDietButton.click();
    }

    public void clickManageStressButton() {
        manageStressButton.click();
    }

    public void clickIncreaseStepCountButton() {
        increaseStepCountButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isGoalClicked(Goal goal){
        boolean value = false;

        switch(goal){
            case LOSE_WEIGHT:
                value = loseWeightButton.getAttribute("aria-pressed").equals("true");
                break;
            case MAINTAIN_WEIGHT:
                value = maintainWeightButton.getAttribute("aria-pressed").equals("true");
                break;
            case GAIN_WEIGHT:
                value = gainWeightButton.getAttribute("aria-pressed").equals("true");
                break;
            case GAIN_MUSCLE:
                value = gainMuscleButton.getAttribute("aria-pressed").equals("true");
                break;
            case MODIFY_DIET:
                value = modifyDietButton.getAttribute("aria-pressed").equals("true");
                break;
            case MANAGE_STRESS:
                value = manageStressButton.getAttribute("aria-pressed").equals("true");
                break;
            case INCREASE_STEP_COUNT:
                value = increaseStepCountButton.getAttribute("aria-pressed").equals("true");
                break;
        }

        return value;
    }
}
