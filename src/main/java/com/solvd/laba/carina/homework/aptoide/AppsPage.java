package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AppsPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/fragment_apps_recycler_view")
    private ExtendedWebElement appsRecyclerView;

    public AppsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(appsRecyclerView);
    }
}
