package com.solvd.laba.carina.homework.pages.network_configuration_tool;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {
    @FindBy(css="#txt_Username")
    private ExtendedWebElement usernameInput;

    @FindBy(css="#txt_Password")
    private ExtendedWebElement passwordInput;

    @FindBy(css="#loginbutton")
    private ExtendedWebElement loginButton;

    @FindBy(css="#DivErrPromt")
    private ExtendedWebElement loginErrorMessage;

    public Login(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("http://192.168.1.254/");
    }

    public void enterUsername(String username) {
        usernameInput.type(username);
    }

    public String getEnteredUsername(){
        return usernameInput.getAttribute("value");
    }

    public void enterPassword(String password) {
        passwordInput.type(password);
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(getDriver());
    }

    public boolean errorMessageExists(){
        return loginErrorMessage.isPresent();
    }

    public String getLoginErrorMessage(){
        return loginErrorMessage.getText();
    }
}
