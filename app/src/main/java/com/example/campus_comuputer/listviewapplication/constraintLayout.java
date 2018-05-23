package com.example.campus_comuputer.listviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class constraintLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
    }

    void radioOne(View v){
        Toast.makeText(this, "radioOneClicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioOnex(View v){
        Toast.makeText(this, "radioOnexClicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioTwo(View v){
        Toast.makeText(this, "radio2Clicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioTwox(View v){
        Toast.makeText(this, "radio2xClicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioThree(View v){
        Toast.makeText(this, "radio3Clicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioThreex(View v){
        Toast.makeText(this, "radio3xClicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioFour(View v){
        Toast.makeText(this, "radio4Clicked with point 1", Toast.LENGTH_SHORT).show();
    }

    void radioFourx(View v){
        Toast.makeText(this, "radio4xClicked with point 1", Toast.LENGTH_SHORT).show();
    }

}
