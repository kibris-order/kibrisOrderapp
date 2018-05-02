package com.example.campus_comuputer.listviewapplication.categories_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.verticalRecycleView_activity.RecyclerViewAdapter;

import java.util.ArrayList;

public class categoriesActivity extends AppCompatActivity {
    private static final String TAG = "categoriesActivity";
    private ArrayList<CategoriesDataModel> categoriesDataModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        initCategoriesData();
        initRecycleViewCategories();
    }

    private void initCategoriesData(){
        categoriesDataModels.add( new CategoriesDataModel(
                "Women clothing",
                "https://ae01.alicdn.com/kf/HTB1aRXZjVmWBuNjSspdq6zugXXaa.jpg_220x220.jpg" ));


        categoriesDataModels.add( new CategoriesDataModel(
                "Men Category",
                "https://ae01.alicdn.com/kf/HTB1N8SxkDlYBeNjSszcq6zwhFXax.jpg_220x220.jpg" ));


        categoriesDataModels.add( new CategoriesDataModel(
                "Boss ladies",
                "https://www.kibrisorder.com/images/thumbs/0006649_all-aboard_415.jpeg"));

        categoriesDataModels.add( new CategoriesDataModel(
                "Winter Collection",
                "https://www.kibrisorder.com/images/thumbs/0006767_backspin_415.jpeg"));
        categoriesDataModels.add( new CategoriesDataModel(
                "Exclusive Bags",
                "https://www.kibrisorder.com/images/thumbs/0006704_beach-dress_415.jpeg"));

        categoriesDataModels.add( new CategoriesDataModel(
                "Leather Boots",
                "https://www.kibrisorder.com/images/thumbs/0006741_camouflage_415.jpeg"));


        categoriesDataModels.add( new CategoriesDataModel(
                "Boss babies",
                "https://www.kibrisorder.com/images/thumbs/0006724_black_415.jpeg"));

        categoriesDataModels.add( new CategoriesDataModel(
                "Vender selection",
                "https://www.kibrisorder.com/images/thumbs/0006678_all-aboard_415.jpeg"));
    }

    private void initRecycleViewCategories(){
        Log.d(TAG, "initRecyclerView: Called");
        RecyclerView recycleViewCategories = findViewById(R.id.recycleViewCaterories);
        CategoriesRecycleViewAdapter adapter = new CategoriesRecycleViewAdapter(this, categoriesDataModels);
        recycleViewCategories.setAdapter(adapter);
        recycleViewCategories.setLayoutManager( new LinearLayoutManager(this));
    }
}
