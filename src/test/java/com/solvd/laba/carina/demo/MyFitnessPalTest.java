package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.myfitnesspal.Home;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

public class MyFitnessPalTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @TestPriority(Priority.P0)
    @TestLabel(name = "Feature", value = {"SignUp"})
    public void testSignUp(){
        Home homepage = new Home(getDriver());
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
        homepage.clickSignUpButton();
        sleep();
    }

    public void sleep(){
        try{
            wait(1000 * 3);
        }catch(Exception e){

        }
    }
}
