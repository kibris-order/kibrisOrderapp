package com.example.campus_comuputer.listviewapplication.productList_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.campus_comuputer.listviewapplication.R;

import java.util.ArrayList;

public class productListActivity extends AppCompatActivity {
    private static final String TAG = "productListActivity";
    private ArrayList<ProductListDataModel> productListDataModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initProductListData();
        initProductListRecycleView();
    }

    private void initProductListData() {
        Log.d(TAG, "initProductListData: Called");



        productListDataModels.add( new ProductListDataModel("Winter Collection babies Tapas and Modern",
                114.2,
                500,
                false,
                400,
                40,
                "https://www.kibrisorder.com/images/thumbs/0006767_backspin_415.jpeg"));


        productListDataModels.add( new ProductListDataModel("Exclusive Bags Boss babies Tapas and Modern",
                114.2,
                300,
                true,
                400,
                90,
                "https://www.kibrisorder.com/images/thumbs/0006704_beach-dress_415.jpeg"));



        productListDataModels.add( new ProductListDataModel("Boss Leather Boot sbabies Tapas and Modern",
                114.2,
                300,
                true,
                600,
                30,
                "https://www.kibrisorder.com/images/thumbs/0006741_camouflage_415.jpeg"));



        productListDataModels.add( new ProductListDataModel("Winter Collection babies Tapas and Modern",
                114.2,
                500,
                false,
                400,
                40,
                "https://www.kibrisorder.com/images/thumbs/0006767_backspin_415.jpeg"));


        productListDataModels.add( new ProductListDataModel("Exclusive Bags Boss babies Tapas and Modern",
                114.2,
                300,
                true,
                400,
                90,
                "https://www.kibrisorder.com/images/thumbs/0006704_beach-dress_415.jpeg"));



        productListDataModels.add( new ProductListDataModel("Boss Leather Boot sbabies Tapas and Modern",
                114.2,
                300,
                true,
                600,
                30,
                "https://www.kibrisorder.com/images/thumbs/0006741_camouflage_415.jpeg"));



        productListDataModels.add( new ProductListDataModel("Boss babies Tapas and Modern",
                614.2,
                300,
                true,
                400,
                40,
                "https://www.kibrisorder.com/images/thumbs/0006724_black_415.jpeg"));


        productListDataModels.add( new ProductListDataModel("Spend On Tapas and Modern",
                114.2,
                340,
                false,
                500,
                32,
                "https://www.kibrisorder.com/images/thumbs/0006678_all-aboard_415.jpeg"));

    }

    private void initProductListRecycleView() {
        Log.d(TAG, "initProductListRecycleView: Called");

        RecyclerView productListRecycleView = (RecyclerView) findViewById(R.id.recycleViewProductList);
        ProductListRecycleViewAdapter adapter = new ProductListRecycleViewAdapter(this,productListDataModels);
        productListRecycleView.setAdapter(adapter);
        productListRecycleView.setLayoutManager(new LinearLayoutManager(this));

    }

}
