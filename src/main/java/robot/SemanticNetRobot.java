package robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;

import edu.uestc.robot.ann.BestAnswer;
import edu.uestc.robot.nlp.roughlymatch.AnswerBean;
import edu.uestc.robot.nlp.roughlymatch.Matches;
import edu.uestc.robot.nlp.roughlymatch.QuestionBean;
import edu.uestc.robot.nlp.roughlymatch.RoughlyMatch;
import edu.uestc.robot.semantic.Arq;
import util.Connect;
import util.TaoDian;

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
	
	@SuppressWarnings("unused")
	@Override
	public String getReply(String content, HttpSession userSession) throws IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 一
		 * 1：得到上一个问题的本体，并保存语义网络需要的数据
		 * 2：得到客服上一次的回答，用于判断客服是否问了顾客联系方式
		 * 3：count用于统计与顾客的对话次数，如果超过一定的次数进行套电
		 * 4：判断客服是否问顾客联系方式以及顾客是否有回答联系方式
		 */
		List<String> lastOntology = (List<String>) userSession.getAttribute("lastOntology");
		String lastAnswer = (String) userSession.getAttribute("lastAnswer");
		Integer count = (Integer)userSession.getAttribute("count"); 
	
		if(count == null){
			userSession.setAttribute("count", 1);
			count = 1;
		}
		else{
			userSession.setAttribute("count", count+1);
		}
		
		if(Connect.answerContainConnectString(lastAnswer) && Connect.contentContainConnectString(content)){
			return "好的，稍候我们会有专门的客服联系您的。";
		}
		
		{
			RoughlyMatch roughlyMathc = new RoughlyMatch();
			QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
			ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
			try {
				Matches matches = roughlyMathc.roughlyMatch(content, questionBean, answerBeans);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			List<String> ontology = questionBean.getQOntology();
			userSession.setAttribute("lastOntology", ontology);
		}
		
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
		String result = "";
		if(answerBeans.size() == 0){
//			result = count < TaoDian.maxCount ? TuringRobot.getInstance().getReply(content, userSession)+"\n"+TaoDian.getTaoDian(1) : TaoDian.getTaoDian(2);
			result = count < TaoDian.maxCount ? TuringRobot.getInstance().getReply(content, userSession) : TaoDian.getTaoDian(2);
			userSession.setAttribute("lastAnswer", result);
		}
		else{
			if(lastOntology != null){
				List<AnswerBean> answerBeanList = BestAnswer.getBestAnswerArrayList(questionBean, answerBeans, 0.5d);
				result = getAnswer(lastOntology, answerBeanList);
			}
			else{
				result = BestAnswer.getBestAnswerString(questionBean, answerBeans);
			}
		}
			
		/**
		 * 四：如果最优答案为""，则调用刘爽黄为的语义网络，构造答案
		 */
		String semanticResult = "";
		try{
			semanticResult = Arq.ARQ(content);
		}
		catch(Exception e){
//			semanticResult = "";
			
			System.out.println(e.getMessage());
		}
		if(!semanticResult.equals("")){
			result = "语料库答案：" + result + "<pre></pre>" + "语义网络答案：" + semanticResult; 
		}
		
		/**
		 * 五：将答案返回
		 */
		if(result.length() == 0){
//			result = count < TaoDian.maxCount ? TuringRobot.getInstance().getReply(content, userSession)+"\n"+TaoDian.getTaoDian(1) : TaoDian.getTaoDian(2);
			result = count < TaoDian.maxCount ? TuringRobot.getInstance().getReply(content, userSession) : TaoDian.getTaoDian(2);			
			userSession.setAttribute("lastAnswer", result);
		}
		return result;
	}

	private String getAnswer(List<String> lastOntology, List<AnswerBean> answerBeanList){
		int countMax=0;
		int index = 0;
		for(int loop=0; loop<answerBeanList.size(); loop++){
			int count = 0;
			for(String ontology : lastOntology){
				if(answerBeanList.get(loop).getAOntology().contains(ontology)){
					count++;
				}
			}
			if(count > countMax){
				countMax = count;
				index = loop;
			}
		}
		return answerBeanList.get(index).getAStr();
	}
}
