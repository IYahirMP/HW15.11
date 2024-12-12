package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.components.*;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.HeightUnitOptionSelector;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.WeightUnitOptionSelector;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.WeightUnitSelector;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.HeightUnitSelector;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreateAccountPage extends AbstractPage {
    @FindBy(css = "main.css-1udhdkt")
    Welcome welcomeModal;

    @FindBy(css = " main:has(span[aria-valuenow=\"8\"])")
    InputName nameInputModal;

    @FindBy(css = "main:has(span[aria-valuenow=\"15\"])")
    Goals goalsModal;

    @FindBy(xpath = " //a[@href=\"/account/create/goals\"]/../../..")
    BigStep bigstep;

    @FindBy(xpath = "//input[@value='M']/../../../../../..")
    Demographic_1 demographics1;

    @FindBy(xpath= "//input[contains(@name, 'height')]/../../../../../../..")
    Demographic_2 demographics2;

    @FindBy(css="div[role='presentation']")
    ExtendedWebElement unitChangeModal;
    /**
     * This button appears whenever we try to change units at demographics-2
     * Whether it is height or weight, the modal that appears has this button.
     */
    @Context(dependsOn = "unitChangeModal")
    @FindBy(css="button[type=\"submit\"]")
    private ExtendedWebElement unitsChangeSubmitButton;

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
        return new OptionSelectionScreen(getDriver()).isModalPage();
    }

    /**
     * Creates a dynamic locator for passed ModalOption, then attempts to click said button.
     * @param option The type of option to select
     */
    public void enterGoalOption(SelectableItem option){
        OptionSelectionScreen optionModal = new OptionSelectionScreen(getDriver());
        optionModal.clickOptionButton(option);
        waitForJSToLoad();
    }

    /**
     * Creates a dynamic locator for passed ModalOption's button,
     * then checks if [aria-pressed=true] is present.
     * @param option The option that needs to be checked to have been clicked
     * @return true if Goal button has been clicked
     */
    public boolean isGoalClicked(SelectableItem option){
        OptionSelectionScreen optionModal = new OptionSelectionScreen(getDriver());
        return optionModal.isOptionClicked(option);
    }

    /**
     * Acts as proxy for OptionModal::clickSubmitButton.
     * Clicks submit button.
     */
    public void continueFromGoalPage(){
        OptionSelectionScreen optionModal = new OptionSelectionScreen(getDriver());
        optionModal.clickSubmitButton();
        waitForJSToLoad();
    }


    // After every goal options there is an affirmation page with the same interactive elements.
    // Following methods allow to maneuver from these pages.

    /**
     * Checks if the current page is that of an affirmation page that follows from a goal selection page.
     * Affirmation pages have a URL with the pattern
     * https://www.myfitnesspal.com/account/create/goals/{the-goal}/affirmation
     * @return True if any button[value] elements are visible.
     */
    public boolean isGoalConfirmationPage(){
        return new GoalConfirmation(getDriver()).isPageOpen();
    }

    /**
     * Clicks the continue button within any affirmation page that follows a Goal option selection page.
     * Affirmation pages have a URL with the pattern
     * https://www.myfitnesspal.com/account/create/goals/{the-goal}/affirmation
     */
    public void continueFromGoalConfirmationPage(){
        new GoalConfirmation(getDriver()).clickNextButton();
        waitForJSToLoad();
    }

    /**
     *  Enters data for first demographics data screen
     *  at url https://www.myfitnesspal.com/account/create/demographic-1
     *  which covers birthdate, country and gender.
     *
     * @param account The account to get data from
     * @return true if Demographics-1 screen has passed
     */
    public boolean enterDemographicsFirstScreen(Account account){
        demographics1.enterBirthDate(account);
        demographics1.enterCountry(account);
        demographics1.enterGender(account);
        demographics1.clickSubmitButton();

        return !demographics1.isPagePresent();
    }

    /**
     *  Enters data for second demographics data screen
     *  at url https://www.myfitnesspal.com/account/create/demographic-2
     *  which covers height, weight, and the goal weight.
     *
     * @param account The account to get data from
     * @return true if Demographics-2 screen has passed
     */
    public boolean enterDemographicsSecondsScreen(Account account){
        HeightUnitOptionSelector currentHUnit = HeightUnitOptionSelector.CENTIMETER;
        WeightUnitOptionSelector currentWUnit = WeightUnitOptionSelector.STONE;

        demographics2.clickWeightUnitChangeButton();
        setWeightUnit(currentWUnit);
        demographics2.enterWeight(account);
        demographics2.enterGoalWeight(account);

        demographics2.clickHeightUnitChangeButton();
        setHeightUnit(currentHUnit);
        demographics2.enterHeight(account);

        demographics2.clickSubmitButton();

        return !demographics2.isPagePresent();
    }

    /**
     * Clicks button below height input to open modal, then selects heightUnit option, then closes modal.
     * @param heightUnit The height unit to select.
     */
    public void setHeightUnit(HeightUnitOptionSelector heightUnit){
        getHeightUnitChangeOption(heightUnit).click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(unitsChangeSubmitButton.getBy()), Duration.ofSeconds(3));
        unitsChangeSubmitButton.click();
        demographics2.setHeightUnitOptionSelector(heightUnit);
    }

    /**
     * Clicks button below weight input to open modal, then selects heightUnit option, then closes modal.
     * @param weightUnit The weight unit to select.
     */
    public void setWeightUnit(WeightUnitOptionSelector weightUnit){
        getWeightUnitChangeOption(weightUnit).click();
        waitUntil(ExpectedConditions.visibilityOf(unitsChangeSubmitButton), Duration.ofSeconds(3));
        unitsChangeSubmitButton.click();
        demographics2.setWeightUnitOptionSelector(weightUnit);
    }

    public ExtendedWebElement getHeightUnitChangeOption(HeightUnitOptionSelector unit){
        return new ExtendedWebElement(
                By.xpath(String.format("//div[@aria-label=\"Change Height Units\"]/label[%d]",
                        unit.getOptionNumber())),
                unit.getText(), getDriver(), unitChangeModal.getSearchContext());
    }

    public ExtendedWebElement getWeightUnitChangeOption(WeightUnitOptionSelector unit){
        return new ExtendedWebElement(
                By.xpath(String.format("//div[@aria-label=\"Change Weight Units\"]/label[%d]",
                        unit.getOptionNumber())),
                unit.getText(), getDriver(), unitChangeModal.getSearchContext());
    }
}
