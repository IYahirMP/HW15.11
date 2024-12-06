package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Home extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class, 'css-le7uux')]")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//iframe[contains(@title, 'SP Consent')]")
    private ExtendedWebElement cookiesIFrame;

    public Home(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.myfitnesspal.com/");
        waitUntil(ExpectedConditions.presenceOfElementLocated(cookiesIFrame.getBy()), Duration.ofSeconds(10));
        waitForJSToLoad();
    }

    public void clickSignUpButton() {
        signUpButton.scrollTo();
        signUpButton.click();
    }

    public boolean checkCookiesModal(){
        return cookiesIFrame.isPresent(Duration.ofSeconds(3));
    }

    public void clickAcceptCookiesButton() {
        CookiesIFrame cookies = new CookiesIFrame(getDriver());

        getDriver().switchTo().frame(cookiesIFrame.getElement());
        cookies.acceptCookiesButton();
        getDriver().switchTo().defaultContent();
    }
}
