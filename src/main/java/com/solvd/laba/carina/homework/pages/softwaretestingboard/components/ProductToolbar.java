package com.solvd.laba.carina.homework.pages.softwaretestingboard.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductToolbar extends AbstractUIObject {
    public enum SorterOptions{
        //POSITION("Position"),
        NAME("Product Name"),
        PRICE("Price");

        private final String name;
        public String getName() {
            return name;
        }

        SorterOptions(String name){
            this.name = name;
        }
    }

    @FindBy(css=".sorter-label")
    ExtendedWebElement sorterLabel;

    @FindBy(css=".sorter-options")
    ExtendedWebElement sorterSelector;

    @FindBy(css=".sort-desc")
    ExtendedWebElement sortDescending;

    @FindBy(css=".sort-asc")
    ExtendedWebElement sortAscending;

    /**
     * Default constructor
     *
     * @param driver The current driver
     * @param searchContext The search context
     */
    public ProductToolbar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getSorterLabel(){
        return sorterLabel.getText();
    }

    public void clickAscendingOrder(){
        sortAscending.scrollTo();
        sortAscending.clickIfPresent();
    }

    public void clickDescendingOrder(){
        sortAscending.scrollTo();
        sortDescending.clickIfPresent();
    }

    public void selectSortingOption(SorterOptions sortOption){
        sorterSelector.scrollTo();
        sorterSelector.select(sortOption.getName());
    }
}
