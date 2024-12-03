package com.solvd.laba.carina.homework.pages.softwaretestingboard;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopCard extends AbstractUIObject {
    @FindBy(css = ".size .swatch-option")
    private List<ExtendedWebElement> sizeSelectors;

    @FindBy(css = ".color .swatch-option")
    private List<ExtendedWebElement> colorSelectors;

    @FindBy(css = ".action.tocart.primary")
    private ExtendedWebElement toCartButtons;

    @FindBy(css = ".product.name.product-item-name")
    private ExtendedWebElement productName;

    public ShopCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSizeSelector(int i){
        sizeSelectors.get(i).click();
    }

    public void clickColorSelector(int i){
        colorSelectors.get(i).click();
    }

    public void clickToCart(){
        toCartButtons.click();
    }

    public String getProductName(){
        return productName.getText();
    }
}
