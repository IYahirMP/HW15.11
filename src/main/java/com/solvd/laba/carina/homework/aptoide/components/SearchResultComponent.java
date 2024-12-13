package com.solvd.laba.carina.homework.aptoide.components;

import com.solvd.laba.carina.homework.aptoide.objects.SearchResult;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultComponent extends AbstractUIObject implements IAndroidUtils, IMobileUtils {
    @FindBy(xpath="//*[contains(@resource-id, 'app_name')]")
    private ExtendedWebElement appName;

    public SearchResultComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getAppName() {
        return appName.getText();
    }

    public void tapResult(){
        tap(appName);
    }

    public SearchResult getResult(){
        return new SearchResult(getAppName());
    }
}
