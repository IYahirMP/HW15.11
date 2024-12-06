package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.components.*;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAccountPage extends AbstractPage {
    @FindBy(css = "main.css-1udhdkt")
    Welcome welcomeModal;

    @FindBy(css = " main:has(span[aria-valuenow=\"8\"])")
    InputName nameInputModal;

    //CHANGE THIS
    @FindBy(css = "main:has(span[aria-valuenow=\"15\"])")
    Goals goalsModal;

    @FindBy(css = " main:has(span[aria-valuenow=\"18\"])")
    BigStep bigstep;

    @FindBy(css = "main:has(span[aria-valuenow=\"24\"])")
    Barriers barriers;



    //CHANGE THIS


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

    public boolean isGoalsPage(){
        return goalsModal.isPagePresent();
    }

    public void continueFromBigStep(){
        bigstep.clickContinueButton();
    }

    public boolean isBigStepPage(){
        return bigstep.isPagePresent();
    }
}
