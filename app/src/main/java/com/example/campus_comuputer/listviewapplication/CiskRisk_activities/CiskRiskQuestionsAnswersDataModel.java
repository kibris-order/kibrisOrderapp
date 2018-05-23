package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class CiskRiskQuestionsAnswersDataModel {
    private String answer;
    private int points;
    private boolean isChecked;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public CiskRiskQuestionsAnswersDataModel(String answer, int points, boolean isChecked) {
        this.answer = answer;
        this.points = points;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    public static class CiskRiskQuestionsAnswersDataModelArr{
        private ArrayList<CiskRiskQuestionsAnswersDataModel> AnswersArray;

        public CiskRiskQuestionsAnswersDataModelArr(ArrayList<CiskRiskQuestionsAnswersDataModel> answersArray) {
            AnswersArray = answersArray;
        }


        public ArrayList<CiskRiskQuestionsAnswersDataModel> getAnswersArray() {
            return AnswersArray;
        }

        public void setAnswersArray(ArrayList<CiskRiskQuestionsAnswersDataModel> answersArray) {
            AnswersArray = answersArray;
        }
    }
}


