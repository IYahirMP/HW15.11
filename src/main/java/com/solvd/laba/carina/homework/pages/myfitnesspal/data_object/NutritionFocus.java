package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum NutritionFocus implements ModalOption {
    TRACK_MACROS("modify_focus_track_macros"),
    EAT_VEGAN("modify_focus_vegan"),
    EAT_VEGETARIAN("modify_focus_vegetarian"),
    EAT_PESCETARIAN("modify_focus_pescetarian"),
    LESS_SUGAR("modify_focus_less_sugar"),
    LESS_PROTEIN("modify_focus_less_protein"),
    LESS_DAIRY("modify_focus_less_dairy"),
    FEWER_CARBS("modify_focus_less_carbs"),
    LESS_FAT("modify_focus_less_fat"),
    MORE_PROTEIN("modify_focus_more_protein"),
    MORE_FAT("modify_focus_more_fat"),
    MORE_FRUITS_AND_VEGETABLES("modify_focus_more_fruits_and_vegetables"),
    OTHER("modify_focus_other");

    private final String text;

    NutritionFocus(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}

