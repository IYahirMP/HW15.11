package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String firstName;
    private List<Goal> goals = new ArrayList<Goal>();

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
