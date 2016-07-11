package test;

import java.util.ArrayList;

import org.dom4j.DocumentException;

import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "投资";
		RoughlyMatch roughlyMathc = new RoughlyMatch();
		QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
		ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
		try {
			Matches matches = roughlyMathc.roughlyMatch(content, questionBean, answerBeans);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(answerBeans.size());
		System.out.println(answerBeans.get(0).getQStr());
		System.out.println(answerBeans.get(0).getAStr());
		System.out.println(answerBeans.get(0).getAOntology());
		
	}

}
