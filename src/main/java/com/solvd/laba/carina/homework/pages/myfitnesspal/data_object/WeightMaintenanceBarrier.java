package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum WeightMaintenanceBarrier implements ModalOption {
    LACK_OF_TIME("lack_of_time_maintain"),
    REGIME_HARD_TO_FOLLOW("regimen_hard_maintain"),
    DIET_LACKS_VARIETY("diet_lacks_variety_maintain"),
    FOOD_CHOICE_STRESS("food_choice_stress_maintain"),
    SOCIAL_EATING_EVENTS("holidays_vacation_events_maintain"),
    FOOD_CRAVINGS("food_cravings_maintain"),
    LACK_OF_PROGRESS("lack_of_progress_maintain"),
    DOESNT_TASTE_GOOD("doesnt_taste_good_maintain"),
    TOO_EXPENSIVE("too_expensive_maintain"),
    COOKING_HARD("cooking_hard_maintain"),
    NO_BARRIERS("no_barriers_maintain");

    private final String text;

    WeightMaintenanceBarrier(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}
