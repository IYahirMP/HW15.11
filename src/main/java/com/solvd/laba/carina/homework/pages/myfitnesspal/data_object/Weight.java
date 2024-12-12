package com.solvd.laba.carina.homework.pages.myfitnesspal.data_object;

public class Weight {
    private double kilograms = 0.0;

    // Constructors
    public Weight(double kilograms) {
        this.kilograms = kilograms;
    }

    public Weight(int stones, double pounds) {
        this.kilograms = (stones * 6.35029 + pounds) * 0.453592;
    }

    // Getters
    public double getKilograms() {
        return kilograms;
    }

    public double getPounds(boolean subtractStones) {
        double totalPounds = kilograms / 0.453592;
        return subtractStones ? totalPounds % 14 : totalPounds;
    }

    public int getStones(){
        double totalPounds = kilograms / 0.453592;
        return (int) (totalPounds / 14);
    }

    public double[] getStonesPounds(){
        return new double[]{
                getStones(),
                getPounds(true)
        };
    }

    public void setKilograms(double kilograms) {
        this.kilograms = kilograms;
    }

    public void setPounds(double pounds) {
        this.kilograms = pounds * 0.453592;
    }

    public void setStonesPounds(int stones, double pounds) {
        this.kilograms = (stones * 6.35029 + pounds) * 0.453592;
    }
}
