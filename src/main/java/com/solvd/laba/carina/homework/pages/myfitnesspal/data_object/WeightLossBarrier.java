package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;


public enum WeightLossBarrier implements ModalOption{
    LACK_OF_TIME("lack_of_time_lose"),
    REGIME_HARD_TO_FOLLOW("regimen_hard_lose"),
    DID_NOT_ENJOY_FOOD("diet_lacks_variety_lose"),
    DIFFICULT_TO_CHOOSE_FOOD("food_choice_stress_lose"),
    SOCIAL_EATING_EVENTS("holidays_vacation_events_lose"),
    FOOD_CRAVINGS("food_cravings_lose"),
    LACK_OF_PROGRESS("lack_of_progress_lose");

    private final String text;

    WeightLossBarrier(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}
