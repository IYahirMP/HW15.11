package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BaseFrame extends MobileAbstractPage {
    @FindBy(id="cm.aptoide.pt:id/action_home")
    ExtendedWebElement homeButton;

    @FindBy(id="cm.aptoide.pt:id/action_curation")
    ExtendedWebElement curationButton;

    @FindBy(id="cm.aptoide.pt:id/action_search")
    ExtendedWebElement searchButton;

    @FindBy(id="cm.aptoide.pt:id/action_stores")
    ExtendedWebElement storesButton;

    @FindBy(id="cm.aptoide.pt:id/action_apps")
    ExtendedWebElement appsButton;

    public BaseFrame(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        homeButton.click();
        return new HomePage(getDriver());
    }

    public CurationPage goToCurationPage() {
        curationButton.click();
        return new CurationPage(getDriver());
    }

    public SearchPage goToSearchPage() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public StoresPage goToStoresPage() {
        storesButton.click();
        return new StoresPage(getDriver());
    }

    public AppsPage goToAppsPage() {
        appsButton.click();
        return new AppsPage(getDriver());
    }
}
