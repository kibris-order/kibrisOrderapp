package com.example.campus_comuputer.listviewapplication.CiskRisk_activities;

import java.util.ArrayList;

/**
 * Created by Campus-Comuputer on 4/27/2018.
 */

public class CiskRiskDataModel {
    private String questiongHeader;
    private String question;
    private String questionSubheader;
    private String questionImageUrl;
    private String questionAnswerOptionsHeader;
    private ArrayList<CiskRiskQuestionsAnswersDataModel.CiskRiskQuestionsAnswersDataModelArr> questionAnswerOptions= new ArrayList<>();

    public CiskRiskDataModel(String questiongHeader, String question, String questionSubheader, String questionImageUrl, String questionAnswerOptionsHeader, ArrayList<CiskRiskQuestionsAnswersDataModel.CiskRiskQuestionsAnswersDataModelArr> questionAnswerOptions) {
            this.questiongHeader = questiongHeader;
        this.question = question;
        this.questionSubheader = questionSubheader;
        this.questionImageUrl = questionImageUrl;
        this.questionAnswerOptionsHeader = questionAnswerOptionsHeader;
        this.questionAnswerOptions = questionAnswerOptions;
    }

    public void setAllCheckedToFalse(){


    }
    public String getQuestionAnswerOptionsHeader() {
        return questionAnswerOptionsHeader;
    }

    public void setQuestionAnswerOptionsHeader(String questionAnswerOptionsHeader) {
        this.questionAnswerOptionsHeader = questionAnswerOptionsHeader;
    }

    public String getQuestionSubheader() {
        return questionSubheader;
    }

    public void setQuestionSubheader(String questionSubheader) {
        this.questionSubheader = questionSubheader;
    }

    public String getQuestionImageUrl() {
        return questionImageUrl;
    }

    public void setQuestionImageUrl(String questionImageUrl) {
        this.questionImageUrl = questionImageUrl;
    }

    public String getQuestiongHeader() {
        return questiongHeader;
    }

    public void setQuestiongHeader(String questiongHeader) {
        this.questiongHeader = questiongHeader;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<CiskRiskQuestionsAnswersDataModel.CiskRiskQuestionsAnswersDataModelArr> getQuestionAnswerOptions() {
        return questionAnswerOptions;
    }

    public void setQuestionAnswerOptions(ArrayList<CiskRiskQuestionsAnswersDataModel.CiskRiskQuestionsAnswersDataModelArr> questionAnswerOptions) {
        this.questionAnswerOptions = questionAnswerOptions;
    }
}
