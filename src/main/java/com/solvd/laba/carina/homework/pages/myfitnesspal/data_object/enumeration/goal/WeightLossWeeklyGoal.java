package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

public enum WeightLossWeeklyGoal implements SelectableItem {
    LOSE_HALF("0.5"),
    LOSE_ONE("1"),
    LOSE_ONE_FIVE("1.5"),
    LOSE_TWO("2");

    private String value;
    private WeightLossWeeklyGoal(String value) {
        this.value = value;
    }

    public String getText(){
        return value;
    }
}
