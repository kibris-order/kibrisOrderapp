package com.example.campus_comuputer.listviewapplication.coupon_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.categories_activity.CategoriesRecycleViewAdapter;

import java.util.ArrayList;

public class couponActivity extends AppCompatActivity {
    private static final String TAG = "couponActivity";
    private ArrayList<CouponDataModel> couponDataModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        initCouponData();
        initRecycleViewCoupon();
    }

    private void initCouponData(){
        Log.d(TAG, "initCouponData: Called");
        couponDataModels.add( new CouponDataModel(
                "$10 Off $50",
                "Expires 30 Apr 2013 04:10:30",
                true
        ));

        couponDataModels.add( new CouponDataModel(
                "$20 Off $100",
                "Expires 30 Apr 2013 04:10:30",
                false
        ));

        couponDataModels.add( new CouponDataModel(
                "$30 Off $200",
                "Expires 30 Apr 2013 04:10:30",
                false
        ));


        couponDataModels.add( new CouponDataModel(
                "$20 Off $100",
                "Expires 30 Apr 2013 04:10:30",
                false
        ));

        couponDataModels.add( new CouponDataModel(
                "$30 Off $200",
                "Expires 30 Apr 2013 04:10:30",
                false
        ));

    }
    private void initRecycleViewCoupon(){
        Log.d(TAG, "initRecycleViewCategories: Called");
        RecyclerView recycleViewCoupon= findViewById(R.id.recycleViewCoupon);
        CouponRecycleViewAdapter adapter = new CouponRecycleViewAdapter(this, couponDataModels);
        recycleViewCoupon.setAdapter(adapter);
        recycleViewCoupon.setLayoutManager( new LinearLayoutManager(this));
    }
}
