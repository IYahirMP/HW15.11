package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoggedOnPage extends AbstractPage {
    @FindBy(xpath = "//p/a[contains(@href, '/profile/')]")
    private ExtendedWebElement profileName;

    @FindBy(css = "div[role='presentation']")
    private ExtendedWebElement reachGoalsFasterOverlay;

    public LoggedOnPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageAbsoluteURL("https://www.myfitnesspal.com/");
        setUiLoadedMarker(reachGoalsFasterOverlay);
    }

    public String getProfileName() {
        return profileName.getText();
    }
}
