package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.WeightLossBarrier;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BarriersLose extends OptionModal {

    public BarriersLose(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPageOpen(){
        ExtendedWebElement foodCravingsButton = getDynamicButton(WeightLossBarrier.FOOD_CRAVINGS);
        waitUntil(ExpectedConditions.invisibilityOf(foodCravingsButton), Duration.ofSeconds(3));
        return foodCravingsButton.isPresent(Duration.ofSeconds(1));
    }
}
