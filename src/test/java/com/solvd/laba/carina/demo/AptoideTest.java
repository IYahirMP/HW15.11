package com.solvd.laba.carina.demo;

import com.solvd.laba.carina.homework.aptoide.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AptoideTest implements IAbstractTest, IMobileUtils {
    @Test()
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
}
