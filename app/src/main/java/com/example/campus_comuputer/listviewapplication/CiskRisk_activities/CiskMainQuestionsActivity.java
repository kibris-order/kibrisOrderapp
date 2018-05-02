package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campus_comuputer.listviewapplication.R;

import java.util.ArrayList;

public class CiskMainQuestionsActivity extends AppCompatActivity {
    private static final String TAG = "CiskMainQuestionsActivi";


    private int pos =0;
    TextView textViewCiskQuestionHeader;
    TextView textViewCiskQuestion;
    Button buttonCiskNext;
    TextView textViewCiskRiskQuestionSubheader;
    TextView textViewCiskRiskOptionHeader;
    ImageView imageViewCiskRiskQuestionImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cisk_main_questions);

        Bundle bundle = getIntent().getExtras();
        int valueReceived1 = bundle.getInt("position");
        pos=valueReceived1;

        textViewCiskQuestion = (TextView) findViewById(R.id.textViewCiskQuestion);
        textViewCiskQuestionHeader = (TextView) findViewById(R.id.textViewCiskQuestionHeader);
        buttonCiskNext = (Button) findViewById(R.id.buttonCiskNext);
        textViewCiskRiskOptionHeader = (TextView) findViewById(R.id.textViewCiskRiskOptionsHeader);
        textViewCiskRiskQuestionSubheader = (TextView) findViewById(R.id.textViewCiskRiskQuestionSubHeader);
        imageViewCiskRiskQuestionImage = (ImageView) findViewById(R.id.imageViewCiskRiskQuestionImage);




        initCiskRiskRecycleView();

    buttonCiskNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: ButtonCiskNext Clicked");
            Toast.makeText(CiskMainQuestionsActivity.this, "Next Button Clicked", Toast.LENGTH_SHORT).show();


            pos++;

            if(pos>=getCiskRiskData().size()-1) {
              // pos=0;
                Intent i = new Intent(CiskMainQuestionsActivity.this, CiskRiskResultsActivity.class);

                i.putExtra("sizeOfArray", getCiskRiskData().size());

                startActivity(i);

            }else {
                //  finish();
                Intent i = new Intent(CiskMainQuestionsActivity.this, CiskMainQuestionsActivity.class);

                i.putExtra("position", pos);

                startActivity(i);
            }

         /*   finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);*/
        }
    });
    }



    private ArrayList<CiskRiskDataModel> getCiskRiskData() {
        Log.d(TAG, "initCiskRiskData: Called");
       ArrayList<CiskRiskDataModel> ciskRiskDataModels = new ArrayList<>();

        ArrayList<CiskRiskQuestionsAnswersDataModel> mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("40-44 years", 0, false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("45-54 years", 7, true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("55-64 years", 13, false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("65-74 years", 15, false));

            ciskRiskDataModels.add( new CiskRiskDataModel(
                    "AS YOU GET OLDER, YOUR RISK OF DEVELOPING DIABETES GOES UP",
                    "Select your age group:",
                    "",
                    "",
                    "",
                    mAnswers


            ));


        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Male", 6,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Female", 0,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "AS YOU GET OLDER, YOUR RISK OF DEVELOPING DIABETES GOES UP",
                "Are you male of female?",
                "",
                "",
                "",
                mAnswers


        ));


        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("White (BMI less than 25)", 0,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Light grey (BMI 25 to 29)", 4,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Dark grey (BMI 30 to 34)", 9,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Black (BMI 35 and over)", 14,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "BODY SHAPE AND SIZE CAN AFFECT YOUR RISK OF DIABETES",
                "How tall are you and how much do you weigh?",
                "On the left-hand side of the BMI chart below, circle your height, then on the bottom of the chart circle your weight.\n" +
                        "Find the square on the chart where your height crosses with your weight, and note which shaded area you fall into.\n" +
                        "For example, if you were 5 feet 2 inches (or 157.5cm) and 163 pounds (or 74kg) you would fall in the LIGHT GREY area",
                "",
                "Select your BMI group from the following choices:",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Less than 94 cm or 37 inches ", 0,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Between 94-102 cm or 37-40 inches", 4,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Over 102 cm or 40 inches", 6,true));


        ciskRiskDataModels.add( new CiskRiskDataModel(
                "BODY SHAPE AND SIZE CAN AFFECT YOUR RISK OF DIABETES",
                "Using a tape measure, place it around your waist at the level of your belly button.",
                "Measure after breathing out (do not hold your breath) and write your results on the line below.\n" +
                        "Then check the box that contains your measurement. (Note: this is not the same as the “waist size” on your pants).",
                "",
                "MEN – Waist circumference: _ _ _ inches OR _ _ _ cm",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Yes", 0,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No", 1,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "YOUR LEVEL OF PHYSICAL ACTIVITY AND WHAT YOU EAT CAN AFFECT YOUR RISK OF\n" +
                        "DEVELOPING DIABETES",
                "Do you usually do some physical activity such as brisk walking for at least 30 minutes each day? ",
                "This activity can be done while at work or at home",
                "",
                "",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Yes", 0,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No", 1,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "YOUR LEVEL OF PHYSICAL ACTIVITY AND WHAT YOU EAT CAN AFFECT YOUR RISK OF DEVELOPING DIABETES.",
                "Do you usually do some physical activity such as brisk walking for at least 30 minutes each day?",
                "This activity can be done while at work or at home",
                "",
                "",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Every day", 0,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Not every day", 2,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "YOUR LEVEL OF PHYSICAL ACTIVITY AND WHAT YOU EAT CAN AFFECT YOUR RISK OF DEVELOPING DIABETES.",
                "How often do you eat vegetables or fruits?",
                "",
                "",
                "",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Yes", 4,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No or don't know", 0,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                " High blood pressure, high blood sugar, and pregnancy-related factors\n" +
                        " are associated with diabetes",
                "Have you ever been told by a doctor or nurse that you have high blood pressure OR have you ever\n" +
                        "taken high blood pressure pills?",
                "",
                "",
                "",
                mAnswers


        ));



        mAnswers = new ArrayList<>();

        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Yes", 1,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No or don't know", 0,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                " High blood pressure, high blood sugar, and pregnancy-related factors\n" +
                        " are associated with diabetes.",
                "Have you ever been found to have a high blood sugar either from a blood test, during an illness,\n" +
                        "or during pregnancy?",
                "",
                "",
                "",
                mAnswers


        ));


        mAnswers = new ArrayList<>();
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Yes", 1,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No or don't know, or not applicable", 0,false));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                " High blood pressure, high blood sugar, and pregnancy-related factors\n" +
                        " are associated with diabetes.",
                "Have you ever given birth to a large baby weighing 9 pounds (4.1 kg) or more?",
                "",
                "",
                "",
                mAnswers


        ));



        mAnswers = new ArrayList<>();
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Mother", 2,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Father", 2,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Brothers/Sisters", 2,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Children", 2,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Other", 0,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("No/don't know", 0,true));

        ciskRiskDataModels.add( new CiskRiskDataModel(
                "SOME TYPES OF DIABETES RUN IN FAMILIES.",
                " Have any of your blood relatives ever been diagnosed with diabetes?",
                "Check All that apply.",
                "",
                "",
                mAnswers


        ));

        mAnswers = new ArrayList<>();
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Some high school or less", 5,true));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("High school diploma", 1,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("Some college or university", 0,false));
        mAnswers.add(new CiskRiskQuestionsAnswersDataModel("University or college degree", 0,false));


        ciskRiskDataModels.add( new CiskRiskDataModel(
                " High blood pressure, high blood sugar, and pregnancy-related factors\n" +
                        " are associated with diabetes.",
                "Have you ever given birth to a large baby weighing 9 pounds (4.1 kg) or more?",
                "",
                "",
                "",
                mAnswers


        ));

return ciskRiskDataModels;
    }

    private void initCiskRiskRecycleView() {
        Log.d(TAG, "initCiskRiskRecycleView: Called");

        if(getCiskRiskData().get(pos).getQuestionSubheader()==""){
            textViewCiskRiskQuestionSubheader.setHeight(0);
        }else
        textViewCiskRiskQuestionSubheader.setText(getCiskRiskData().get(pos).getQuestionSubheader());

        if(getCiskRiskData().get(pos).getQuestionAnswerOptionsHeader()==""){
            textViewCiskRiskOptionHeader.setHeight(0);
        }else
        textViewCiskRiskOptionHeader.setText(getCiskRiskData().get(pos).getQuestionAnswerOptionsHeader());

      if(getCiskRiskData().get(pos).getQuestionSubheader()==""){
          textViewCiskRiskQuestionSubheader.setHeight(0);
      }else
        textViewCiskRiskQuestionSubheader.setText(getCiskRiskData().get(pos).getQuestionSubheader());

        if(getCiskRiskData().get(pos).getQuestionAnswerOptionsHeader()==""){
            textViewCiskRiskOptionHeader.setHeight(0);
        }else
        textViewCiskRiskOptionHeader.setText(getCiskRiskData().get(pos).getQuestionAnswerOptionsHeader());


        if(getCiskRiskData().get(pos).getQuestion()==""){
            textViewCiskQuestion.setHeight(0);


        }else textViewCiskQuestion.setText("Question "+(pos+1) +": "+getCiskRiskData().get(pos).getQuestion());


        if(pos+1==4){
            imageViewCiskRiskQuestionImage.setImageResource(R.drawable.height_weight_image);
        }

        if(getCiskRiskData().get(pos).getQuestiongHeader()==""){
            textViewCiskQuestionHeader.setHeight(0);
        }else textViewCiskQuestionHeader.setText(getCiskRiskData().get(pos).getQuestiongHeader());

        RecyclerView recyclerViewCiskRisk = (RecyclerView) findViewById(R.id.recyclerViewCiskRisk);
        CiskRiskRecycleViewAdapter adapter = new CiskRiskRecycleViewAdapter(this, getCiskRiskData(),pos);
        recyclerViewCiskRisk.setAdapter(adapter);

        recyclerViewCiskRisk.setLayoutManager(new LinearLayoutManager(this));

    }
}
