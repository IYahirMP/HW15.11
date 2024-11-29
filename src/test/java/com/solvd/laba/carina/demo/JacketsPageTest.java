package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.softwaretestingboard.MenJacketsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JacketsPageTest implements IAbstractTest {

    @Test
    @MethodOwner(owner="ivan")
    @TestPriority(Priority.P0)
    @TestLabel(name="login", value={"successful login"})
    public void testAddToCart(){
        MenJacketsPage page = new MenJacketsPage(getDriver());
        page.open();
        page.assertPageOpened();

        SoftAssert softAssert = new SoftAssert();

        for(int i = 0; i < 3; i++){
            page.addToCart(i);
            page.waitForJSToLoad();
            softAssert.assertTrue(page.checkIfInCart(i));
        }

        softAssert.assertAll();
    }
}
