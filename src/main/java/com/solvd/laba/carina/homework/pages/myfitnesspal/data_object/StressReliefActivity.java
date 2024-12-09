package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public enum StressReliefActivity implements ModalOption {
    WALK("feel_better_after_walk"),
    RUN("feel_better_after_run"),
    STRENGTH_WORKOUT("feel_better_after_strength"),
    BIKE_RIDE("feel_better_after_bike"),
    YOGA_OR_FITNESS_CLASS("feel_better_after_yoga"),
    STRETCH("feel_better_after_stretch"),
    MOTIVATIONAL_MEDIA("feel_better_after_motivational_media"),
    MEDITATE("feel_better_after_meditate"),
    LISTEN_TO_MUSIC("feel_better_after_music"),
    DO_SOMETHING_ELSE("feel_better_after_other"),
    NOTHING_HELPS("feel_better_after_nothing_helps");

    private final String text;

    StressReliefActivity(String text) {
        this.text = text;
    }

    public final String getText() {
        return text;
    }
}
