package com.solvd.laba.carina.homework.pages.softwaretestingboard;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class MenJacketsPage extends AbstractPage {
    @FindBy(css=".action.showcart")
    private ExtendedWebElement cartButton;

    @FindBy(css="block-minicart")
    private ExtendedWebElement cart;

    @Context(dependsOn = "cart")
    @FindBy(xpath="//*[@class='product-item-details']/*[1]")
    private List<ExtendedWebElement> cartProductNames;

    @FindBy(xpath="//div[contains(@class, 'product-item-details')]")
    private List<ExtendedWebElement> productCards;

    @Context(dependsOn = "productCards")
    @FindBy(css = ".swatch-attribute.size")
    private List<ExtendedWebElement> sizeSelectors;

    @Context(dependsOn = "productCards")
    @FindBy(css = ".swatch-attribute.color")
    private List<ExtendedWebElement> colorSelectors;

    @Context(dependsOn = "productCards")
    @FindBy(css = ".action.tocart.primary")
    private List<ExtendedWebElement> toCartButtons;

    @Context(dependsOn = "productCards")
    @FindBy(css = ".product.name.product-item-name")
    private List<ExtendedWebElement> productNames;

    public MenJacketsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
    }

    public void addToCart(int itemNo){
        System.out.println("CHECKING ITEM NO. " + itemNo);
        productNames.get(itemNo).scrollTo();
        productCards.get(itemNo).hover(20,20);
        sizeSelectors.get(itemNo)
                .findExtendedWebElements(By.cssSelector(".swatch-option.text"))
                .get(0).click();
        colorSelectors.get(itemNo)
                .findExtendedWebElements(By.cssSelector(".swatch-option.color"))
                .get(0).click();
        toCartButtons.get(itemNo).click();
    }

    public boolean checkIfInCart(int itemNo){
        cartButton.scrollTo();
        cartButton.click();
        Optional<ExtendedWebElement> itemInCart = cartProductNames.stream().filter(
                (a) -> a.getText().equals(productNames.get(itemNo).getText())
        ).findFirst();
        cartButton.click();

        return itemInCart.isPresent();
    }
}
