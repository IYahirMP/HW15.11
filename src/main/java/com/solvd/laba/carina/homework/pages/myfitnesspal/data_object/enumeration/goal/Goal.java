package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.SelectableItem;

public enum Goal implements SelectableItem {
    LOSE_WEIGHT("lose_weight", 7),
    MAINTAIN_WEIGHT("maintain_weight", WeightMaintenanceBarrier.values().length),
    GAIN_WEIGHT("gain_weight", WeightGainReason.values().length),
    GAIN_MUSCLE("gain_muscle", GainMuscleGoal.values().length),
    MODIFY_DIET("modify_diet", NutritionFocus.values().length),
    MANAGE_STRESS("manage_stress", StressReliefActivity.values().length),
    INCREASE_STEP_COUNT("increase_step_count", StepsRange.values().length);

    private final String text;
    private final int options;

    Goal(String text, int options) {
        this.text = text;
        this.options = options;
    }

    public final String getText() {
        return text;
    }
    public final int getOptions() { return options; }


}
