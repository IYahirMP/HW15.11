package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.myfitnesspal.HomePage;
import com.solvd.laba.carina.homework.pages.myfitnesspal.CreateAccountPage;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Account;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.WeightLossBarrier;
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
import java.util.ArrayList;
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
                        //.addGoal(Goal.GAIN_MUSCLE)
                        //.addGoal(Goal.MODIFY_DIET)
                        .addGoal(Goal.LOSE_WEIGHT)
                        .addWeightLossBarrier(WeightLossBarrier.FOOD_CRAVINGS)
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


        List<Goal> orderedGoals = account.getGoals().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for (Goal goal : account.getGoals()) {
            switch(goal){
                case LOSE_WEIGHT: processWeightLossGoal(account, createAccountPage);
                case MAINTAIN_WEIGHT: processWeightMaintainGoal(account, createAccountPage);
                case GAIN_WEIGHT: processWeightGainGoal(account, createAccountPage);
                case GAIN_MUSCLE:processGainMuscleGoal(account, createAccountPage);
                case MODIFY_DIET:processModifyDietGoal(account, createAccountPage);
                case MANAGE_STRESS:processManageStressGoal(account, createAccountPage);
                case INCREASE_STEP_COUNT:processIncreaseStepCount(account, createAccountPage);
            }
        }
    }

    public void processWeightLossGoal(Account account, CreateAccountPage createAccountPage){
        LOGGER.trace("Attempts to submit weight loss barriers");
        for (WeightLossBarrier barrier : account.getWeightLossBarriers()) {
            createAccountPage.enterWeightLossBarriers(barrier);
            Assert.assertTrue(createAccountPage.isWeightLossBarrierClicked(barrier));
        }

        if (account.getWeightLossBarriers().size() < 7){
            createAccountPage.continueFromWeightLossBarriers();
        }

        LOGGER.trace("Assert that weight loss barriers page step has been completed");
        Assert.assertFalse(createAccountPage.isWeightLossBarriersPage(), "Weight loss barriers page could not be completed correctly.");
    }

    public void processWeightGainGoal(Account account, CreateAccountPage createAccountPage){}

    public void processWeightMaintainGoal(Account account, CreateAccountPage createAccountPage){}

    public void processGainMuscleGoal(Account account, CreateAccountPage createAccountPage){}

    public void processModifyDietGoal(Account account, CreateAccountPage createAccountPage){}

    public void processManageStressGoal(Account account, CreateAccountPage createAccountPage){}

    public void processIncreaseStepCount(Account account, CreateAccountPage createAccountPage){}

    public void sleep(){
        try{
            Thread.sleep(1000 * 3);
        }catch(Exception e){

        }
    }
}
