package com.example.campus_comuputer.listviewapplication.verticalRecycleView_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.shared_classes.RowComponentData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Debug var
    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<RowComponentData> rowComponentData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps started");
        rowComponentData.add( new RowComponentData(
                "Women clothing",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://ae01.alicdn.com/kf/HTB1aRXZjVmWBuNjSspdq6zugXXaa.jpg_220x220.jpg" ));


        rowComponentData.add( new RowComponentData(
                "Men Category",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://ae01.alicdn.com/kf/HTB1N8SxkDlYBeNjSszcq6zwhFXax.jpg_220x220.jpg" ));


        rowComponentData.add( new RowComponentData(
                "Boss ladies",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006649_all-aboard_415.jpeg"));

        rowComponentData.add( new RowComponentData(
                "Winter Collection",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006767_backspin_415.jpeg"));

        rowComponentData.add( new RowComponentData(
                "Exclusive Bags",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006704_beach-dress_415.jpeg"));

        rowComponentData.add( new RowComponentData(
                "Leather Boots",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006741_camouflage_415.jpeg"));

        rowComponentData.add( new RowComponentData(
                "Boss babies",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006724_black_415.jpeg"));

        rowComponentData.add( new RowComponentData(
                "Vender selection",
                "Women Clothing, for the goodness of women for goodness sake",
                "https://www.kibrisorder.com/images/thumbs/0006678_all-aboard_415.jpeg"));


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, rowComponentData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
    }
}
