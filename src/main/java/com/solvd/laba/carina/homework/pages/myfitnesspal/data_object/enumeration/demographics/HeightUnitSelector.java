package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

/**
 * Contains values for [name] HTML attribute for height unit inputs in demographics-2;
 */
public enum HeightUnitSelector implements SelectableItem {
    CENTIMETER("heightCm"),
    FEET("height_feet"),
    INCH("height-inches");

    private final String inputSelector;

    private HeightUnitSelector(String value) {
        this.inputSelector = value;
    }
    public String getText() {
        return inputSelector;
    }
}
