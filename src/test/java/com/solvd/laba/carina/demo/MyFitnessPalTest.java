package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.myfitnesspal.HomePage;
import com.solvd.laba.carina.homework.pages.myfitnesspal.CreateAccountPage;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MyFitnessPalTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @DataProvider
    public Object[][] accountDataFeed(){
        return new Object[][] {
            {
                new Account("Ivan")
                        .addGoal(Goal.LOSE_WEIGHT)
                        .addGoalOption(Goal.LOSE_WEIGHT, WeightLossBarrier.FOOD_CRAVINGS)
                        /*.addGoal(Goal.INCREASE_STEP_COUNT)
                        .addGoalOption(Goal.INCREASE_STEP_COUNT, StepsRange.MORE_THAN_7000)
                        .addGoal(Goal.MODIFY_DIET)
                        .addGoalOption(Goal.MODIFY_DIET, NutritionFocus.FEWER_CARBS)
                        .addGoalOption(Goal.MODIFY_DIET, NutritionFocus.MORE_FRUITS_AND_VEGETABLES)
                        .addGoalOption(Goal.MODIFY_DIET, NutritionFocus.MORE_PROTEIN)*/
                        .setActivityLevel(1)
                        .setCountry(Country.MEXICO)
                        .setBirthDay("2002-08-31")
                        .setGender(Gender.MALE)
            },
                {
                new Account("Yahir")
                        .addGoal(Goal.MAINTAIN_WEIGHT)
                        .addGoalOption(Goal.MAINTAIN_WEIGHT, WeightMaintenanceBarrier.COOKING_HARD)
                        .addGoal(Goal.MANAGE_STRESS)
                        .addGoalOption(Goal.MANAGE_STRESS, StressReliefActivity.NOTHING_HELPS)
                        .setActivityLevel(2)
                        .setCountry(Country.ARGENTINA)
                        .setBirthDay("2002-10-22")
                        .setGender(Gender.MALE)
            }
        };
    }

    @Test(dataProvider = "accountDataFeed")
    @TestPriority(Priority.P0)
    @TestLabel(name = "Feature", value = {"SignUp"})
    public void testSignUp(Account account){
        HomePage homepage = new HomePage(getDriver());
        LOGGER.trace("Opening https://www.myfitnesspal.com");
        homepage.open();
        LOGGER.trace("Assert page is opened");
        homepage.assertPageOpened();

        LOGGER.trace("Attempt to click Accept cookies button");
        if (homepage.checkCookiesModal()) {
            homepage.clickAcceptCookiesButton();
        }
        LOGGER.trace("Assert that cookies modal has been dismissed");
        Assert.assertFalse(homepage.checkCookiesModal(), "Cookies message could not be dismissed.");

        LOGGER.trace("Attempt to click sign up button.");
        CreateAccountPage createAccountPage = homepage.clickSignUpButton();

        LOGGER.trace("Attempt to click Continue button.");
        createAccountPage.clickContinue();

        LOGGER.trace("Attempt to submit first name");
        createAccountPage.enterName(account);
        LOGGER.trace("Assert that first name page step has been completed");
        Assert.assertFalse(createAccountPage.isEnterNamePage(), "Enter name page could not be completed correctly.");

        LOGGER.trace("Attempt to submit goals");
        for (Goal goal : account.getGoals()) {
            createAccountPage.enterGoals(goal);
            Assert.assertTrue(createAccountPage.isGoalClicked(goal));
        }

        if (account.getGoals().size() < 3){
            createAccountPage.continueFromGoals();
        }

        LOGGER.trace("Assert that goal page step has been completed");
        Assert.assertFalse(createAccountPage.isGoalsPage(), "Goal page could not be completed correctly.");

        LOGGER.trace("Attempts to continue from BigStep page");
        createAccountPage.continueFromBigStep();
        LOGGER.trace("Assert that goal page step has been completed");
        Assert.assertFalse(createAccountPage.isBigStepPage(), "BigStep page could not be completed correctly.");

        LOGGER.trace("Attempt to process each goal's options");
        List<Goal> orderedGoals = account.getGoals().stream().sorted(Comparator.comparingInt(Enum::ordinal)).collect(Collectors.toList());
        for (Goal goal : orderedGoals) {
            processGoal(account, createAccountPage, goal);
        }

        LOGGER.trace("Attempting to set baseline activity level");
        createAccountPage.enterGoalOption(account.getActivityLevel());
        createAccountPage.continueFromGoalPage();
        LOGGER.trace("Assert that goal page step has been completed");

        LOGGER.trace("Attempts to enter personal data.");
        boolean personalDataPagePassed = createAccountPage.enterPersonalData(account);
        LOGGER.trace("Asserts that personal data page has been completed correctly");
        Assert.assertFalse(personalDataPagePassed, "Personal data page could not be completed correctly.");
    }

    public void processGoal(Account account, CreateAccountPage createAccountPage, Goal goal){
        LOGGER.trace("Attempts to submit {}", goal.name());
        for (ModalOption option : account.getCollectionByGoal(goal)) {
            createAccountPage.enterGoalOption(option);
            Assert.assertTrue(createAccountPage.isGoalClicked(option));
        }

        // INCREASE_STEP_COUNT is an exceptional case
        // Where selecting at least one value triggers redirection to next page
        if (account.getWeightLossBarriers().size() < goal.getOptions() && goal != Goal.INCREASE_STEP_COUNT){
            createAccountPage.continueFromGoalPage();
        }

        LOGGER.trace("Assert that {} barriers page step has been completed", goal.name());
        Assert.assertFalse(createAccountPage.isAnyGoalPage(), String.format("%s page could not be completed correctly.", goal.name()));

        LOGGER.trace("Attempting to continue from {} confirmation dialogue", goal.name());
        createAccountPage.continueFromGoalConfirmationPage();

        LOGGER.trace("Assert that {} confirmation dialogue has been completed", goal.name());
        Assert.assertFalse(createAccountPage.isGoalConfirmationPage(),
                String.format("%s affirmation dialogue could not be completed correctly.", goal.name()));
    }
}
