package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InstallPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/appview_install_button")
    private ExtendedWebElement installButton;

    @FindBy(id="cm.aptoide.pt:id/app_name")
    private ExtendedWebElement appName;

    public InstallPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(installButton);
    }

    public String getAppName() {
        return appName.getText();
    }
}
