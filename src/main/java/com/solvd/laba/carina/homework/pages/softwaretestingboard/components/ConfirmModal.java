package com.solvd.laba.carina.homework.pages.softwaretestingboard.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * This class is intended to model the confirm modal pop-up found in magento.softwaretestingboard.com
 */

public class ConfirmModal extends AbstractUIObject {

    /** Confirm button*/
    @FindBy(css=".action-primary.action-accept")
    ExtendedWebElement confirmButton;

    /** Cancel button */
    @FindBy(css = ".action-secondary.action-dismiss")
    ExtendedWebElement cancelButton;

    /** Close button */
    @FindBy(css = ".action-close")
    ExtendedWebElement closeButton;

    /**
     *
     * @param driver The current driver
     * @param searchContext The current search context
     */
    public ConfirmModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public void clickCloseButton(){
        closeButton.click();
    }
}
