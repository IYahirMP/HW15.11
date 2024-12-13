package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Presentation extends MobileAbstractPage {
    @FindBy(id = "cm.aptoide.pt:id/skip_button")
    ExtendedWebElement skipButton;

    public Presentation(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(skipButton);
    }

    public HomePage tapSkipButton() {
        this.tap(skipButton);
        return new HomePage(driver);
    }

    public boolean isOpened(){
        return this.isPageOpened();
    }
}
