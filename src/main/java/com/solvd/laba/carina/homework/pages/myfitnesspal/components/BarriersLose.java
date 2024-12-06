package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.WeightLossBarrier;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BarriersLose extends AbstractUIObject {
    @FindBy(css = "button[value='lack_of_time_lose']")
    ExtendedWebElement lackOfTimeButton;

    @FindBy(css = "button[value='regimen_hard_lose']")
    ExtendedWebElement hardRegimenButton;

    @FindBy(css = "button[value='diet_lacks_variety_lose']")
    ExtendedWebElement dietLacksVarietyButton;

    @FindBy(css = "button[value='food_choice_stress_lose']")
    ExtendedWebElement foodChoiceStressButton;

    @FindBy(css = "button[value='holidays_vacation_events_lose']")
    ExtendedWebElement holidaysVacationEventsButton;

    @FindBy(css = "button[value='food_cravings_lose']")
    ExtendedWebElement foodCravingsButton;

    @FindBy(css = "button[value='lack_of_progress_lose']")
    ExtendedWebElement lackOfProgressButton;

    @FindBy(css = "div>button[type='submit']")
    ExtendedWebElement submitButton;

    public BarriersLose(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void lackOfTimeButton() {
        lackOfTimeButton.click();
    }

    public void hardRegimenButton() {
        hardRegimenButton.click();
    }

    public void dietLacksVarietyButton() {
        dietLacksVarietyButton.click();
    }

    public void foodChoiceStressButton() {
        foodChoiceStressButton.click();
    }

    public void holidaysVacationEventsButton() {
        holidaysVacationEventsButton.click();
    }

    public void foodCravingsButton() {
        foodCravingsButton.click();
    }

    public void lackOfProgressButton() {
        lackOfProgressButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isPageOpen(){
        waitUntil(ExpectedConditions.invisibilityOf(foodCravingsButton), Duration.ofSeconds(3));
        return foodCravingsButton.isPresent(Duration.ofSeconds(1));
    }

    public boolean isWeightLossBarrierClicked(WeightLossBarrier barrier){
        boolean value = false;

        switch(barrier){
            case LACK_OF_TIME:
                value = lackOfTimeButton.getAttribute("aria-pressed").equals("true");
                break;
            case LACK_OF_PROGRESS:
                value = lackOfProgressButton.getAttribute("aria-pressed").equals("true");
                break;
            case REGIME_HARD_TO_FOLLOW:
                value = hardRegimenButton.getAttribute("aria-pressed").equals("true");
                break;
            case DID_NOT_ENJOY_FOOD:
                value = dietLacksVarietyButton.getAttribute("aria-pressed").equals("true");
                break;
            case DIFFICULT_TO_CHOOSE_FOOD:
                value = foodChoiceStressButton.getAttribute("aria-pressed").equals("true");
                break;
            case SOCIAL_EATING_EVENTS:
                value = holidaysVacationEventsButton.getAttribute("aria-pressed").equals("true");
                break;
            case FOOD_CRAVINGS:
                value = foodCravingsButton.getAttribute("aria-pressed").equals("true");
                break;
        }

        return value;
    }
}
