package com.solvd.laba.carina.homework.aptoide;

import com.solvd.laba.carina.homework.aptoide.objects.HomePageStaticElement;
import com.solvd.laba.carina.homework.aptoide.objects.StaticElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BaseFrame{
    public enum Category {GAMES, APPS}

    @FindBy(id="cm.aptoide.pt:id/more_bundles_list")
    private ExtendedWebElement moreBundlesList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(getStaticElement(HomePageStaticElement.APPS_CHIP));
    }

    public void showGames(){
        tap(getStaticElement(HomePageStaticElement.GAMES_CHIP));
        waitUntil(ExpectedConditions.visibilityOfElementLocated(moreBundlesList.getBy()), Duration.ofSeconds(3).getSeconds());
    }

    public void showApps(){
        tap(getStaticElement(HomePageStaticElement.APPS_CHIP));
        waitUntil(ExpectedConditions.visibilityOfElementLocated(moreBundlesList.getBy()), Duration.ofSeconds(3).getSeconds());
    }

    public ExtendedWebElement getCategoryStaticElement(StaticElement element){
        return getStaticElement(element, moreBundlesList.getElement());
    }

    public String getCategoryElementText(StaticElement element){
        return getCategoryStaticElement(element).getText();
    }

    public boolean isCategoryElementVisible(StaticElement element){
        return getCategoryStaticElement(element).isVisible(1);
    }
}
