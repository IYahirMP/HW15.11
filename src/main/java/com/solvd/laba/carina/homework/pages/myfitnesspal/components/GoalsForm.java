package com.solvd.laba.carina.homework.pages.myfitnesspal.components;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal.Goal;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GoalsForm extends OptionSelectionForm {

    public GoalsForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPageOpen(){
        ExtendedWebElement loseWeightButton = getDynamicButton(Goal.LOSE_WEIGHT);
        waitUntil(ExpectedConditions.invisibilityOf(loseWeightButton), Duration.ofSeconds(3));
        return loseWeightButton.isVisible(Duration.ofSeconds(1));
    }
}
