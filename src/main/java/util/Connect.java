package util;

public class Connect {
	public static boolean answerContainConnectString(String content){
		if(content == null){
			return false;
		}
		if(content.contains("联系") || content.contains("电话") || content.contains("微信")){
			return true;
		}
		return false;
	}
	
	public static boolean contentContainConnectString(String content){
		int count = 0;
		for(int loop=0; loop<content.length(); loop++){
			char ch = content.charAt(loop);
			if( 0<ch && ch<255){
				count++;
			}
		}
		
		if((content.contains("电话") || content.contains("微信")) && count>3){
			return true;
		}
		
		if(count >= 5){
			return true;
		}
		return false;
	}
}
