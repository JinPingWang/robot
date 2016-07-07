package edu.uestc.robot.ann;

import java.util.ArrayList;

import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;

public class CreateMatrix {
	public static double[][] getMatrix(QuestionBean question,ArrayList<AnswerBean> answers){
		int Asize = answers.size();
		double[][] Matrix= new double[4][Asize];//四个特征属性
		for(int i=0;i<Asize;i++)
		{
			Matrix[0][i] = StringSimilarity.getStringSimilarity(question.getQStr(),answers.get(i).getQStr());
			Matrix[1][i] = SemanticSimilarity.getSemanticSimilarity(question.getQStr(),answers.get(i).getQStr());
			double[] temp = OntologyProportion.OntologySameQandA(question.getQOntology(),answers.get(i).getQOntology());
			Matrix[2][i] = temp[0];
			Matrix[3][i] = temp[1];
		}
		return Matrix;
	}
	
	/******测试一下getMatrix方法*********/
	/******测试样例在BestAnswer的main函数下*********/
	
}
