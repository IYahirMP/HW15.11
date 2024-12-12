package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics;

/**
 * Contains the options available in the height unit switch modal at demographics-2 screen.
 */
public enum HeightUnitOptionSelector implements UnitChangeable {
    CENTIMETER("Centimeters", 2),
    FEET_INCH("Feet/Inches", 1);

    private final String inputSelector;
    private final int optionNumber;

    private HeightUnitOptionSelector(String value, int optionNumber) {
        this.inputSelector = value;
        this.optionNumber = optionNumber;
    }
    public String getText() {
        return inputSelector;
    }
    public int getOptionNumber() {
        return optionNumber;
    }
}
