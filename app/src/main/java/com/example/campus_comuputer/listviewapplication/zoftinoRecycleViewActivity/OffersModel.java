package com.example.campus_comuputer.listviewapplication.zoftinoRecycleViewActivity;

/**
 * Created by Campus-Comuputer on 4/29/2018.
 */

class OffersModel {
    private String offer;
    private int savings;

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public OffersModel(String offer, int savings) {
        this.offer = offer;
        this.savings = savings;
    }
}
