package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

public enum WeightGainWeeklyGoal implements SelectableItem {
    GAIN_HALF("-0.5"),
    GAIN_ONE("-1");

    private String value;
    private WeightGainWeeklyGoal(String value) {
        this.value = value;
    }

    public String getText(){
        return value;
    }
}
