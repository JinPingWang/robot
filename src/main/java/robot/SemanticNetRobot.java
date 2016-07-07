package robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.dom4j.DocumentException;

import edu.uestc.robot.ann.BestAnswer;
import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;

public class SemanticNetRobot implements Robot {
	HashMap<String, String> contentMapReply;
	private static SemanticNetRobot semanticNetRobot;

	private SemanticNetRobot(){
		contentMapReply = new HashMap<String, String>();
		init();
	}

	private void init(){
		contentMapReply.put("您好", "您好！我是万国置地在线客服，请问有什么可以帮到您?");
	}
	
	public static SemanticNetRobot getInstance(){
		if(semanticNetRobot == null){
			synchronized(SemanticNetRobot.class){
				if(semanticNetRobot == null){
					semanticNetRobot = new SemanticNetRobot();
				}
			}
		}
		return semanticNetRobot;
	}
	
	@Override
	public String getReply(String content, String useId) throws IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 一：保存语义网络需要的数据
		 */
		
		/**
		 * 二：调用杨彬自然语言接口，得到模糊答案对象
		 */
		RoughlyMatch roughlyMathc = new RoughlyMatch();
		QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
		ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
		try {
			Matches matches = roughlyMathc.roughlyMatch(content, questionBean, answerBeans);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 三：调用程强机器学习接口，将模糊答案对象传递给这个接口，得到最优答案
		 */
		String result = BestAnswer.getBestAnswerString(questionBean, answerBeans);
		
		/**
		 * 四：如果最优答案为null，则调用刘爽黄为的主义网络，构造答案
		 */
		
		/**
		 * 五：将答案返回
		 */
		return result;
	}

}
