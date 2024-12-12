package com.solvd.laba.carina.homework.pages.myfitnesspal;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class, 'css-le7uux')]")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//iframe[contains(@title, 'SP Consent')]")
    private ExtendedWebElement cookiesIFrame;

    @FindBy(css = "a[href='/account/login']")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.myfitnesspal.com/");
        waitUntil(ExpectedConditions.presenceOfElementLocated(cookiesIFrame.getBy()), Duration.ofSeconds(10));
        waitForJSToLoad();
    }

    public CreateAccountPage clickSignUpButton() {
        signUpButton.scrollTo();
        signUpButton.click();
        return new CreateAccountPage(getDriver());
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

    public boolean processCookiesModal(){
        if (checkCookiesModal()) {
            clickAcceptCookiesButton();
        }
        return checkCookiesModal();
    }

    public LoggedOnPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return new LoggedOnPage(getDriver());
    }
}
