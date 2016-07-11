package test;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("多伦多项目有什么");
//		System.out.println("\n\n\n\n");
//		test("多伦多的项目有什么");
	}
	
	public static void test(String content){
		RoughlyMatch roughlyMathc = new RoughlyMatch();
		QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
		ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
		try {
			Matches matches = roughlyMathc.roughlyMatch(content, questionBean, answerBeans);
			System.out.println(questionBean.getQOntology().toString());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(AnswerBean answerBean : answerBeans){
			
			System.out.println(answerBean.getQStr() + "\t" + answerBean.getAStr());
		}
	}

}
