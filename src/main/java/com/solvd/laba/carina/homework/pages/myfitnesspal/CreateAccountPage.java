package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.components.*;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.WeightLossBarrier;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {
    @FindBy(css = "main.css-1udhdkt")
    Welcome welcomeModal;

    @FindBy(css = " main:has(span[aria-valuenow=\"8\"])")
    InputName nameInputModal;

    @FindBy(css = "main:has(span[aria-valuenow=\"15\"])")
    Goals goalsModal;

    @FindBy(xpath = " //a[@href=\"/account/create/goals\"]/../../..")
    BigStep bigstep;

    @FindBy(xpath = "//button[contains(@value, 'lack_of_time')]/../../../..")
    BarriersLose barriersLose;

    @FindBy(xpath = "//a[contains(@href, '/account/create/goals/')]/../..")
    WeightChangeConfirmation weightChangeConfirmation;




    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.myfitnesspal.com/account/create/");
        setPageURL("/welcome");
    }

    public void clickContinue(){
        if (welcomeModal.isElementPresent()){
            welcomeModal.clickContinueButton();
            return;
        }

        throw new RuntimeException(
                "Welcome modal is not present in the current page: "
                        + getDriver().getCurrentUrl()
        );
    }

    public void enterName(Account account){
        String name = account.getFirstName();
        nameInputModal.inputName(name);
        nameInputModal.clickNextButton();
    }

    public boolean isEnterNamePage(){
        return nameInputModal.isPagePresent();
    }

    public void enterGoals(Goal goal){
        switch(goal){
            case LOSE_WEIGHT: goalsModal.clickLoseWeightButton(); break;
            case MAINTAIN_WEIGHT: goalsModal.clickMaintainWeightButton(); break;
            case GAIN_WEIGHT: goalsModal.clickGainWeightButton(); break;
            case GAIN_MUSCLE: goalsModal.clickGainMuscleButton(); break;
            case MODIFY_DIET: goalsModal.clickModifyDietButton(); break;
            case MANAGE_STRESS: goalsModal.clickManageStressButton(); break;
            case INCREASE_STEP_COUNT:goalsModal.clickIncreaseStepCountButton(); break;
        }
    }

    public boolean isGoalClicked(Goal goal){
        return goalsModal.isGoalClicked(goal);
    }

    public void continueFromGoals(){
        goalsModal.clickSubmitButton();
    }

    public boolean isGoalsPage(){
        return goalsModal.isPagePresent();
    }

    public void continueFromBigStep(){
        bigstep.clickContinueButton();
    }

    public boolean isBigStepPage(){
        return bigstep.isPagePresent();
    }

    public void enterWeightLossBarriers(WeightLossBarrier barrier){
        switch(barrier){
            case LACK_OF_TIME: barriersLose.lackOfTimeButton(); break;
            case REGIME_HARD_TO_FOLLOW: barriersLose.hardRegimenButton(); break;
            case DID_NOT_ENJOY_FOOD: barriersLose.dietLacksVarietyButton(); break;
            case DIFFICULT_TO_CHOOSE_FOOD: barriersLose.foodChoiceStressButton(); break;
            case SOCIAL_EATING_EVENTS: barriersLose.holidaysVacationEventsButton(); break;
            case FOOD_CRAVINGS: barriersLose.foodCravingsButton(); break;
            case LACK_OF_PROGRESS: barriersLose.lackOfProgressButton(); break;
        }
    }

    public boolean isWeightLossBarrierClicked(WeightLossBarrier barrier){
        return barriersLose.isWeightLossBarrierClicked(barrier);
    }

    public void continueFromWeightLossBarriers(){
        barriersLose.clickSubmitButton();
    }

    public boolean isWeightLossBarriersPage(){
        return barriersLose.isPageOpen();
    }

    public void continueFromWeightChangeConfirmation(){
        weightChangeConfirmation.clickNextButton();
    }

    public boolean isWeightChangeConfirmationPage(){
        return weightChangeConfirmation.isPageOpen();
    }
}
