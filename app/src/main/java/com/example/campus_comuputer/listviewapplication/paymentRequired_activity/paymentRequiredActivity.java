package com.example.campus_comuputer.listviewapplication.paymentRequired_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.coupon_activity.CouponRecycleViewAdapter;

import java.util.ArrayList;

public class paymentRequiredActivity extends AppCompatActivity {
    private static final String TAG = "paymentRequiredActivity";
    ArrayList<PaymentRequiredDataModel> paymentRequiredDataModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_required);
        initPaymentRequiredData();
        initRecycleViewCoupon();

    }

    private void initPaymentRequiredData() {
        //String orderId, int orderQuantity,
        // String orderProductTitle, double orderProductPrice, String orderProductImageUrl
        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                1,
                "Ladies Modern babies Tapas and Modern",
                330.40,
                "https://www.kibrisorder.com/images/thumbs/0006649_all-aboard_415.jpeg"
        ));

        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                2,
                "Winter Collection babies Tapas and Modern",
                530.40,
                "https://www.kibrisorder.com/images/thumbs/0006767_backspin_415.jpeg"
        ));

        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                2,
                "Exclusive Bags Boss babies Tapas and Modern",
                130.40,
                "https://www.kibrisorder.com/images/thumbs/0006704_beach-dress_415.jpeg"
        ));

        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                4,
                "Boss Leather Boot sbabies Tapas and Modern",
                130.40,
                "https://www.kibrisorder.com/images/thumbs/0006741_camouflage_415.jpeg"
        ));



        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                2,
                "Boss babies Tapas and Modern",
                130.40,
                "https://www.kibrisorder.com/images/thumbs/0006724_black_415.jpeg"
        ));

        paymentRequiredDataModels.add( new PaymentRequiredDataModel(
                "300001844006458",
                4,
                "Spend On Tapas and Modern",
                110.40,
                "https://www.kibrisorder.com/images/thumbs/0006678_all-aboard_415.jpeg"
        ));


    }

    private void initRecycleViewCoupon(){
        Log.d(TAG, "initRecycleViewCoupon: ");

        RecyclerView recyclerViewPaymentRequired= findViewById(R.id.recycleViewPaymentRequired);
        PaymentRequiredAdapter adapter = new PaymentRequiredAdapter(this, paymentRequiredDataModels);
        recyclerViewPaymentRequired.setAdapter(adapter);
        recyclerViewPaymentRequired.setLayoutManager( new LinearLayoutManager(this));
    }
}
