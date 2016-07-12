package test;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import edu.uestc.robot.ann.BestAnswer;
import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoughlyMatch roughlyMathc = new RoughlyMatch();
		QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
		ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
		try {
			Matches matches = roughlyMathc.roughlyMatch("多伦多", questionBean, answerBeans);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/**
		 * 三：调用程强机器学习接口，将模糊答案对象传递给这个接口，得到最优答案
		 */
		String result = BestAnswer.getBestAnswerString(questionBean, answerBeans);
		System.out.println(result);
	}

}
