package com.berstek.uhacpayso.model;

/**
 * Created by John on 11/26/2016.
 */

public class TransactionSelectionItem {

    private String imageUrl = "", details = "";
    private int priority = 0;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
