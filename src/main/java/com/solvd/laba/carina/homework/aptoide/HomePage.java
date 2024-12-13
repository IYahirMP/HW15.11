package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/app_bar_layout")
    private ExtendedWebElement appBar;

    @FindBy(id="cm.aptoide.pt:id/main_home_container_content")
    private ExtendedWebElement homeContainer;

    @FindBy(id="cm.aptoide.pt:id/featured_graphic_list")
    private ExtendedWebElement featuredList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(featuredList);
    }

    public boolean isOpened(){
        return isPageOpened();
    }
}
