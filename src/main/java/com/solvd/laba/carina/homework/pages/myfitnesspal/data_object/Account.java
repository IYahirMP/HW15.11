package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

import org.apache.commons.math3.optimization.Weight;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String firstName;
    private List<Goal> goals = new ArrayList<Goal>();
    private List<WeightLossBarrier> weightLossBarriers = new ArrayList<>();

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

    public List<WeightLossBarrier> getWeightLossBarriers() {
        return weightLossBarriers;
    }

    public void setWeightLossBarriers(List<WeightLossBarrier> weightLossBarriers) {
        this.weightLossBarriers = weightLossBarriers;
    }

    public Account addWeightLossBarrier(WeightLossBarrier barrier) {
        if (weightLossBarriers.size() >= 7){
            throw new IllegalArgumentException("All goals are already selected.");
        }

        if (weightLossBarriers.contains(barrier)) {
            throw new RuntimeException("Barrier already exists");
        }

        weightLossBarriers.add(barrier);
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
