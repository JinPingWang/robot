package edu.uestc.robot.nlp.roughlymatch;

import java.util.ArrayList;

public class AnswerBean implements Comparable<AnswerBean> {
    private String AStr;
    private String QStr;
    private ArrayList<String> QOntology;
    private ArrayList<String> AOntology;
    private int matchedOntoNum;
    private int matchedOntoCityNum;
    public AnswerBean() {

    }
    //构造方法
    public AnswerBean(String AStr,String QStr,ArrayList<String> QOntology, ArrayList<String> AOntology){
        this.AStr = AStr;
        this.QStr = QStr;
        this.QOntology = QOntology;
        this.AOntology = AOntology;
    }

    public ArrayList<String> getAOntology() {
        return AOntology;
    }

    public int getMatchedOntoCityNum() {
        return matchedOntoCityNum;
    }

    public void setMatchedOntoCityNum(int matchedOntoCityNum) {
        this.matchedOntoCityNum = matchedOntoCityNum;
    }

    public void setQOntology(ArrayList<String> QOntology) {
        this.QOntology = QOntology;
    }

    public int getMatchedOntoNum() {
        return matchedOntoNum;
    }

    public void setMatchedOntoNum(int matchedOntoNum) {
        this.matchedOntoNum = matchedOntoNum;
    }

    public String getAStr() {
        return AStr;
    }
    public void setAStr(String AStr) {
        this.AStr = AStr;
    }

    public String getQStr() {
        return QStr;
    }
    public void setQStr(String QStr) {
        this.QStr = QStr;
    }

    public ArrayList<String> getQOntology() {
        return QOntology;
    }
    public void setAOntology(ArrayList<String> AOntology) {
        this.AOntology = AOntology;

    }
    public int compareTo(AnswerBean answerBean) {
//        System.out.println("this.matchedOntoNum: " + this.matchedOntoNum + "; answerBeanOntoNum: " + answerBean.matchedOntoNum);
        if (this.matchedOntoNum < answerBean.matchedOntoNum) {
            return -1;
        }
        if (this.matchedOntoNum > answerBean.matchedOntoNum) {
            return 1;
        }
        System.out.println("this.matchedOntoCityNum: " + this.matchedOntoCityNum + "; " + answerBean.matchedOntoCityNum);
        if (this.matchedOntoCityNum > answerBean.matchedOntoCityNum) return 1;
        if (this.matchedOntoCityNum < answerBean.matchedOntoCityNum) return -1;
        return 0;
    }
    @Override
    public String toString() {
        return this.QStr + ": " + this.AStr + "; Qontologies: " + this.QOntology.toString();
    }
}