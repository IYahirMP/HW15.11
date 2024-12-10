package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum ActivityLevel implements ModalOption {
    NOT_VERY_ACTIVE("1", "Not Very Active", "Spend most of the day sitting (e.g., bank teller, desk job)"),
    LIGHTLY_ACTIVE("2", "Lightly Active", "Spend a good part of the day on your feet (e.g., teacher, salesperson)"),
    ACTIVE("3", "Active", "Spend a good part of the day doing some physical activity (e.g., food server, postal carrier)"),
    VERY_ACTIVE("4", "Very Active", "Spend a good part of the day doing heavy physical activity (e.g., bike messenger, carpenter)");

    private final String value;
    private final String label;
    private final String description;

    ActivityLevel(String value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    public String getText() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}

