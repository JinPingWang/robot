package edu.uestc.robot.ann;

import java.util.ArrayList;

public class OntologyProportion {
	
	/**
	 * 计算问题与答案之间本体相同的比例
	 * @author: Administrator
	 * @Date: 2016年7月2日
	 * @param question
	 * @param answer
	 * @return
	 */
	public static double[] OntologySameQandA(ArrayList<String> question,ArrayList<String> answer){
		double[] percent = {0,0};
		int Qsize = question.size();
		int Asize = answer.size();
		if(Qsize == 0 || Asize == 0)
		{
			return percent;
		}
		int count = 0;
		for(int i=0;i<Qsize;i++)
		{
			for(int j=0;j<Asize;j++)
			{
				if(question.get(i).equals(answer.get(j)))
				{
//					if(j == 0)
//						percent[1] = 1;
					count++;
					break;
				}else{
					continue;
				}
			}
		}
		percent[0] = (double)count / (double)Qsize;
		percent[1] = (double)count / (double)Asize;
		return percent;
	}
	
	/******测试一下OntologySameQandA方法*********/
	public static void main(String[] args){
		ArrayList<String> question = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		question.add("澳大利亚");
		question.add("房子");
		question.add("贵");
		answer.add("澳大利亚");
		answer.add("房产");
		answer.add("首付");
		answer.add("贷款");
		answer.add("自住");
		answer.add("投资");
		for(double temp : OntologySameQandA(question, answer))
		    System.out.println(temp);
	}
}
