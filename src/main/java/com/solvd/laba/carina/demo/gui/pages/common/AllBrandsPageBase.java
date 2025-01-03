package com.solvd.laba.carina.demo.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class AllBrandsPageBase extends AbstractPage {

    public AllBrandsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

}
