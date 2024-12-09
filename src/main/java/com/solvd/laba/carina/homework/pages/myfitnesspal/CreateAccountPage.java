package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.components.*;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.ModalOption;
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
    GoalConfirmation weightChangeConfirmation;


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
        goalsModal.clickOptionButton(goal);
    }

    public boolean isGoalClicked(Goal goal){
        return goalsModal.isOptionClicked(goal);
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

    /**
     * Returns true if current page has any buttons with value attribute.
     * @return True if option buttons are detected in page
     */
    public boolean isAnyGoalPage(){
        return new OptionModal(getDriver()).isModalPage();
    }

    /**
     * Acts as a proxy to OptionModal::clickOptionButton(ModalOption option)
     * Creates a dynamic locator for passed ModalOption, then attempts to click said button.
     * @param option The type of option to select
     */
    public void enterGoalOption(ModalOption option){
        OptionModal optionModal = new OptionModal(getDriver());
        optionModal.clickOptionButton(option);
        waitForJSToLoad();
    }

    /**
     * Acts as a proxy for OptionModal::isOptionClicked.
     * Creates a dynamic locator for passed ModalOption's button,
     * then checks if [aria-pressed=true] is present.
     * @param option The option that needs to be checked to have been clicked
     * @return if Goal button has been clicked
     */
    public boolean isGoalClicked(ModalOption option){
        OptionModal optionModal = new OptionModal(getDriver());
        return optionModal.isOptionClicked(option);
    }

    /**
     * Acts as proxy for OptionModal::clickSubmitButton.
     * Clicks submit button.
     */
    public void continueFromGoalPage(){
        OptionModal optionModal = new OptionModal(getDriver());
        optionModal.clickSubmitButton();
        waitForJSToLoad();
    }


    // After every goal options there is an affirmation page with the same interactive elements.
    // Following methods allow to maneuver from these pages.

    /**
     * Acts as a proxy for GoalConfirmation::isPageOpen.
     * Checks if there is any button in the page.
     * @return True if any button[value] elements are visible.
     */
    public boolean isGoalConfirmationPage(){
        return new GoalConfirmation(getDriver()).isPageOpen();
    }

    /**
     *
     */
    public void continueFromGoalConfirmationPage(){
        new GoalConfirmation(getDriver()).clickNextButton();
        waitForJSToLoad();
    }
}
