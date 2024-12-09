package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum WeightGainReason implements ModalOption {
    COMPETITIVE_SPORT("competitive_sport"),
    MUSCLE_FOR_FITNESS("muscle_for_fitness"),
    UNDERWEIGHT("underweight"),
    HEALTHCARE_PROVIDER("healthcare_provider"),
    OTHER("other");

    private final String text;

    WeightGainReason(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}
