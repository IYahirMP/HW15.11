package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

import org.apache.commons.math3.optimization.Weight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private String firstName;
    private List<Goal> goals = new ArrayList<Goal>();
    private List<ModalOption> weightLossBarriers = new ArrayList<>();
    private List<ModalOption> weightMaintenanceGoals = new ArrayList<>();
    private List<ModalOption> weightGainReasons = new ArrayList<>();
    private List<ModalOption> gainMuscleGoals = new ArrayList<>();
    private List<ModalOption> nutritionFocusGoals = new ArrayList<>();
    private List<ModalOption> stepsRangeGoals = new ArrayList<>();
    private List<ModalOption> stressReliefGoals = new ArrayList<>();

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

    public List<ModalOption> getWeightLossBarriers() {
        return weightLossBarriers;
    }

    public void setWeightLossBarriers(List<ModalOption> weightLossBarriers) {
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

    public Account addGoalOption(Goal goal, ModalOption option){
        List<ModalOption> optionsList = new ArrayList<>();
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

    private List<ModalOption> toList(List<? extends ModalOption> options){
        return options.stream().map((a) -> (ModalOption) a).collect(Collectors.toList());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<ModalOption> getCollectionByGoal(Goal goal) {
        List<ModalOption> optionsList = new ArrayList<>();
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
}
