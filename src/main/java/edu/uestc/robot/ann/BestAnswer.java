package edu.uestc.robot.ann;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dom4j.DocumentException;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import BPModel.MatlabBP;
import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;

public class BestAnswer {
	public static int getBestAnswerIndex(double[][] Matrix){
		int answer_num = Matrix[0].length;
		double MAX = 0;
		int best_answer_index = -1;
		MWNumericArray MatlabInput = null;
		Object[] result = null;
		MatlabBP myAnn = null;
		try{
			MatlabInput = new MWNumericArray(Matrix, MWClassID.DOUBLE);
//			System.out.println("输入Matlab的ANN训练模型的矩阵为： " + MatlabInput);
			myAnn = new MatlabBP();
			result = myAnn.predict0703(1,MatlabInput);
//	   	    System.out.println("经过Matlab的ANN模型计算后，结果为： " + result[0]);
	   	    for(int i=1;i<=answer_num;i++){
	       	    double res = ((MWNumericArray) result[0]).getDouble(i);
	       	    if(res > MAX){
	       	    	MAX = res;
	       	    	best_answer_index = i-1;
	       	    }
	   	    }
	   	    if(MAX < 0.75)
	   	    	best_answer_index = -2;
		}catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }finally{
            MWArray.disposeArray(MatlabInput);
            MWArray.disposeArray(result);
            if (myAnn != null)
            	myAnn.dispose();
        }
		//如果返回-1或者-2表示获取最好答案下标失败，否则正常的话，应该返回0~9之间的数字
		return best_answer_index;
	}
	


	public static ArrayList<AnswerBean> getBestAnswerArrayList(QuestionBean question,ArrayList<AnswerBean> answers,double yuzhi){
		System.out.println("entry"+answers.get(0).getQStr()+"\t"+answers.get(0).getAStr()+"\t"+answers.get(0).getAOntology());
		
		double[][] Matrix = CreateMatrix.getMatrix(question,answers);
		int answer_num = Matrix[0].length;
		double MAX = 0;
		int best_answer_index = -1;
		MWNumericArray MatlabInput = null;
		Object[] result = null;
		MatlabBP myAnn = null;
		ArrayList<Double> match_rate = new ArrayList<Double>();
		ArrayList<AnswerBean> first_answers = new ArrayList<AnswerBean>();
		try{
			MatlabInput = new MWNumericArray(Matrix, MWClassID.DOUBLE);
//			System.out.println("输入Matlab的ANN训练模型的矩阵为： " + MatlabInput);
			myAnn = new MatlabBP();
			result = myAnn.predict0703(1,MatlabInput);
//	   	    System.out.println("经过Matlab的ANN模型计算后，结果为： " + result[0]);
	   	    for(int i=1;i<=answer_num;i++){
	       	    double res = ((MWNumericArray) result[0]).getDouble(i);
		       	    if(res > MAX){
		       	    	MAX = res;
		       	    }
//	       	    	match_rate.add(res);
//	       	    	first_answers.add(answers.get(i-1));
	   	    }
	   	    for(int i=1;i<=answer_num;i++){
	       	    double res = ((MWNumericArray) result[0]).getDouble(i);
	   	    	if(res > yuzhi && MAX-res < 0.3){
	   	    		first_answers.add(answers.get(i-1));
	   	    	}
	   	    }
	   	    /**********打印中间List,看看结果***********/
//	   	    for(int i=0;i<match_rate.size();i++){
//	   	    	System.out.println(match_rate.get(i) + "   " + first_answers.get(i).getQStr() + "   " + first_answers.get(i).getAStr());
//	   	    }
	   	    /**********对匹配度进行排序***********/
//	   	 quickSort(array,0,array.length-1);
	   	    
	   	    if(MAX < yuzhi)
	   	    	best_answer_index = -2;
		}catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }finally{
            MWArray.disposeArray(MatlabInput);
            MWArray.disposeArray(result);
            if (myAnn != null)
            	myAnn.dispose();
        }
		//如果返回-1或者-2表示获取最好答案下标失败，否则正常的话，应该返回0~9之间的数字
		System.out.println("返回答案的下标为： " + best_answer_index);
		return first_answers;
	}
	
	public static String getBestAnswerString(QuestionBean question,ArrayList<AnswerBean> answers){
		double[][] temp = CreateMatrix.getMatrix(question,answers);
		for(int i=0;i<temp.length;i++)
		{
			for(int j=0;j<temp[0].length;j++)
			{
//				System.out.print(temp[i][j] + "  ");
			}
//			System.out.println();
//			System.out.println();
		}
		int best_answer_index = BestAnswer.getBestAnswerIndex(temp);
//		System.out.println("*************当前的问题为*******************");
//		System.out.println(question.getQStr());
//		System.out.println("*************公布最佳答案*******************");
		if(best_answer_index == -1)
		{
//			System.out.println("ERROR !!!    获取最佳答案失败，下标为-1");
			return "";
		}
		else if(best_answer_index == -2)
		{
			System.out.println("ERROR !!!    获取最佳答案失败，下标为-2，表示所有答案的适应度的最大值都没有超过阈值");
			return "";
		}
		else
		{
//			System.out.println(answers.get(best_answer_index).getAStr());
			return answers.get(best_answer_index).getAStr();
		}
	}

	
	/******测试一下CreateMatrix类下的getMatrix方法*********/
	/******测试一下getBestAnswerIndex方法*********/
	/******测试一下getBestAnswerString方法
	 * @throws FileNotFoundException *********/
	
	public static void main(String[] args){
		ArrayList<String> QOntology1 = new ArrayList<String>();
		
//		QOntology1.add("墨尔本");
//		QOntology1.add("房价");
//		QuestionBean question = new QuestionBean("墨尔本那边的房价如何啊？我想咨询一下，谢谢。",QOntology1);
		
		QOntology1.add("澳大利亚");
		QOntology1.add("房产");
		QuestionBean question = new QuestionBean("想了解澳大利亚那边的房产",QOntology1);
		
//		QOntology1.add("投资");
//		QuestionBean question = new QuestionBean("投资",QOntology1);
		
//		ArrayList<String> AOntology1 = new ArrayList<String>();
//		AOntology1.add("悉尼");
//		AOntology1.add("公寓");
//		AOntology1.add("平米");
//		AOntology1.add("价格");
//		AnswerBean A1 = new AnswerBean("澳洲房产目前是35万澳币起。首付10-15%，可办理贷款，贷款一般跟国内的贷款年限差不多 请问您是打算自住还是投资？","悉尼的公寓一平米多少钱",AOntology1);
//		ArrayList<String> AOntology2 = new ArrayList<String>();
//		AOntology2.add("移民");
//		AOntology2.add("公司");
//		AOntology2.add("澳大利亚");
//		AOntology2.add("房产");
//		AOntology2.add("合作");
//		AOntology2.add("负责人");
//		AOntology2.add("联系");
//		AnswerBean A2 = new AnswerBean("您可以留下您的联系方式 稍后我这边会转接到相关部门 如果有需要会给您打电话的","我是移民公司。有澳洲房产。想与贵公司谈合作。是跟哪位负责人联系？",AOntology2);
//		ArrayList<String> AOntology3 = new ArrayList<String>();
//		AOntology3.add("日期");
//		AOntology3.add("澳大利亚");
//		AOntology3.add("房产");
//		AOntology3.add("介绍");
//		AnswerBean A3 = new AnswerBean("主要是针对海外房产投资趋势等。当然是包括澳洲房产介绍","我想问5.7有澳大利亚房产介绍吗",AOntology3);
//		ArrayList<String> AOntology4 = new ArrayList<String>();
//		AOntology4.add("澳大利亚");
//		AOntology4.add("房产");
//		AOntology4.add("价格");
//		AOntology4.add("平米");
//		AnswerBean A4 = new AnswerBean("澳洲房产目前是35万澳币起。首付10-15%，可办理贷款。海外房产不同于国内按照单纯平米计算。 房产总值需结合房产面积，户型，朝向等来综合计算。需要这边先给您安排顾问就澳洲房产给您介绍一下吗？","澳洲房产目前多少钱一平米",AOntology4);
//		ArrayList<String> AOntology5 = new ArrayList<String>();
//		AOntology5.add("澳大利亚");
//		AOntology5.add("房子");
//		AOntology5.add("贵");
//		AnswerBean A5 = new AnswerBean("澳洲房产目前是35万澳币起。首付10-15%，可办理贷款。您是打算自住还是投资？","澳洲的房子贵不贵",AOntology5);
//		ArrayList<String> AOntology6 = new ArrayList<String>();
//		AOntology6.add("澳大利亚");
//		AOntology6.add("公寓");
//		AOntology6.add("价格");
//		AOntology6.add("平米");
//		AnswerBean A6 = new AnswerBean("您好 海外房产是按照房产总值来算的 澳洲房产目前是35万澳币起。首付10-15%，可办理贷款。 请问您是打算自住还是投资？","澳洲cbd大学公寓多钱一平米",AOntology6);
//		ArrayList<String> AOntology7 = new ArrayList<String>();
//		AOntology7.add("悉尼");
//		AOntology7.add("澳大利亚");
//		AOntology7.add("公寓");
//		AOntology7.add("价格");
//		AnswerBean A7 = new AnswerBean("您好 澳洲房产目前是35万澳币起。首付810-15%，可办理贷款。 请问您是打算自住还是投资？","请问希尼市中心的公寓总价多少",AOntology7);
//		ArrayList<String> AOntology8 = new ArrayList<String>();
//		AOntology8.add("墨尔本");
//		AOntology8.add("公寓");
//		AOntology8.add("房价");
//		AnswerBean A8 = new AnswerBean("澳洲房产目前是35万澳币起。首付10-15%，可办理贷款。 请问您是打算自住还是投资？","墨尔本cBD皇家广场公寓房价多少",AOntology8);
//		ArrayList<String> AOntology9 = new ArrayList<String>();
//		AOntology9.add("澳大利亚");
//		AOntology9.add("房产");
//		AnswerBean A9 = new AnswerBean("您好 请问您是打算购买公寓还是别墅呢？","想咨询澳洲房产",AOntology9);
//		ArrayList<String> AOntology10 = new ArrayList<String>();
//		AOntology10.add("澳大利亚");
//		AOntology10.add("便宜");
//		AOntology10.add("价格");
//		AnswerBean A10 = new AnswerBean("您好 这边是客服，只能给您大概范围是30万澳币起 可以贷款","想咨询一下，澳洲一居比较便宜的大概多少钱",AOntology10);
//		ArrayList<String> AOntology11 = new ArrayList<String>();
//		AOntology11.add("澳大利亚");
//		AOntology11.add("便宜");
//		AOntology11.add("价格");
//		AnswerBean A11 = new AnswerBean("您好 这边是客服，只能给您大概范围是30万澳币起 可以贷款","想咨询一下，澳洲一居比较便宜的大概多少钱",AOntology11);
//		ArrayList<AnswerBean> answers = new ArrayList<AnswerBean>();
//		answers.add(A1);
//		answers.add(A2);
//		answers.add(A3);
//		answers.add(A4);
//		answers.add(A5);
//		answers.add(A6);
//		answers.add(A7);
//		answers.add(A8);
//		answers.add(A9);
//		answers.add(A10);
//		answers.add(A11);
		
//		String return_answer = BestAnswer.getBestAnswerString(question,answers);
//		System.out.println("**********main函数里的测试***********");
//		System.out.println("回答为：   " + return_answer);
	}
	
	
//    public static void main(String[] args) throws FileNotFoundException {
//        RoughlyMatch roughlyMatch = new RoughlyMatch();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String s = scanner.nextLine();
//            QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
//            ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
//            Matches matches = null;
//            try {
//                matches = roughlyMatch.roughlyMatch(s, questionBean, answerBeans);
//                String return_answer = BestAnswer.getBestAnswerString(questionBean,answerBeans);
//
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            }
//            System.out.println(matches.toString());
//        }

//    }
}
