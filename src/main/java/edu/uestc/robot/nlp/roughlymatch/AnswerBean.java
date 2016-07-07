package edu.uestc.robot.nlp.roughlymatch;

import java.util.ArrayList;

public class AnswerBean {
	private String AStr;
	private String QStr;
	private ArrayList<String> QOntology;
	public AnswerBean() {

    }
	//构造方法
	public AnswerBean(String AStr,String QStr,ArrayList<String> QOntology){
		this.AStr = AStr;
		this.QStr = QStr;
		this.QOntology = QOntology; 
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
    public void setAOntology(ArrayList<String> QOntology) {  
        this.QOntology = QOntology;  
    }  
}
