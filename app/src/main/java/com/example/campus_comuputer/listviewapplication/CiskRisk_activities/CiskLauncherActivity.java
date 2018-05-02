package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.campus_comuputer.listviewapplication.R;

import java.io.FileOutputStream;

public class CiskLauncherActivity extends AppCompatActivity {
 Button buttonCiskLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cisk_launcher);
        buttonCiskLauncher = (Button) findViewById(R.id.buttonCiskLauncher);

        buttonCiskLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final String FILE_NAME = "file.txt";
                    Log.d("Log", "Write file called");
                    FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                    String text ="APPSTART "+"/n ";
                    fos.write(text.toString().getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(CiskLauncherActivity.this,CiskMainQuestionsActivity.class);

                i.putExtra("position",0);

                startActivity(i);
            }
        });

    }
}
