package com.example.campus_comuputer.listviewapplication.categories_activity;

/**
 * Created by Campus-Comuputer on 4/26/2018.
 */

public class CategoriesDataModel {
    private String categoryTitle;
    private String categoryImageUrl;

    public CategoriesDataModel(String categoryTitle, String categoryImageUrl) {
        this.categoryTitle = categoryTitle;
        this.categoryImageUrl = categoryImageUrl;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
