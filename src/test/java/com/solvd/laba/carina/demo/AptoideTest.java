package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.aptoide.*;
import com.solvd.laba.carina.homework.aptoide.objects.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class AptoideTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(testName = "testNavigationTabs")
    @MethodOwner(owner = "Ivan")
    public void testNavigationTabs(){
        Presentation presentationScreen = new Presentation(getDriver());
        presentationScreen.assertPageOpened(3);

        HomePage homePage = presentationScreen.tapSkipButton();
        homePage.assertPageOpened(3);

        CurationPage curationPage = homePage.goToCurationPage();
        curationPage.assertPageOpened(3);

        SearchPage searchPage = curationPage.goToSearchPage();
        searchPage.assertPageOpened(3);

        StoresPage storesPage = searchPage.goToStoresPage();
        storesPage.assertPageOpened(3);

        AppsPage appsPage = storesPage.goToAppsPage();
        appsPage.assertPageOpened(3);

        getDriver().quit();
    }

    @Test(testName = "testSearchFunction")
    @MethodOwner(owner = "Ivan")
    public void testSearchFunction(){
        Presentation presentationScreen = new Presentation(getDriver());
        presentationScreen.assertPageOpened(3);
        HomePage homePage = presentationScreen.tapSkipButton();
        homePage.assertPageOpened(3);

        SearchPage searchPage = homePage.goToSearchPage();
        searchPage.assertPageOpened(3);

        searchPage.enterQuery("Alarm");
        List<SearchResult> results = searchPage.getResults();
        boolean containsQuery = results.stream().anyMatch(result -> result.getName().toLowerCase().contains("alarm"));

        Assert.assertTrue(containsQuery, "Results don't contain the query text.");
        InstallPage installPage = searchPage.tapResult(0);

        installPage.assertPageOpened(3);
        Assert.assertEquals(installPage.getAppName(), results.get(0).getName(), "Result name mismatches the one shown on install page.");
    }

    @Test(testName = "testHomePage")
    @MethodOwner(owner="Ivan")
    public void testHomePage(){
        Presentation presentationScreen = new Presentation(getDriver());
        presentationScreen.assertPageOpened(3);
        HomePage homePage = presentationScreen.tapSkipButton();
        homePage.assertPageOpened(3);

        for (HomePageStaticElement element: HomePageStaticElement.values()){
            LOGGER.info("Testing for element {} to appear.", element.name());
            Assert.assertTrue(homePage.isElementVisible(element), String.format("Element %s could not be found.", element.name()));

            String elActualText = homePage.getStaticElementText(element);
            Assert.assertEquals(elActualText, element.getText(), String.format("Element text for %s is %s when it should be %s.", element.name() , elActualText, element.getText()));
            LOGGER.info("Text for element {} matches the UI.", element.name());
        }

        homePage.showGames();
        processCategoryElements(homePage, HomePage.Category.GAMES);

        homePage.showApps();
        processCategoryElements(homePage, HomePage.Category.APPS);
    }

    public void processCategoryElements(HomePage homePage, HomePage.Category category){
        StaticElement[] list = new StaticElement[]{};
        switch(category){
            case GAMES: list = HomePageGamesElements.values(); break;
            case APPS: list = HomePageAppsElements.values(); break;
        }

        for(StaticElement element: list){
            LOGGER.info("Testing for element {} to appear.", element.name());
            Assert.assertTrue(homePage.isCategoryElementVisible(element), String.format("Element %s could not be found.", element.name()));
            String elActualText = homePage.getCategoryElementText(element);
            Assert.assertEquals(elActualText, element.getText(), String.format("Element text for %s is %s when it should be %s.", element.name() , elActualText, element.getText()));
            LOGGER.info("Text for element {} matches the UI.", element.name());
        }
    }

    @Test(testName = "testStoresPage")
    @MethodOwner(owner = "Ivan")
    public void testStoresPage(){
        Presentation presentationScreen = new Presentation(getDriver());
        presentationScreen.assertPageOpened(3);
        HomePage homePage = presentationScreen.tapSkipButton();
        homePage.assertPageOpened(3);

        StoresPage storesPage = homePage.goToStoresPage();
        storesPage.assertPageOpened(3);

        for (StoresPageStaticElement element: StoresPageStaticElement.values()){
            LOGGER.info("Testing for element {} to appear.", element.name());
            Assert.assertTrue(storesPage.isElementVisible(element), String.format("Element %s could not be found.", element.name()));

            String elActualText = storesPage.getStaticElementText(element);
            Assert.assertEquals(elActualText, element.getText(), String.format("Element text is %s when it should be %s.", elActualText, element.getText()));
            LOGGER.info("Text for element {} matches the UI.", element.name());
        }
    }

    @Test(testName = "testAppsPage")
    @MethodOwner(owner = "Ivan")
    public void testAppsPage(){
        //This test is intended to fail as all the elements shown in the inspector
        //cannot be visualized on the app UI.
        SoftAssert sa = new SoftAssert();
        Presentation presentationScreen = new Presentation(getDriver());
        presentationScreen.assertPageOpened(3);
        HomePage homePage = presentationScreen.tapSkipButton();
        homePage.assertPageOpened(3);

        AppsPage appsPage = homePage.goToAppsPage();
        appsPage.assertPageOpened(3);

        for (AppPageStaticElement element: AppPageStaticElement.values()){
            LOGGER.info("Testing for element {} to appear.", element.name());

            boolean isVisible = appsPage.isElementVisible(element);
            sa.assertTrue(isVisible, String.format("Element %s could not be found.", element.name()));

            if(!isVisible){
                LOGGER.error("Element {} could not be found.", element.name());
                continue;
            }
            String elActualText = appsPage.getStaticElementText(element);
            sa.assertEquals(elActualText, element.getText(), String.format("Element text is %s when it should be %s.", elActualText, element.getText()));
            LOGGER.info("Text for element {} matches the UI.", element.name());
        }

        sa.assertAll();
    }
}
