package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

import java.util.ArrayList;
import java.util.List;

public enum Goal {
    LOSE_WEIGHT("lose_weight"),
    MAINTAIN_WEIGHT("maintain_weight"),
    GAIN_WEIGHT("gain_weight"),
    GAIN_MUSCLE("gain_muscle"),
    MODIFY_DIET("modify_diet"),
    MANAGE_STRESS("manage_stress"),
    INCREASE_STEP_COUNT("increase_step_count");

    private final String text;

    Goal(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }

    public static List<Goal> getOppositeGoals(){
        List<Goal> oppositeGoals = new ArrayList<>();
        oppositeGoals.add(LOSE_WEIGHT);
        oppositeGoals.add(MAINTAIN_WEIGHT);
        oppositeGoals.add(GAIN_WEIGHT);

        return oppositeGoals;
    }
}
