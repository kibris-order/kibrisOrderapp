package com.example.campus_comuputer.listviewapplication.productList_activity;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class ProductListDataModel {
    private String productName;
    private String productImageUrl;
    private int productDiscountPercentage;
    private double productPrice;
    private double productOldPrice;
    private boolean productHasFreeShipping;
    private int productNumOfOrders;

    public ProductListDataModel(String productName, double productPrice, double productOldPrice, boolean productHasFreeShipping, int productNumOfOrders, int productDiscountPercentage, String productImageUrl) {
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productDiscountPercentage = productDiscountPercentage;
        this.productPrice = productPrice;
        this.productOldPrice = productOldPrice;
        this.productHasFreeShipping = productHasFreeShipping;
        this.productNumOfOrders = productNumOfOrders;
    }

    public int getProductDiscountPercentage() {
        return productDiscountPercentage;
    }

    public void setProductDiscountPercentage(int productDiscountPercentage) {
        this.productDiscountPercentage = productDiscountPercentage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }


    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(double productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public boolean isProductHasFreeShipping() {
        return productHasFreeShipping;
    }

    public void setProductHasFreeShipping(boolean productHasFreeShipping) {
        this.productHasFreeShipping = productHasFreeShipping;
    }

    public int getProductNumOfOrders() {
        return productNumOfOrders;
    }

    public void setProductNumOfOrders(int productNumOfOrders) {
        this.productNumOfOrders = productNumOfOrders;
    }
}


