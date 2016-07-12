package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaoDian {
	public static String goodByeString;
	public static List<String> listFirst;
	public static List<String> listSecond;
	public static int maxCount;
	
	static {
		maxCount = 6;
		listFirst = new ArrayList<String>();
		listSecond = new ArrayList<String>();
		
		listFirst.add("能方便留个微信不？我们帮您备注一下，会定期投送国外房产信息哦");
		listFirst.add("我们会有促销活动，方便留个电话不？");
		listFirst.add("能方便给微信吗？我们会定期投送国外房产信息哦");
		listFirst.add("我们会经常有活动的，方便留个电话吗？");
		listFirst.add("能留个微信可以不？我们帮您备注一下，会定期推送最新资讯哦");
		listFirst.add("我们会有促销活动，方便留个微信吗？");
		
		listSecond.add("方便留个联系方式不？我让我们美女经理跟您详聊~");
		listSecond.add("请问您的微信号是？因为我这边是在线客服 信息掌握的不是很全面 可以安排专业顾问给您详细推荐一下");
		listSecond.add("您好！您可以留下您的联系方式 稍后我这边会转接到相关部门 如果有需要会给您打电话");
		listSecond.add("可以留下微信号不？我们有专门的美女服务向您介绍你需要的内容~");
		listSecond.add("能麻烦您留个电话不？我们会安排相关人员跟您详聊哈");
	}
	
	public static String getTaoDian(int type){
		if(type == 1){
			Random random = new Random();			
			return listFirst.get((int)(listFirst.size()*random.nextFloat()));
		}
		else{
			Random random = new Random();			
			return listSecond.get((int)(listSecond.size()*random.nextFloat()));
		}
	}
	
}
