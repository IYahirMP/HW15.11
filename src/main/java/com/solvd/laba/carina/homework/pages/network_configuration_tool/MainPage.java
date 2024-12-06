package com.solvd.laba.carina.homework.pages.network_configuration_tool;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(css="#headerLogoutText")
    private ExtendedWebElement endSessionButton;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageAbsoluteURL("http://192.168.1.254/index.asp");
        setUiLoadedMarker(endSessionButton);
        waitForJSToLoad();
    }


    public Login endSession() {
        endSessionButton.click();
        return new Login(getDriver());
    }
}
