package robot;

import java.util.HashMap;

public class MapRobot implements Robot {
	HashMap<String, String> contentMapReply;
	private static MapRobot mapRobot;
	
	private MapRobot(){
		contentMapReply = new HashMap<String, String>();
		init();
	}

	private void init(){
		contentMapReply.put("您好", "您好！我是万国置地在线客服，请问有什么可以帮到您?");
	}
	
	public static MapRobot getInstance(){
		if(mapRobot == null){
			synchronized(MapRobot.class){
				if(mapRobot == null){
					mapRobot = new MapRobot();
				}
			}
		}
		return mapRobot;
	}
	
	@Override
	public String getReply(String content, String userId) {
		// TODO Auto-generated method stub
		String reply = contentMapReply.get(content); 
		if(reply != null){
			return reply;
		}
		return "您可以留个微信或电话，稍后让资深顾问给你发送一些资料。您看看 这样不是更了解一些吗?";
	}

}
