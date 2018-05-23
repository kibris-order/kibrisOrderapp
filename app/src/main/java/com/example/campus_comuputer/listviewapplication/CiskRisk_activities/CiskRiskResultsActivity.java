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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campus_comuputer.listviewapplication.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CiskRiskResultsActivity extends AppCompatActivity {
ListView listViewCiskRiskResult;
TextView resultText;
TextView textVeiwResult;
Button buttonShowLog;
ArrayList<String> contents;
    int totalPoints=0;
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
        resultText =(TextView) findViewById(R.id.textViewResultText);
        buttonShowLog = (Button) findViewById(R.id.buttonShowLog);
        textVeiwResult = (TextView) findViewById(R.id.textViewResultx);

        //I just added this loop and the bundleget at the top
        for(int i=0; i<=sizeOfArray; i++){
            SharedPreferences sharedPrefd = getSharedPreferences("question"+(i) , Context.MODE_PRIVATE);

            int xs =sharedPrefd.getInt("points",0);

            totalPoints+=xs;
            Log.d(TAG, "onItemClick: loop in value of xs for q"+i+"=...is="+xs+"and...total="+totalPoints);


        }
        if(totalPoints < 21){
            //lower
            textVeiwResult.setText("Low Risk");
            resultText.setText("Your risk of having pre-diabetes or type 2\n" +
                    "diabetes is fairly low, though it always pays\n" +
                    "to maintain a healthy lifestyle.");
        }
        else if (totalPoints >= 21 && totalPoints<=32 ){
            //moderate
            textVeiwResult.setText("Moderate Risk");
            resultText.setText("Based on your identified risk factors, your risk\n" +
                    "of having pre-diabetes or type 2 diabetes\n" +
                    "is moderate. You may wish to consult with\n" +
                    "a health care practitioner about your risk of\n" +
                    "developing diabetes.");
        }else{
            textVeiwResult.setText("High Risk");
            //High Risk
            resultText.setText("Based on your identified risk factors, your risk\n" +
                    "of having pre-diabetes or type 2 diabetes is\n" +
                    "high. You may wish to consult with a health\n" +
                    "care practitioner to discuss getting your blood\n" +
                    "sugar tested");}

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

buttonShowLog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        listViewCiskRiskResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   SharedPreferences sharedPref = getSharedPreferences("question"+(position+1) , Context.MODE_PRIVATE);

                //int x =sharedPref.getInt("points",99);
                //   String y = sharedPref.getString("answer","undefined");
                // int z =  sharedPref.getInt("questionNo",99);

                // Toast.makeText(CiskRiskResultsActivity.this, ""+x+" "+y+ " "+z, Toast.LENGTH_SHORT).show();

                resultText.setText("Total points ="+totalPoints);
                Toast.makeText(CiskRiskResultsActivity.this, "Total Points ="+totalPoints, Toast.LENGTH_SHORT).show();

            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(CiskRiskResultsActivity.this, android.R.layout.simple_list_item_1, contents);
        listViewCiskRiskResult.setAdapter(adapter);


    }
});







    }
}
