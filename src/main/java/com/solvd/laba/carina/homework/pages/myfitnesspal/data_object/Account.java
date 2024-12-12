package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.ActivityLevel;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.Country;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.Gender;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.demographics.HeightUnitSelector;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal.Goal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal.WeightGainWeeklyGoal;
import com.solvd.laba.carina.homework.pages.myfitnesspal.data_object.enumeration.goal.WeightLossWeeklyGoal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private static final int minimumActivityLevel = 1;
    private static final int maximumActivityLevel = 10;

    private String firstName;
    private List<Goal> goals = new ArrayList<Goal>();
    private List<SelectableItem> weightLossBarriers = new ArrayList<>();
    private List<SelectableItem> weightMaintenanceGoals = new ArrayList<>();
    private List<SelectableItem> weightGainReasons = new ArrayList<>();
    private List<SelectableItem> gainMuscleGoals = new ArrayList<>();
    private List<SelectableItem> nutritionFocusGoals = new ArrayList<>();
    private List<SelectableItem> stepsRangeGoals = new ArrayList<>();
    private List<SelectableItem> stressReliefGoals = new ArrayList<>();
    private ActivityLevel activityLevel;
    private Country country;
    private LocalDate birthDay;
    private Gender gender;
    private Weight weight = new Weight(0.0);
    private Weight goalWeight = new Weight(0.0);
    private Height height = new Height(0.0);
    private WeightLossWeeklyGoal weightLossWeeklyGoal;
    private WeightGainWeeklyGoal weightGainWeeklyGoal;

    public Account(){}

    public Account(String firstName) {
        this.firstName = firstName;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Account addGoal(Goal goal) {
        if (goals.size() >= 3){
            throw new IllegalArgumentException("List already has three goals");
        }

        if (goals.contains(goal)) {
            throw new RuntimeException("Goal already exists");
        }

        if (goal.getText().contains("weight")
                && goals.stream().anyMatch((a) -> a.getText().contains("weight"))){
            throw new RuntimeException("Can't add an opposing goal");
        }

        goals.add(goal);
        return this;
    }

    public List<SelectableItem> getWeightLossBarriers() {
        return weightLossBarriers;
    }

    public void setWeightLossBarriers(List<SelectableItem> weightLossBarriers) {
        this.weightLossBarriers = weightLossBarriers;
    }

    /*public Account addWeightLossBarrier(WeightLossBarrier barrier) {
        if (weightLossBarriers.size() >= 7){
            throw new IllegalArgumentException("All goals are already selected.");
        }

        if (weightLossBarriers.contains(barrier)) {
            throw new RuntimeException("Barrier already exists");
        }

        weightLossBarriers.add(barrier);
        return this;
    }*/

    public Account addGoalOption(Goal goal, SelectableItem option){
        List<SelectableItem> optionsList = new ArrayList<>();
        switch(goal){
            case LOSE_WEIGHT: optionsList = weightLossBarriers; break;
            case GAIN_MUSCLE: optionsList = gainMuscleGoals; break;
            case GAIN_WEIGHT: optionsList = weightGainReasons; break;
            case INCREASE_STEP_COUNT: optionsList = stepsRangeGoals; break;
            case MAINTAIN_WEIGHT: optionsList = weightMaintenanceGoals; break;
            case MANAGE_STRESS: optionsList = stressReliefGoals; break;
            case MODIFY_DIET: optionsList= nutritionFocusGoals; break;
        }

        if (optionsList.size() >= goal.getOptions()){
            throw new IllegalArgumentException("All goals are already selected.");
        }

        if (optionsList.contains(option)) {
            throw new RuntimeException("Option already exists");
        }

        if (goal == Goal.INCREASE_STEP_COUNT && !optionsList.isEmpty()){
            throw new RuntimeException("Only one increase step count option can be selected.");
        }

        optionsList.add(option);
        return this;
    }

    private List<SelectableItem> toList(List<? extends SelectableItem> options){
        return options.stream().map((a) -> (SelectableItem) a).collect(Collectors.toList());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<SelectableItem> getCollectionByGoal(Goal goal) {
        List<SelectableItem> optionsList = new ArrayList<>();
        switch(goal){
            case LOSE_WEIGHT: optionsList = weightLossBarriers; break;
            case GAIN_MUSCLE: optionsList = gainMuscleGoals; break;
            case GAIN_WEIGHT: optionsList = weightGainReasons; break;
            case INCREASE_STEP_COUNT: optionsList = stepsRangeGoals; break;
            case MAINTAIN_WEIGHT: optionsList = weightMaintenanceGoals; break;
            case MANAGE_STRESS: optionsList = stressReliefGoals; break;
            case MODIFY_DIET: optionsList= nutritionFocusGoals; break;
        }

        return optionsList;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public Account setActivityLevel(int activityLevel) {
        if (activityLevel < minimumActivityLevel || activityLevel > maximumActivityLevel){
            throw new IllegalArgumentException("Invalid activity level");
        }

        this.activityLevel = ActivityLevel.values()[activityLevel];
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Account setCountry(Country country) {
        this.country = country;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Account setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Account setBirthDay(String birthDay) {
        this.birthDay = LocalDate.parse(birthDay);
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Account setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Account setHeightCentimeters(double centimeters){
        height.setCentimeters(centimeters);
        return this;
    }

    public Height getHeight(){
        return height;
    }

    public Account setWeightKilogram(double kilos){
        weight.setKilograms(kilos);
        return this;
    }

    public Weight getWeight(){
        return weight;
    }

    public Account setGoalWeight(double goalKilos){
        double currentKilos = weight.getKilograms();
        if (currentKilos < 1){
            throw new RuntimeException("Current weight hasn't been set");
        }

        if (goals.contains(Goal.LOSE_WEIGHT) && goalKilos >= currentKilos){
            throw new RuntimeException("Goal weight contradicts LOSE_WEIGHT goal");
        }

        if (goals.contains(Goal.GAIN_WEIGHT) && goalKilos <= currentKilos){
            throw new RuntimeException("Goal weight contradicts GAIN_WEIGHT goal");
        }

        goalWeight.setKilograms(goalKilos);
        return this;
    }

    public Weight getGoalWeight(){
        return goalWeight;
    }

    public WeightLossWeeklyGoal getWeightLossWeeklyGoal() {
        return weightLossWeeklyGoal;
    }

    public Account setWeightLossWeeklyGoal(WeightLossWeeklyGoal weightLossWeeklyGoal) {
        this.weightLossWeeklyGoal = weightLossWeeklyGoal;
        return this;
    }

    public WeightGainWeeklyGoal getWeightGainWeeklyGoal() {
        return weightGainWeeklyGoal;
    }

    public Account setWeightGainWeeklyGoal(WeightGainWeeklyGoal weightGainWeeklyGoal) {
        this.weightGainWeeklyGoal = weightGainWeeklyGoal;
        return this;
    }
}
