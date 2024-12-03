package com.solvd.laba.carina.homework.pages.softwaretestingboard;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenJacketsPage extends AbstractPage {

    //Cart elements

    /** Cart button with icon  */
    @FindBy(css=".action.showcart")
    private ExtendedWebElement cartButton;

    /**Cart counter
     * Display number of items currently in the cart
     */
    @FindBy(css=".counter-number")
    private ExtendedWebElement cartProductCounter;

    /** Cart wrapper
     * Appears only if cart button is clicked
     *  */
    @FindBy(css=".block-minicart")
    private ShopCart cart;

    /** Confirm delete modal */
    @FindBy(css=".modal-popup.confirm._show")
    private ConfirmModal confirmModal;

    // Inside main content

    /** Product cards
     *  Product cards shown in the main content
     */
    @FindBy(css=".products.list .product-item")
    private List<ShopCard> productCards;


    @FindBy(xpath="//div[contains(@class, 'toolbar-products')][1]")
    private ProductToolbar productToolbar;

    public MenJacketsPage(WebDriver driver) {
        super(driver);
        setPageLoadTimeout(driver, Duration.ofSeconds(60));
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
    }

    public void addToCart(int itemNo){
        System.out.println("CHECKING ITEM NO. " + itemNo);

        ShopCard pc = productCards.get(itemNo);

        pc.scrollTo();
        pc.hover(20,20);
        pc.clickSizeSelector(0);
        pc.clickColorSelector(0);
        pc.clickToCart();
        waitForJSToLoad();
    }

    public void removeFromCart(int itemNo){
        cartButton.scrollTo();
        cartButton.click();

        System.out.println("CHECKING ITEM NO. " + itemNo);
        ShopCard pc = productCards.get(itemNo);
        cart.removeItem(pc.getProductName());
        waitForJSToLoad();

        confirmModal.clickConfirmButton();
        waitForJSToLoad();

        cartButton.click();
    }

    public boolean checkIfInCart(int itemNo){
        cartButton.scrollTo();
        cartButton.click();
        waitForJSToLoad();
        Optional<String> itemInCart = cart.getProductNames().stream().filter(
                (a) -> a.equals(productCards.get(itemNo).getProductName())
        ).findFirst();
        cartButton.click();

        return itemInCart.isPresent();
    }

    public boolean horizontalScroll(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

        return (boolean) jsExecutor.executeScript(
                "return (window.innerWidth < document.body.scrollWidth);"
        );
    }

    public boolean verticalScroll(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

        return (boolean) jsExecutor.executeScript(
                "return (window.innerHeight < document.body.scrollHeight);"
        );
    }

    public int cartCounterNumber(){
        if (cartProductCounter.isPresent()) {
                return !cartProductCounter.getText().isEmpty()
                    ? Integer.parseInt(cartProductCounter.getText())
                    : 0;
        }
        throw new RuntimeException("Cart counter not found");
    }

    public int elementsInCart(){
        return cart.getProductCount();
    }

    public void sort(ProductToolbar.SorterOptions option){
        productToolbar.selectSortingOption(option);
    }

    public List<String> getProductNames(){
        return productCards.stream().map(ShopCard::getProductName).collect(Collectors.toList());
    }

    public List<Double> getProductPrice(){
        return productCards.stream().map(ShopCard::getPrice).collect(Collectors.toList());
    }
}
