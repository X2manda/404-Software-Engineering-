package com.berstek.uhacpayso.model;

/**
 * Created by John on 11/26/2016.
 */

public class CycleHistoryItem {

    private String start = "", cycleType;
    private double budget = 0;
    private double spending = 0;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getSpending() {
        return spending;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }
}
