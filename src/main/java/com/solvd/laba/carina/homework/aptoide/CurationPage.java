package com.solvd.laba.carina.homework.aptoide;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CurationPage extends BaseFrame{
    @FindBy(id="cm.aptoide.pt:id/editorial_list")
    private ExtendedWebElement editorialLIst;

    public CurationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(editorialLIst);
    }

    public boolean isOpened(){
        return isPageOpened();
    }
}
