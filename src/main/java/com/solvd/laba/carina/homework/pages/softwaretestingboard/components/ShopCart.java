package com.solvd.laba.carina.homework.pages.softwaretestingboard.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShopCart extends AbstractUIObject {
    /** Cart product cards
     *  Cards for each product currently in the cart
     */
    @FindBy(css = ".item.product.product-item")
    private List<CartCard> cartProductCards;


    public ShopCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void removeItem(int i){
        cartProductCards.get(i).clickDelete();
    }

    public void removeItem(String name){
        Optional<CartCard> card = cartProductCards
                .stream()
                .filter(a -> a.getProductName().equals(name))
                .findFirst();
        if (card.isPresent()) {
            card.get().clickDelete();
            return;
        }

        throw new RuntimeException("Item not found in cart");
    }

    public List<String> getProductNames(){
        return cartProductCards.stream().map(
                CartCard::getProductName)
                .collect(Collectors.toList()
                );
    }

    public int getProductCount(){
        return cartProductCards.size();
    }
}
