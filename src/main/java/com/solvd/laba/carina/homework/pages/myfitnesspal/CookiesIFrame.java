package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CookiesIFrame extends AbstractPage {
    @FindBy(xpath="//button[@title='OK']")
    private ExtendedWebElement acceptCookiesButton;

    public CookiesIFrame(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    public void acceptCookiesButton(){
        acceptCookiesButton.click();
    }
}
