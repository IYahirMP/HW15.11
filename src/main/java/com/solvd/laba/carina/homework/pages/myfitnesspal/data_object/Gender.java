package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum Gender {
    MALE("M"),
    Female("F");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
