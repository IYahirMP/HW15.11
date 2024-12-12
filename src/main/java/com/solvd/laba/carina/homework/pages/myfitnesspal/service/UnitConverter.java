package com.solvd.laba.carina.homework.pages.myfitnesspal.service;

public class UnitConverter {

    public static double feetInchesToCentimeters(double feet, double inches) {
        // Convert feet to inches
        double totalInches = (feet * 12) + inches;

        // Convert inches to centimeters
        return totalInches * 2.54;
    }

    public static String centimetersToFeetInches(double centimeters) {
        // Convert centimeters to inches
        double totalInches = centimeters / 2.54;

        // Calculate feet
        int feet = (int) totalInches / 12;

        // Calculate remaining inches
        double remainingInches = totalInches % 12;

        return feet + " feet " + String.format("%.2f", remainingInches) + " inches";
    }
}
