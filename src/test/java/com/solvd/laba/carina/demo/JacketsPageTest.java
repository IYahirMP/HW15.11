package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.pages.softwaretestingboard.MenJacketsPage;
import com.solvd.laba.carina.homework.pages.softwaretestingboard.ProductToolbar;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Comparator;
import java.util.stream.Collectors;

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
            softAssert.assertTrue(page.checkIfInCart(i), String.format("The item number %d is not in the cart.", i));
        }

        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner="Ivan")
    @TestPriority(Priority.P0)
    public void removeProductsFromCart(){
        MenJacketsPage page = new MenJacketsPage(getDriver());
        page.open();
        page.assertPageOpened(Duration.ofSeconds(60));

        SoftAssert sa = new SoftAssert();


        for(int i = 0; i < 3; i++){
            page.addToCart(i);
            sa.assertTrue(page.checkIfInCart(i), String.format("The item number %d is not in the cart.", i));
        }

        sa.assertTrue(page.elementsInCart() == 3, "Wrong number of elements in the cart");
        sa.assertTrue(page.cartCounterNumber() == 3, "Wrong number in cart's product counter");

        for(int i = 2; i >= 0; i--){
            page.removeFromCart(i);
            sa.assertFalse(page.checkIfInCart(i), "Item %d should not be in the car");
        }

        sa.assertTrue(page.elementsInCart() == 0, "Elements in cart should be 0, but a different number was found");
        sa.assertTrue(page.cartCounterNumber() == 0, "Expected 0 in cart's product counter, but found a different number");

        sa.assertAll();
    }

    @Test
    public void testVerticalScroll() {
        MenJacketsPage page = new MenJacketsPage(getDriver());
        page.open();
        page.assertPageOpened();

        Assert.assertTrue(page.verticalScroll(), "Not vertically scrollable");
    }

    @Test
    public void testHorizontalScroll() {
        MenJacketsPage page = new MenJacketsPage(getDriver());
        page.open();
        page.assertPageOpened();

        Assert.assertTrue(page.horizontalScroll(), "Not horizontally scrollable");
    }

    @Test
    public void testSort(){
        MenJacketsPage page = new MenJacketsPage(getDriver());
        page.open();
        page.assertPageOpened();

        SoftAssert sa = new SoftAssert();

        for(ProductToolbar.SorterOptions option: ProductToolbar.SorterOptions.values()){
            page.sort(option);

            switch(option){
                case PRICE:{
                   sa.assertTrue(page.getProductPrice().equals(
                            page.getProductPrice()
                                    .stream()
                                    .sorted(Double::compareTo)
                                    .collect(Collectors.toList())
                    ));
                   break;
                }
                case NAME:{
                    sa.assertTrue(page.getProductNames().equals(
                            page.getProductNames()
                                    .stream()
                                    .sorted(Comparator.naturalOrder())
                                    .collect(Collectors.toList())
                    ));
                    break;
                }
            }
        }
        sa.assertAll();
    }
}
