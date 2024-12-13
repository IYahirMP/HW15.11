package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/trending_list")
    private ExtendedWebElement trendingList;

    @FindBy(id="cm.aptoide.pt:id/search_src_text")
    private ExtendedWebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    public boolean isOpened(){
        return isPageOpened();
    }
}
