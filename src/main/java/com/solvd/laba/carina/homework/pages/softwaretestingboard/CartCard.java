package com.solvd.laba.carina.homework.pages.softwaretestingboard;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartCard extends AbstractUIObject {
    /** Cart product name
     *  Name of a product currently in the cart
     */
    @FindBy(css=".product-item-name")
    private ExtendedWebElement productName;

    /** Delete button
     * Delete button for a product currently in the cart
     */
    @FindBy(css = ".delete")
    private ExtendedWebElement deleteButton;

    public CartCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickDelete(){
        deleteButton.click();
    }
}
