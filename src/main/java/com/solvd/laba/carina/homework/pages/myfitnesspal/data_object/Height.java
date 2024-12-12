package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public class Height {

    private double centimeters = 0.0;

    // Constructors
    public Height(double centimeters) {
        this.centimeters = centimeters;
    }

    public Height(int feet, double inches) {
        this.centimeters = (feet * 12 + inches) * 2.54;
    }

    // Getters
    public double getCentimeters() {
        return centimeters;
    }

    public int getFeet() {
        double totalInches = centimeters / 2.54;
        return (int) (totalInches / 12);
    }

    public double getInches() {
        double totalInches = centimeters / 2.54;
        return totalInches % 12;
    }

    public void setCentimeters(double centimeters) {
        this.centimeters = centimeters;
    }

    public void setFeetInch(int feet, double inches) {
        this.centimeters = (feet * 12 + inches) * 2.54;
    }
}