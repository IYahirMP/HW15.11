package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

public enum StepsRange implements SelectableItem {
    LESS_THAN_1000("steps_now_1000_or_less"),
    BETWEEN_1000_AND_3000("steps_now_1000_to_3000"),
    BETWEEN_3000_AND_7000("steps_now_3000_to_7000"),
    MORE_THAN_7000("steps_now_more_than_7000"),
    DONT_KNOW("steps_now_dont_know");

    private final String value;

    StepsRange(String value) {
        this.value = value;
    }

    public final String getText() {
        return value;
    }
}
