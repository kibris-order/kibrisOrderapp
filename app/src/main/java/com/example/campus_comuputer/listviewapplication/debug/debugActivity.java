package com.example.campus_comuputer.listviewapplication.debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.campus_comuputer.listviewapplication.CiskRisk_activities.CiskLauncherActivity;
import com.example.campus_comuputer.listviewapplication.CiskRisk_activities.CiskMainQuestionsActivity;
import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.account_activity.accountActivity;
import com.example.campus_comuputer.listviewapplication.addNewAddress_activity.addNewAddressActivity;
import com.example.campus_comuputer.listviewapplication.categories_activity.categoriesActivity;
import com.example.campus_comuputer.listviewapplication.copyright_activity.copyrightActivity;
import com.example.campus_comuputer.listviewapplication.coupon_activity.couponActivity;
import com.example.campus_comuputer.listviewapplication.cutomer_feedback_activity.customerFeedbackActivity;
import com.example.campus_comuputer.listviewapplication.horizontalRecycleView_activity.HorizontalRecycleViewActivity;
import com.example.campus_comuputer.listviewapplication.hybridRecycleView_activity.HybridActivity;
import com.example.campus_comuputer.listviewapplication.launcher_activity.launcherActivity;
import com.example.campus_comuputer.listviewapplication.message_activity.messageActivity;
import com.example.campus_comuputer.listviewapplication.paymentRequired_activity.paymentRequiredActivity;
import com.example.campus_comuputer.listviewapplication.payment_activity.paymentActivity;
import com.example.campus_comuputer.listviewapplication.payment_result_activity.paymentResultActivity;
import com.example.campus_comuputer.listviewapplication.productList_activity.productListActivity;

public class debugActivity extends AppCompatActivity {
    private static final String TAG = "debugActivity";
    ListView listViewDebug;
    ArrayAdapter adapter;
    String Activities[] ={"accountActivity",
            "addNewAddressActivity",
            "categoriesActivity",
            "CiskLauncherActivity",
            "copyrightActivity",
            "couponActivity",
            "customerFeedbackActivity",
            "HorizaontalRecycleViewActivity",
            "HybridActivity",
            "launcherActivity",
            "messageActivity",
            "paymentActivity",
            "paymentResultActivity",
            "paymentRequiredActivity",
            "productListActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        Log.d(TAG, "onCreate: ");

        listViewDebug = (ListView) findViewById(R.id.listViewDebug);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Activities);

        listViewDebug.setAdapter(adapter);
        listViewDebug.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch(position){
                case 0:
                    startActivity(new Intent(debugActivity.this,accountActivity.class));break;
                case 1:
                    startActivity(new Intent(debugActivity.this,addNewAddressActivity.class));break;
                case 2:
                    startActivity(new Intent(debugActivity.this,categoriesActivity.class));break;
                case 3:
                    startActivity(new Intent(debugActivity.this,CiskLauncherActivity.class));break;
                case 4:
                    startActivity(new Intent(debugActivity.this,copyrightActivity.class));break;
                case 5:
                    startActivity(new Intent(debugActivity.this,couponActivity.class));break;
                case 6:
                    startActivity(new Intent(debugActivity.this,customerFeedbackActivity.class));break;
                case 7:
                    startActivity(new Intent(debugActivity.this,HorizontalRecycleViewActivity.class));break;
                case 8:
                    startActivity(new Intent(debugActivity.this,HybridActivity.class));break;
                case 9:
                    startActivity(new Intent(debugActivity.this,launcherActivity.class));break;
                case 10:
                    startActivity(new Intent(debugActivity.this,messageActivity.class));break;
                case 11:
                    startActivity(new Intent(debugActivity.this,paymentActivity.class));break;
                case 12:
                    startActivity(new Intent(debugActivity.this,paymentResultActivity.class));break;
                case 13:
                    startActivity(new Intent(debugActivity.this,paymentRequiredActivity.class));break;
                case 14:
                    startActivity(new Intent(debugActivity.this,productListActivity.class));break;
            }


            }
        });
    }
}
