package edu.uestc.robot.ann;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class SemanticSimilarity {
	
	public static double YUZHI = 0.2;//阈值
	
	/**
	 * 返回两个Vector<String>的相似度百分比
	 * @author: CQ
	 * @Date: 2016年月2日
	 * @param T1
	 * @param T2
	 * @return
	 */
	public static double CalculateSimilarity(Vector<String> T1, Vector<String> T2) throws Exception{
		int size = 0 , size2 = 0 ;
	    if ( T1 != null && ( size = T1.size() ) > 0 && T2 != null && ( size2 = T2.size() ) > 0 )
	    {
	    	Map<String, double[]> T = new HashMap<String, double[]>();
	        //T1和T2的并集T
	    	String index = null ;
	        for ( int i = 0 ; i < size ; i++ )
	        {
	        	index = T1.get(i);
	            if(index != null)
	            {
	            	double[] c = T.get(index);
	                c = new double[2];
	                c[0] = 1;	//T1的语义分数Ci
	                c[1] = YUZHI;//T2的语义分数Ci
	                T.put( index, c );
	            }
	        }
	        for (int i = 0; i < size2 ; i++)
	        {
	        	index = T2.get(i) ;
	        	if(index != null)
	        	{
	        		double[] c = T.get( index );
	        		if(c != null && c.length == 2)
	        		{
	        			c[1] = 1; //T2中也存在，T2的语义分数=1
	                }else{
	                    c = new double[2];
	                    c[0] = YUZHI; //T1的语义分数Ci
	                    c[1] = 1; //T2的语义分数Ci
	                    T.put( index , c );
	                }
	            }
	        }
	        //开始计算，百分比
	        Iterator<String> it = T.keySet().iterator();
	        double s1 = 0 , s2 = 0, Ssum = 0;  //S1、S2
	        while(it.hasNext())
	        {
	        	double[] c = T.get(it.next());
	        	Ssum += c[0]*c[1];
	        	s1 += c[0]*c[0];
	        	s2 += c[1]*c[1];
	        }
	        //百分比
	        return Ssum / Math.sqrt( s1*s2 );
	    }else{
	        throw new Exception("传入参数有问题！");
	    }
	}
	
	/**
	 * 分词
	 * @author: CQ
	 * @Date: 2016年7月2日
	 * @param str
	 * @return
	 */
    public static Vector<String> participle( String str ) {
	    Vector<String> str1 = new Vector<String>() ;//对输入进行分词
	    try{	
	        StringReader reader = new StringReader( str ); 
	        IKSegmenter ik = new IKSegmenter(reader,true);//当为true时，分词器进行最大词长切分 
	        Lexeme lexeme = null ;			
	        while( ( lexeme = ik.next() ) != null )
	        {
			    str1.add( lexeme.getLexemeText() ); 
	        }
	        if( str1.size() == 0 )
	        {
	    	    return null ;
	        }
	        //分词后
//	        System.out.println( "str分词后：" + str1 );
	    }catch(IOException e1){
		    System.out.println();
	    }
	    return str1;
    }

	/**
	 * 获取两个字符串的语义相似度
	 * @author: CQ
	 * @Date: 2016年7月2日
	 * @param str1，str2
	 * @return
	 */
    public static double getSemanticSimilarity (String str1,String str2){
    	//分词
    	Vector<String> vector1 = participle(str1);
    	Vector<String> vector2 = participle(str2);
//		System.out.println(vector1);
//		System.out.println(vector2);
		//获取计算后的语义相似度
		double sim = 0 ;
		try{
		       sim = CalculateSimilarity(vector1, vector2);
		}catch(Exception e){
			System.out.println( e.getMessage() );
		}
//		System.out.println("相似度：" + sim);
		return sim;
    }
    
    /******测试一下getSemanticSimilarity方法*********/
	public static void main(String[] args) {
		String str1 = "请问房价多少钱一平米";
		String str2 = "请问您是打算购买公寓还是别墅呢？";
//		System.out.println("相似度b：" + getSemanticSimilarity(str1,str2));
	}
	

}
