package com.berstek.uhacpayso.model;

import android.content.Context;

/**
 * Created by John on 11/26/2016.
 */

public class AddTransactionTempData {

    public AddTransactionTempData(Context context, String date) {
        CycleData data = new CycleData(context, date);
        cycle = data.getActiveCycle();
    }

    private String type = "", details = "", cycle = "";
    private double cost = 0;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
