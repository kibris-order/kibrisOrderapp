package com.example.campus_comuputer.listviewapplication.paymentRequired_activity;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class PaymentRequiredDataModel {
    private String orderId;
    private int orderQuantity;
    private String orderProductTitle;
    private double orderProductPrice;
    private String orderProductImageUrl;

    public PaymentRequiredDataModel(String orderId, int orderQuantity, String orderProductTitle, double orderProductPrice, String orderProductImageUrl) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
        this.orderProductTitle = orderProductTitle;
        this.orderProductPrice = orderProductPrice;
        this.orderProductImageUrl = orderProductImageUrl;
    }

    public double calculateTotalAmount(){
        return orderProductPrice * orderQuantity;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderProductTitle() {
        return orderProductTitle;
    }

    public void setOrderProductTitle(String orderProductTitle) {
        this.orderProductTitle = orderProductTitle;
    }

    public double getOrderProductPrice() {
        return orderProductPrice;
    }

    public void setOrderProductPrice(double orderProductPrice) {
        this.orderProductPrice = orderProductPrice;
    }

    public String getOrderProductImageUrl() {
        return orderProductImageUrl;
    }

    public void setOrderProductImageUrl(String orderProductImageUrl) {
        this.orderProductImageUrl = orderProductImageUrl;
    }
}
