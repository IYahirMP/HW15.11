package com.solvd.laba.carina.homework.aptoide;

import com.solvd.laba.carina.homework.aptoide.objects.HomePageStaticElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BaseFrame{
    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getStaticElement(HomePageStaticElement.APPS_CHIP));
    }

    public boolean isElementVisible(HomePageStaticElement element){
        return getStaticElement(element).isVisible(1);
    }

    public ExtendedWebElement getStaticElement(HomePageStaticElement element){
        return new ExtendedWebElement(
                By.id(element.getId()),
                element.name(),
                getDriver(),
                mainContent.getElement());
    }

    public String getStaticElementText(HomePageStaticElement element){
        return getStaticElement(element).getText();
    }
}
