package com.example.campus_comuputer.listviewapplication.coupon_activity;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class CouponDataModel {
    private String couponTitle;
    private String couponExpiryDate;
    private Boolean couponIsSelected;

    public CouponDataModel(String couponTitle, String couponExpiryDate, Boolean couponIsSelected) {
        this.couponTitle = couponTitle;
        this.couponExpiryDate = couponExpiryDate;
        this.couponIsSelected = couponIsSelected;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public String getCouponExpiryDate() {
        return couponExpiryDate;
    }

    public void setCouponExpiryDate(String couponExpiryDate) {
        this.couponExpiryDate = couponExpiryDate;
    }

    public Boolean getCouponIsSelected() {
        return couponIsSelected;
    }

    public void setCouponIsSelected(Boolean couponIsSelected) {
        this.couponIsSelected = couponIsSelected;
    }
}
