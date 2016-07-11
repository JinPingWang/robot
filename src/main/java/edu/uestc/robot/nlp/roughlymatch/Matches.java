package edu.uestc.robot.nlp.roughlymatch;

import java.util.ArrayList;

/**
 * Created by yb on 2016/6/28 0028.
 */
public class Matches {
    public String userQuestion;
    public String userQuestionOntology;
    public ArrayList<String> matchedQuestions;
    public ArrayList<String> matchedAnswers;
    public ArrayList<String> matchedQuestionsOntology;
    public ArrayList<String> matchedAnswersOntology;
    public ArrayList<Double> recallRates;
    public ArrayList<Integer> matchedOntoNums;
    public ArrayList<Integer> matchedOntoCityNums;

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserQuestionOntology() {
        return userQuestionOntology;
    }

    public void setUserQuestionOntology(String userQuestionOntology) {
        this.userQuestionOntology = userQuestionOntology;
    }

    public ArrayList<String> getMatchedQuestions() {
        return matchedQuestions;
    }

    public void setMatchedQuestions(ArrayList<String> matchedQuestions) {
        this.matchedQuestions = matchedQuestions;
    }

    public ArrayList<String> getMatchedAnswers() {
        return matchedAnswers;
    }

    public void setMatchedAnswers(ArrayList<String> matchedAnswers) {
        this.matchedAnswers = matchedAnswers;
    }

    public ArrayList<String> getMatchedQuestionsOntology() {
        return matchedQuestionsOntology;
    }

    public void setMatchedQuestionsOntology(ArrayList<String> matchedQuestionOntology) {
        this.matchedQuestionsOntology = matchedQuestionOntology;
    }

    public ArrayList<String> getMatchedAnswersOntology() {
        return matchedAnswersOntology;
    }

    public void setMatchedAnswersOntology(ArrayList<String> matchedAnswersOntology) {
        this.matchedAnswersOntology = matchedAnswersOntology;
    }

    public ArrayList<Double> getRecallRates() {
        return recallRates;
    }

    public void setRecallRates(ArrayList<Double> recallRates) {
        this.recallRates = recallRates;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("问题是：" + userQuestion + "\n");
        sb.append("问题和答案分别是：\n");
        for (int i = 0; i < matchedQuestions.size(); ++i) {
            sb.append(matchedQuestions.get(i) +": " + matchedAnswers.get(i) + "\n");
        }

        return sb.toString();
    }
}
