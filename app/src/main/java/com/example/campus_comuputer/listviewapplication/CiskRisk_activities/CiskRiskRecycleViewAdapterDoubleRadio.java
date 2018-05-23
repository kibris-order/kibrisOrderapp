package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campus_comuputer.listviewapplication.R;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class CiskRiskRecycleViewAdapterDoubleRadio extends RecyclerView.Adapter<CiskRiskRecycleViewAdapterDoubleRadio.ViewHolder>{
    private static final String TAG = "CiskRiskRecycleViewAdap";
    private Context mContext;
    private ArrayList<CiskRiskDataModel> mCiskRiskDataModels = new ArrayList<>();
    private int pos;
    private int answerIndex =0;
    private int lastSelectedPosition1 = 0;
    private int lastSelectedPosition2 = 0;

    public CiskRiskRecycleViewAdapterDoubleRadio(Context mContext, ArrayList<CiskRiskDataModel> ciskRiskDataModels, int pos) {
        Log.d(TAG, "CiskRiskRecycleViewAdapter: Called");
        this.mContext = mContext;
        this.mCiskRiskDataModels = ciskRiskDataModels;
        this.pos =pos;
    }
//this is done

    //this is done
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_dradio_ciskrisk_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");

CiskRiskDataModel bindCiskModel = mCiskRiskDataModels.get(pos);
     /*if(mCiskRiskDataModels.get(pos).getQuestionAnswerOptions().get(position).isChecked())
        holder.radioButtonCiskRiskOption.setChecked(true);*/

        holder.textViewCiskRiskAnswerText.setText(bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getAnswer());

        holder.radioButtonCiskRiskOption1.setChecked(lastSelectedPosition1 == position);

        holder.radioButtonCiskRiskOption2.setChecked(lastSelectedPosition2 == position);

        if(lastSelectedPosition1 == position) {
            try {
                final String FILE_NAME = "file.txt";
                Log.d("Log", "Write file called");
                FileOutputStream fos = mContext.openFileOutput(FILE_NAME, Context.MODE_APPEND);
                String text = "QUESTION "+ (pos+1)+": Mother -"+bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getAnswer()+" points: "+bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getPoints() +"/n ";
                Log.d(TAG, "onBindViewHolder: saved in "+FILE_NAME+" "+text);
                fos.write(text.toString().getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            {
                Log.d(TAG, "onBindViewHolder:sharedPrefs begin ");

                SharedPreferences sharedPref = mContext.getSharedPreferences("question"+(pos+1) ,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            if(bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition1).getPoints() >bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition2).getPoints())
            editor.putInt("points",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition1).getPoints());
            else
                editor.putInt("points",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getPoints());

            editor.putString("answer",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getAnswer());
            editor.putInt("questionNo",pos+1);
            editor.apply();

                Log.d(TAG, "onBindViewHolder: sharedPrefs End");}

        }

        if(lastSelectedPosition2 == position) {
            try {
                final String FILE_NAME = "file.txt";
                Log.d("Log", "Write file called");
                FileOutputStream fos = mContext.openFileOutput(FILE_NAME, Context.MODE_APPEND);
                String text = "QUESTION "+ (pos+1)+": Father -"+bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getAnswer()+" points: "+bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getPoints() +"/n ";
                Log.d(TAG, "onBindViewHolder: saved in "+FILE_NAME+" "+text);
                fos.write(text.toString().getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            {
                Log.d(TAG, "onBindViewHolder:sharedPrefs begin ");

                SharedPreferences sharedPref = mContext.getSharedPreferences("question"+(pos+1) ,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                if(bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition1).getPoints() >bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition2).getPoints())
                    editor.putInt("points",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(lastSelectedPosition1).getPoints());
                else
                    editor.putInt("points",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getPoints());

                editor.putString("answer",bindCiskModel.getQuestionAnswerOptions().get(answerIndex).getAnswersArray().get(position).getAnswer());
                editor.putInt("questionNo",pos+1);
                editor.apply();

                Log.d(TAG, "onBindViewHolder: sharedPrefs End");}

        }


        Log.d(TAG, "onBindViewHolder: position is:"+position);
        Log.d(TAG, "onBindViewHolder: lastSelectedPosition == position ="+(lastSelectedPosition1 == position));
    }

    @Override
    public int getItemCount() {
        return mCiskRiskDataModels.get(pos).getQuestionAnswerOptions().get(answerIndex).getAnswersArray().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButtonCiskRiskOption1;
        RadioButton radioButtonCiskRiskOption2;
        //
        TextView textViewCiskRiskAnswerText;
        LinearLayout linearLayoutCiskRisk;


        public ViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: Called");
            //should have two
        radioButtonCiskRiskOption1 = (RadioButton) itemView.findViewById(R.id.radioButtonCiskRiskOption1);
        radioButtonCiskRiskOption2 = (RadioButton) itemView.findViewById(R.id.radioButtonCiskRiskOption2);
        //

        textViewCiskRiskAnswerText = (TextView) itemView.findViewById(R.id.textViewCiskRiskAnswerText);
        linearLayoutCiskRisk = (LinearLayout) itemView.findViewById(R.id.linearLayoutCiskRisk);
//need to create an additional adapter like this asap
            radioButtonCiskRiskOption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    lastSelectedPosition1 = getAdapterPosition();
                  notifyDataSetChanged();
                    Log.d(TAG, "radioButtonCiskRiskOptionOnClick1: has been clicked ");

                    Toast.makeText(CiskRiskRecycleViewAdapterDoubleRadio.this.mContext,
                            "selected answer is For father "+textViewCiskRiskAnswerText.getText(),
                            Toast.LENGTH_LONG).show();
                }
            });


            radioButtonCiskRiskOption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    lastSelectedPosition2 = getAdapterPosition();
                   notifyDataSetChanged();
                    Log.d(TAG, "radioButtonCiskRiskOptionOnClick1: has been clicked ");

                    Toast.makeText(CiskRiskRecycleViewAdapterDoubleRadio.this.mContext,
                            "selected answer is for mother"+textViewCiskRiskAnswerText.getText(),
                            Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
