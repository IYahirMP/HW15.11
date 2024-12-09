package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.Goal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Goals extends OptionModal {

    public Goals(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPagePresent(){
        ExtendedWebElement loseWeightButton = getDynamicButton(Goal.LOSE_WEIGHT);
        waitUntil(ExpectedConditions.invisibilityOf(loseWeightButton), Duration.ofSeconds(3));
        return loseWeightButton.isVisible(Duration.ofSeconds(1));
    }
}
