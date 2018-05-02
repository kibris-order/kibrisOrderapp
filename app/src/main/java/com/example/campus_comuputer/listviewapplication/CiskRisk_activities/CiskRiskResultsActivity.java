package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.campus_comuputer.listviewapplication.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CiskRiskResultsActivity extends AppCompatActivity {
ListView listViewCiskRiskResult;
ArrayList<String> contents;
    ArrayList<String> finalContents;
    ArrayList<String> finalContentsxx = new ArrayList<>();
    int sizeOfArray;
    private static final String TAG = "CiskRiskResultsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cisk_risk_results);
        Bundle bundle = getIntent().getExtras();
        sizeOfArray = bundle.getInt("sizeOfArray");


        listViewCiskRiskResult = (ListView) findViewById(R.id.listViewCiskRiskResult);

        try {
            String filename = "file.txt";
            String text="";
            FileInputStream fin = openFileInput(filename);
            int size=fin.available();
            byte[] buffer=new byte[size];
            fin.read(buffer);
            fin.close();
            text=new String(buffer);
            contents = new ArrayList<String>(Arrays.asList(text.split("/n")));
        } catch (IOException e) { e.printStackTrace(); }


        listViewCiskRiskResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPref = getSharedPreferences("question"+(position+1) , Context.MODE_PRIVATE);

                int x =sharedPref.getInt("points",99);
                String y = sharedPref.getString("answer","undefined");
                int z =  sharedPref.getInt("questionNo",99);

                Toast.makeText(CiskRiskResultsActivity.this, ""+x+" "+y+ " "+z, Toast.LENGTH_SHORT).show();
                int totalPoints=0;
            //I just added this loop and the bundleget at the top
               for(int i=0; i<=sizeOfArray; i++){


                   SharedPreferences sharedPrefd = getSharedPreferences("question"+(i+1) , Context.MODE_PRIVATE);

                   int xs =sharedPref.getInt("points",99);
                   Log.d(TAG, "onItemClick: loop in progress..."+xs);
                   totalPoints+=xs;
                   Log.d(TAG, "onItemClick: loop in progress...total"+totalPoints);


               }
                Toast.makeText(CiskRiskResultsActivity.this, "Total Points ="+totalPoints, Toast.LENGTH_SHORT).show();

            }
        });








        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contents);
        listViewCiskRiskResult.setAdapter(adapter);

    }
}
