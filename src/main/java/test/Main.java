package test;

/**
 * 注意事项:
	1. 每道题最多只能提交5次,取其中最高得分作为您的最终成绩；
	2. 程序从标准输入 stdin('Standard Input')获取输入，并将输出结果输出到标准输出stdout('Standard Output');
	3. 输入输出均不能含有任何提示信息；
	4. 测试平台的编译内核为VS2013及JDK1.7 。使用Java答题时，类名必须为"Main"，不要使用package关键字声明；使用C/C++答题时，请使用VS2013支持的数据类型和函数；
	5. 代码中不允许有任何文件操作；
	6. 提交答案时请提交全部代码，包括main函数和所有子函数；
	7. 建议您在本地编译完成后再到考试系统中提交,即在本地编译完成后将全部代码复制到答题框中，勿直接在答题框中作答；
	8. 答案提交后，点击状态可以查看判题结果及相应提示；
	9. 信息注册环节不可跳过，否则无法导出成绩。
 */

/**
 * Tom的生日礼物
描述:	
	四月一日快到了，Tom想了个愚人的好办法——送礼物。嘿嘿，不要想的太好，这礼物可没那么简单，Tom为了愚人，准备了一堆盒子，其中有一个盒子里面装了礼物。盒子里面可以再放零个或者多个盒子。假设放礼物的盒子里不再放其他盒子。
	用()表示一个盒子，A表示礼物，Tom想让你帮她算出愚人指数，即最少需要拆多少个盒子才能拿到礼物。
 
运行时间限制:	无限制
内存限制:	无限制
输入:	
	本题目包含多组测试，请处理到文件结束。
	每组测试包含一个长度不大于1000,只包含'(',')'和'A'三种字符的字符串，代表Tom设计的礼物透视图。
	你可以假设，每个透视图画的都是合法的。
输出:	
	对于每组测试，请在一行里面输出愚人指数。
样例输入:	
	((((A)()))())
	(A)
样例输出:	
	4
	1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = "";
		List<Integer> list = new ArrayList<Integer>();
		
		while(sc.hasNextLine()){
			line = sc.nextLine();
			int count = 0;
			for(int loop=0; loop<line.length(); loop++){
				char ch = line.charAt(loop);
				if(ch == '('){
					count++;
				}
				else if(ch == ')'){
					count--;
				}
				else{
					list.add(count);
					break;
				}
			}
		}
		
		for(Integer integer : list){
			System.out.println(integer);
		}
	}

}
