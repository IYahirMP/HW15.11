package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

/**
 * Contains [name] HTML attribute values for GoalWeight input in demographics-2 screen
 */
public enum GoalWeightSelector implements SelectableItem {
    KILOGRAM("weight_goal_value"), //Single input
    POUND("weight_goal_value"), //Single input
    STONE("stoneGoal"), //Pairs with POUND_STONE
    POUND_STONE("poundGoal"); //Pairs with STONE

    private final String inputSelector;

    private GoalWeightSelector(String value) {
        this.inputSelector = value;
    }
    public String getText() {
        return inputSelector;
    }
}
