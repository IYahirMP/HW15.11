package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.aptoide.*;
import com.solvd.laba.carina.homework.aptoide.objects.HomePageStaticElement;
import com.solvd.laba.carina.homework.aptoide.objects.SearchResult;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AptoideTest implements IAbstractTest, IMobileUtils {
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
            Assert.assertTrue(homePage.isElementVisible(element), String.format("Element %s could not be found.", element.name()));

            String elActualText = homePage.getStaticElementText(element);
            Assert.assertEquals(elActualText, element.getText(), String.format("Element text is %s when it should be %s.", elActualText, element.getText()));
        }
    }
}
