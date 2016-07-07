package test;

import java.util.ArrayList;
import java.util.Scanner;

import org.dom4j.DocumentException;

import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;

public class TestNLP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoughlyMatch roughlyMathc = new RoughlyMatch();
		QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
		ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
		try {
			Matches matches = roughlyMathc.roughlyMatch("有上海联系点吗？", questionBean, answerBeans);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
