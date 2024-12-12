package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

/**
 * Contains the [name] HTML attribute values for each weight unit option's input available at demographics-2 screen.
 */
public enum WeightUnitSelector implements SelectableItem {
    KILOGRAM("weight_current_value"), //Single input
    POUND("weight_current_value"), //Single input
    STONE("currentStone"), //Pairs with POUND_STONE
    POUND_STONE("currentPound"); //Pairs with STONE

    private final String inputSelector;

    private WeightUnitSelector(String value) {
        this.inputSelector = value;
    }
    public String getText() {
        return inputSelector;
    }
}
