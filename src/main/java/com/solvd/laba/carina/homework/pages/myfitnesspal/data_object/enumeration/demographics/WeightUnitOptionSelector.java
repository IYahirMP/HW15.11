package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

/**
 * Contains options in modal for switching weight Units at demographics-2
 */
public enum WeightUnitOptionSelector implements UnitChangeable {
    KILOGRAM("Kilos", 1), //Single input
    POUND("Pounds", 2), //Single input
    STONE("Pounds/Stones", 3); //Pairs with POUND_STONE

    private final String unitName;
    private final int optionNumber;

    private WeightUnitOptionSelector(String unitName, int optionNumber) {
        this.unitName = unitName;
        this.optionNumber = optionNumber;
    }

    public String getText() {
        return unitName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }
}
