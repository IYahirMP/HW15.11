package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum GainMuscleGoal implements ModalOption {
    TONE_UP("gain_muscle_result_tone_up"),
    BULK_UP("gain_muscle_result_bulk_up"),
    GET_STRONG("gain_muscle_result_get_strong");

    private final String text;

    GainMuscleGoal(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}
