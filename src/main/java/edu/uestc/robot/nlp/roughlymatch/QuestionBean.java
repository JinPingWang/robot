package edu.uestc.robot.nlp.roughlymatch;

import java.util.ArrayList;

public class QuestionBean {
	private String QStr;
	private ArrayList<String> QOntology;

    public QuestionBean() {

    }
	//构造方法
	public QuestionBean(String QStr,ArrayList<String> QOntology){
		this.QStr = QStr;
		this.QOntology = QOntology; 
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
    public void setQOntology(ArrayList<String> QOntology) {  
        this.QOntology = QOntology;  
    }  
    @Override
    public String toString() {
    	return this.QStr + ", QOntology" + this.QOntology.toString();
    }
}
