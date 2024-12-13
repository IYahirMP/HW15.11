package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StoresPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/store_tab_follow_store_layout")
    private ExtendedWebElement followStoreButton;

    public StoresPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(followStoreButton);
    }

    public boolean isOpened(){
        return isPageOpened();
    }
}
