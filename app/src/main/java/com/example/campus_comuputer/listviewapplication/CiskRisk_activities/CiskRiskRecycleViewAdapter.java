package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.campus_comuputer.listviewapplication.R;
import com.example.campus_comuputer.listviewapplication.zoftinoRecycleViewActivity.OffersRecyclerViewAdapter;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class CiskRiskRecycleViewAdapter extends RecyclerView.Adapter<CiskRiskRecycleViewAdapter.ViewHolder>{
    private static final String TAG = "CiskRiskRecycleViewAdap";
    private Context mContext;
    private ArrayList<CiskRiskDataModel> mCiskRiskDataModels = new ArrayList<>();
    private int pos;
    private int arrayIndex;
    private int lastSelectedPosition = -1;

    public CiskRiskRecycleViewAdapter(Context mContext, ArrayList<CiskRiskDataModel> ciskRiskDataModels, int pos) {
        Log.d(TAG, "CiskRiskRecycleViewAdapter: Called");
        this.mContext = mContext;
        this.mCiskRiskDataModels = ciskRiskDataModels;
        SharedPreferences sharedPrefd = mContext.getSharedPreferences("question2" , Context.MODE_PRIVATE);

        String xs =sharedPrefd.getString("answer","Male");
        if(pos ==3 && xs.equals("Female")){
            arrayIndex =1;}

        this.pos =pos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_ciskrisk_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");

CiskRiskDataModel bindCiskModel = mCiskRiskDataModels.get(pos);
     /*if(mCiskRiskDataModels.get(pos).getQuestionAnswerOptions().get(position).isChecked())
        holder.radioButtonCiskRiskOption.setChecked(true);*/

        holder.textViewCiskRiskAnswerText.setText(bindCiskModel.getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().get(position).getAnswer());

        holder.radioButtonCiskRiskOption.setChecked(lastSelectedPosition == position);

        if(lastSelectedPosition == position) {
            try {
                final String FILE_NAME = "file.txt";
                Log.d("Log", "Write file called");
                FileOutputStream fos = mContext.openFileOutput(FILE_NAME, Context.MODE_APPEND);
                String text = "QUESTION "+ (pos+1)+":"+bindCiskModel.getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().get(position).getAnswer()+" points: "+bindCiskModel.getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().get(position).getPoints() +"/n ";
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
            editor.putInt("points",bindCiskModel.getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().get(position).getPoints());
            editor.putString("answer",bindCiskModel.getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().get(position).getAnswer());
            editor.putInt("questionNo",pos+1);
            editor.apply();

                Log.d(TAG, "onBindViewHolder: sharedPrefs End");}

        }


        Log.d(TAG, "onBindViewHolder: position is:"+position);
        Log.d(TAG, "onBindViewHolder: lastSelectedPosition == position ="+(lastSelectedPosition == position));
    }

    @Override
    public int getItemCount() {
        return mCiskRiskDataModels.get(pos).getQuestionAnswerOptions().get(arrayIndex).getAnswersArray().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButtonCiskRiskOption;
        TextView textViewCiskRiskAnswerText;
        LinearLayout linearLayoutCiskRisk;


        public ViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: Called");
        radioButtonCiskRiskOption = (RadioButton) itemView.findViewById(R.id.radioButtonCiskRiskOption);
        textViewCiskRiskAnswerText = (TextView) itemView.findViewById(R.id.textViewCiskRiskAnswerText);
        linearLayoutCiskRisk = (LinearLayout) itemView.findViewById(R.id.linearLayoutCiskRisk);
//need to create an additional adapter like this asap
            radioButtonCiskRiskOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                    Log.d(TAG, "radioButtonCiskRiskOptionOnClick: has been clicked ");

                    Toast.makeText(CiskRiskRecycleViewAdapter.this.mContext,
                            "selected answer is "+textViewCiskRiskAnswerText.getText(),
                            Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
