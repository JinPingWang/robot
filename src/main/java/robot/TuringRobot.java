package robot;

import java.io.IOException;
import java.util.HashMap;

import json.Json;
import tuling.TuringRequestBean;
import tuling.TuringResponseBean;
import tuling.TuringHttpClient;

public class TuringRobot implements Robot {
	HashMap<String, String> contentMapReply;
	private static TuringRobot tulingRobot;

	private TuringRobot(){
		contentMapReply = new HashMap<String, String>();
		init();
	}

	private void init(){
		contentMapReply.put("您好", "您好！我是万国置地在线客服，请问有什么可以帮到您?");
	}
	
	public static TuringRobot getInstance(){
		if(tulingRobot == null){
			synchronized(TuringRobot.class){
				if(tulingRobot == null){
					tulingRobot = new TuringRobot();
				}
			}
		}
		return tulingRobot;
	}
	
	@Override	
	public String getReply(String content, String userId) throws IOException {
		String reply = contentMapReply.get(content); 
		if(reply != null){
			return reply;
		}

		TuringRequestBean turingBean = new TuringRequestBean("ae35e0925aa475708cd0f1892ac8c244", content, "1");
		Json json = new Json();
		String jsonString = json.getJson(turingBean);
		
		TuringHttpClient turingClient = new TuringHttpClient();
		
		TuringResponseBean turingResponseBean = (TuringResponseBean) json.getTuringResponseBean(turingClient.getResult(jsonString), new TuringResponseBean()); 
		return turingResponseBean.getText();
	}


}
