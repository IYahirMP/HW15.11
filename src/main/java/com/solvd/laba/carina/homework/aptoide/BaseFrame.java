package com.solvd.laba.carina.homework.aptoide;

import com.solvd.laba.carina.homework.aptoide.objects.StaticElement;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BaseFrame extends MobileAbstractPage implements IAndroidUtils {
    @FindBy(id="cm.aptoide.pt:id/action_home")
    protected ExtendedWebElement homeButton;

    @FindBy(id="cm.aptoide.pt:id/action_curation")
    protected ExtendedWebElement curationButton;

    @FindBy(id="cm.aptoide.pt:id/action_search")
    protected ExtendedWebElement searchButton;

    @FindBy(id="cm.aptoide.pt:id/action_stores")
    protected ExtendedWebElement storesButton;

    @FindBy(id="cm.aptoide.pt:id/action_apps")
    protected ExtendedWebElement appsButton;

    @FindBy(id="cm.aptoide.pt:id/fragment_placeholder")
    protected ExtendedWebElement mainContent;

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

    public boolean isOpened(){
        return isPageOpened();
    }

    public boolean isElementVisible(StaticElement element){
        return getStaticElement(element).isVisible(1);
    }

    public boolean isElementVisible(StaticElement element, SearchContext context){
        return getStaticElement(element, context).isVisible(1);
    }

    public ExtendedWebElement getStaticElement(StaticElement element){
        return new ExtendedWebElement(
                By.id(element.getId()),
                element.name(),
                getDriver(),
                mainContent.getElement());
    }

    public ExtendedWebElement getStaticElement(StaticElement element, SearchContext context){
        return new ExtendedWebElement(
                By.id(element.getId()),
                element.name(),
                getDriver(),
                context);
    }

    public String getStaticElementText(StaticElement element){
        return getStaticElement(element).getText();
    }

    public String getStaticElementText(StaticElement element, SearchContext context){
        return getStaticElement(element, context).getText();
    }
}
