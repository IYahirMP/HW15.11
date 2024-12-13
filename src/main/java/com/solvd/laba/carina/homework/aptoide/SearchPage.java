package com.solvd.laba.carina.homework.aptoide;

import com.solvd.laba.carina.homework.aptoide.components.SearchResultComponent;
import com.solvd.laba.carina.homework.aptoide.objects.SearchResult;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/trending_list")
    private ExtendedWebElement trendingList;

    @FindBy(id="cm.aptoide.pt:id/search_src_text")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = resultsXpath)
    private List<SearchResultComponent> allStoresAppList;
    private final String resultsXpath = "//*[contains(@resource-id,'all_stores_app_list')]/*";


    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    public boolean isOpened(){
        return isPageOpened();
    }

    public void enterQuery(String query){
        searchInput.type(query);
        pressKeyboardKey(AndroidKey.ENTER);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(resultsXpath)), Duration.ofSeconds(3).getSeconds());
    }

    public List<SearchResult> getResults(){
        List<SearchResult> results = new ArrayList<>();

        for(SearchResultComponent result : allStoresAppList){
            results.add(result.getResult());
        }

        return results;
    }

    public InstallPage tapResult(int resultIndex){
        allStoresAppList.get(resultIndex).tapResult();
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(searchInput.getBy()), Duration.ofSeconds(3).getSeconds());
        return new InstallPage(driver);
    }
}
