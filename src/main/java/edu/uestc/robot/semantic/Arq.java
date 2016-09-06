package edu.uestc.robot.semantic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.query.ResultSetFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

public class Arq {
	public static List<String> Tag=new ArrayList<String>();
	public static List<String> Tag1=new ArrayList<String>();
	public static List<String> Tag2=new ArrayList<String>();
	public static String tag="";
	public static boolean flag;
	
    public static void main(String[] args) throws IOException {
    	Tag.add("p");
    	Tag.add("Pmethod");
    	Tag.add("location");
    	Tag.add("Hstyle");
    	Tag.add("Return");
    	Tag.add("layout");
    	Tag.add("T");
    	Tag1.add("UX");
    	Tag1.add("AX");
    	Tag1.add("CX");
    	Tag1.add("SX");
    	Tag1.add("GT");
    	Tag1.add("EX");
    	ARQ("");
    	//System.out.println(Reasoner1("PREFIX foaf: <http://www.semanticweb.org/administrator/ontologies/2016/5/untitled-ontology-21#> SELECT ?x ?y  WHERE {?x foaf:isLocatein foaf:北京 .foaf:分部 foaf:PisLocatein ?y.}",true,true));
    
    	
    		}
    public static String ARQ(String customContent) throws IOException {
    	String city;
    	String model;
    	String property;
    	String question1;
    	String question2;
    	String project;
    	String spot;
    	String school;
    	String where;
    	String queryString="" ;
    	List<String> Result;
        String queryString1 = 
                "PREFIX foaf: <http://www.semanticweb.org/administrator/ontologies/2016/5/untitled-ontology-21#> "
                + "SELECT ?x ?y  WHERE {"  ;
        String queryString2 = 
                "PREFIX foaf: <http://www.semanticweb.org/administrator/ontologies/2016/5/untitled-ontology-21#> "
                + "SELECT ?x   WHERE {"  ;
        String queryString3 = 
                "PREFIX foaf: <http://www.semanticweb.org/administrator/ontologies/2016/5/untitled-ontology-21#> "
                + "SELECT ?y   WHERE {"  ;
        String queryString4="";
    	String line = customContent;
    		flag=false;
    		Content content = new Content();
    		DataSet dataSet = new DataSet();       
    		dataSet.getContent(line, content);
	        if(!"".equals(content.getTag())){
	        	Tag2.add(content.getTag());
	        }
	        if(content.isdoubt()){
	        	if(content.getOty().size()==2){
	        		queryString4+="foaf:"+content.getOty().get(0)+" ?x "+"foaf:"+content.getOty().get(1)+".";
	        		queryString=queryString2+queryString4;
	
	        	}
	    		System.out.println(content.getOty());
	        	System.out.println(queryString);
	        	property=Reasoner2(queryString+"}");
	        	System.out.println(property);
	        	question1=content.getOty().get(0);
	        	question2=content.getOty().get(1);
	        	if(content.getOty().get(0).equals(content.getTag())){
	        		question1=findxml(content.getTag(),"name")+"项目";
	        	}
	        	if(Tag.contains(content.getOty().get(1))){
	        		question2=findxml(content.getTag(),(content.getOty().get(1)));
	        	}
	        	
	        	
	        	if(property.equals("hasprice")){	
	        		System.out.println("是的，"+question1+"的价格是"+question2+"");
	        		return "是的，"+question1+"的价格是"+question2+"";
	        	}
	        	else if(property.equals("isNearby")){
	        		System.out.println("是的，"+question1+"是在"+question2+"的附近");
	        		return "是的，"+question1+"是在"+question2+"的附近";
	        	}
	        	else if(property.equals("isLocatein")){
	        		System.out.println("是的，"+question1+"是在"+question2+"");
	        		return "是的，"+question1+"是在"+question2+"";
	        	}
	        	else if(property.equals("hasPayment_method")){
	        		System.out.println("是的，"+question1+"可以用"+question2+"的支付方式");
	        		return "是的，"+question1+"可以用"+question2+"的支付方式";
	        	}
	        	else if(property.equals("isStyle_of ")){
	        		System.out.println("是的，"+question1+"是"+question2+"的类型");
	        		return "是的，"+question1+"是"+question2+"的类型";
	        	}
	        	else if(property.equals("allow")){
	        		System.out.println("是的，"+question1+"允许"+question2+"");
	        		return "是的，"+question1+"允许"+question2+"";
	        	}
	        	else if(property.equals("PisLocatein")){
	        		System.out.println("是的，"+question1+"是在"+question2+"");
	        		return "是的，"+question1+"是在"+question2+"";
	        	}
	        	else if(property.equals("AisLocatein")){
	        		System.out.println("是的，"+question1+"有"+question2+"");
	        		return "是的，"+question1+"有"+question2+"";
	        	}
	        	else if(property.equals("has")){
	        		System.out.println("是的，"+question1+"有"+question2+",我们在北京，深圳，上海都有联系点");
	        		return "是的，"+question1+"有"+question2+",我们在北京，深圳，上海都有联系点";
	        	}
	        	else if(property.equals("hasright")){
	        		System.out.println("是的，"+question1+"产权是"+question2+"制");
	        		return "是的，"+question1+"产权是"+question2+"制";
	        	}

        }
        
        else{
        	System.out.println(content.getTag());
//        	 Iterator it1 = content.getCities().iterator();
        	
//        	 while(it1.hasNext()){ 
        	if(content.getCities().isEmpty()){
        		content.getCities().add(" ");
        	}
        	for (String cityname: content.getCities()) {
        		
    			
    			if(content.hasPrice()&&!"".equals(content.getTag()))
    			{
    				queryString4+="foaf:"+(content.getTag())+" foaf:hasprice ?y.";
    			}
    			if(content.hasPrice()&&"".equals(content.getTag())&&!content.getMatchedTags().contains("p"))
    			{
    				queryString4+="?x foaf:hasprice ?y.";
    		
    			}
    			if(content.getMatchedTags().contains("p"))
    			{
    				queryString4+="?x foaf:hasprice foaf:p.";
    			}
    	
    			if(!cityname.isEmpty()&&!" ".equals(cityname)&&"".equals(content.getTag())&&!content.isimmigrant()&&!content.isright()&&!content.isdownpayment()&&!content.getCities().contains("北京")&&!content.getCities().contains("上海")&&!content.getCities().contains("深圳"))
    			{
    				city=cityname;
    				System.out.println(city);
    				queryString4+= "?x foaf:isLocatein foaf:"+city+" .";
    			}
    			if(!cityname.isEmpty()&&!content.getTag().isEmpty()&&!" ".equals(cityname))
    			{
    				queryString4+= "foaf:"+content.getTag()+" foaf:isLocatein ?y .";
    			}
    //	if(content.iswhere()&&"".equals(content.getTag()))
    //	{
    //		where=content.getTag();
    //		queryString4+= "?x foaf:isLocatein ?y .";
     //  	}
    			if(content.iswhere()&&!"".equals(content.getTag()))
    			{
    				where=content.getTag();
    				queryString4+= "foaf:"+where+" foaf:isLocatein ?y .";
    			}
    			if(content.getMatchedTags().contains("location"))
    			{
    				queryString4+="?x foaf:isNearby foaf:location.";
    			}
    	
    			if(content.ispayment()&&!"".equals(content.getTag())){
    				queryString4+="foaf:"+content.getTag()+" foaf:hasPayment_method ?y.";
    			}
    			if(content.ispayment()&&"".equals(content.getTag())&&!content.getMatchedTags().contains("Pmethod")){
    				queryString4+="?x foaf:hasPayment_method ?y.";
    			}
    			if(!content.getpmethod().isEmpty()){
    				queryString4+="?x foaf:hasPayment_method foaf:"+content.getpmethod().get(0)+".";
    			}

    			if(content.isstyle()&&!"".equals(content.getTag())){
    				queryString4+="foaf:"+content.getTag()+" foaf:isStyle_of ?y.";
    			}
    			if(content.isstyle()&&"".equals(content.getTag())){
    				queryString4+="?x foaf:isStyle_of ?y.";
    			}
    			if(content.getMatchedTags().contains("Hstyle")){
    				queryString4+="?x foaf:isStyle_of foaf:Hstyle.";
    			}
    	
    			if(content.isservice()&&!content.getTag().isEmpty()){
    				queryString4+="foaf:"+content.getTag()+" foaf:hasservice ?y.";
    			}
    			if(content.ispaper()){
    				System.out.println("看房是没有费用的，需要您来回机票的押金，您如果购房的话，就是免费，后期会把钱退给您");
    				flag=true;
    				return "看房是没有费用的，需要您来回机票的押金，您如果购房的话，就是免费，后期会把钱退给您";
    			}
    	
    	
    			if(content.isimmigrant()&&!cityname.isEmpty()&&!" ".equals(cityname)){
    				queryString4+="foaf:"+cityname+" foaf:allow ?y.";
    			}
    			if(!content.getimmigrant().isEmpty()){
    				queryString4+="?x foaf:allow foaf:"+content.getimmigrant().get(0)+".";
    			}
    	
    			if(content.isReturn()&&!"".equals(content.getTag())){
    				queryString4+="foaf:"+content.getTag()+" foaf:hasReturn ?y.";
    			}
    			if(content.isReturn()&&"".equals(content.getTag())){
    				queryString4+="?x foaf:hasReturn ?y.";
    			}
    			if(content.getMatchedTags().contains("Return")){
    				queryString4+="?x foaf:hasReturn foaf:Return.";
    			}
        
    			if(content.isdownpayment()&&!cityname.isEmpty()&&!" ".equals(cityname)){
    				queryString4+="foaf:"+content.getCities().get(0)+" foaf:hasdownpayment ?y.";
    			}
        
    			if(!content.getcompany().isEmpty()){
    				queryString4+="foaf:"+content.getcompany().get(0)+" foaf:PisLocatein ?y.";
    			}
    	
    			if(content.isactivity()&&content.iswhere()){
    				queryString4+="foaf:活动 foaf:AisLocatein ?y.";
    			}
        
    			if(content.istime()){
    				queryString4+="?x foaf:hasTime ?y.";
    			}
    			if(content.islayout()&&tag.isEmpty()){
    				queryString4+="foaf:"+content.getTag()+" foaf:is_houseStyle_of ?y.";
    			}
    			if(content.islayout()&&content.getMatchedTags().contains("layout")){
    				queryString4+="?x foaf:AisLocatein foaf:layout.";
    			}
        
    			if(!cityname.isEmpty()&&content.isright()&&!" ".equals(cityname)){
    				queryString4+="foaf:"+content.getCities().get(0)+" foaf:hasright ?y.";
    			}
    			if(!content.getpurpose().isEmpty()){
    				queryString4+="?x foaf:fit foaf:"+content.getpurpose().get(0)+".";
    			}
        
    			if(queryString4.contains("?y")&&queryString4.contains("?x"))
    			{
    				queryString=queryString1+queryString4;
    			}
    			else if(!queryString4.contains("?y")&&queryString4.contains("?x"))
    			{
    				queryString=queryString2+queryString4;
    			}
    			else
    			{
    				queryString=queryString3+queryString4;
    			}
    			System.out.println(queryString);
    	if(!flag){

    		Result=Reasoner1(queryString+"}",queryString.contains("?x"),queryString.contains("?y"));
    		
    		if(queryString.contains("hasprice")&&!content.getTag().isEmpty()&&!" ".equals(cityname)){
    			System.out.println(""+findxml(content.getTag(),"name")+"项目"+"的房价是"+Result);
    			return ""+findxml(content.getTag(),"name")+"项目"+"的房价是"+Result;
    		}
    		if(queryString.contains("hasprice")&&content.getMatchedTags().contains("p")){
    			System.out.println("这个价位的项目有"+findxml(Result.get(0),"name"));
    			return "这个价位的项目有"+findxml(Result.get(0),"name");
    		}
    		
    		if(queryString.contains("isLocatein")&&!content.getTag().isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"位于"+Result);
    			return ""+findxml(content.getTag(),"name")+"位于"+Result;
    		}
    		if(queryString.contains("isLocatein")&&!" ".equals(cityname)&&!cityname.isEmpty()&&!queryString.contains("isNearby")&&!queryString.contains("hasPayment_method")&&!queryString.contains("isStyle_of")&&!queryString.contains("allow")&&!queryString.contains("hasReturn")&&!queryString.contains("hasprice")&&!queryString.contains("hasTime")&&!queryString.contains("fit")){
    			System.out.println(""+cityname+"有"+Result.get(0)+"项目");
    			return ""+cityname+"有"+Result.get(0)+"项目";
    		}
    		
    		if(queryString.contains("isNearby")&&!content.getTag().isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"项目"+"附近有"+Result);
    			return ""+findxml(content.getTag(),"name")+"项目"+"附近有"+Result;
    		}
    		if(queryString.contains("isNearby")&&content.getMatchedTags().contains("location")&&!queryString.contains("isLocatein")){
    			System.out.println(""+findxml(Result.get(0),"location")+"附近的项目有"+findxml(Result.get(0),"name")+"");
    			return ""+findxml(Result.get(0),"location")+"附近的项目有"+findxml(Result.get(0),"name")+"";
    		}
    		
    		if(queryString.contains("hasPayment_method")&&!content.getTag().isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"项目"+"可以用"+Result+"的支付方式");
    			return ""+findxml(content.getTag(),"name")+"项目"+"可以用"+Result+"的支付方式";
    		}
    		if(queryString.contains("hasPayment_method")&&content.getMatchedTags().contains("Pmethod")){
    			System.out.println("可以"+findxml(Result.get(0),"Pmethod")+"的有"+findxml(Result.get(0),"name")+"项目");
    			return "可以"+findxml(Result.get(0),"Pmethod")+"的有"+findxml(Result.get(0),"name")+"项目";
    		}
    		
    		if(queryString.contains("isStyle_of")&&!content.getTag().isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"项目"+"是"+Result+"类型的");
    			return ""+findxml(content.getTag(),"name")+"项目"+"是"+Result+"类型的";
    		}
    		if(queryString.contains("isStyle_of")&&content.getMatchedTags().contains("Hstyle")&&(!queryString.contains("hasprice"))){
    			System.out.println(""+findxml(Result.get(0),"Hstyle")+"类型的有"+findxml(Result.get(0),"name")+"项目");
    			return ""+findxml(Result.get(0),"Hstyle")+"类型的有"+findxml(Result.get(0),"name")+"项目";
    		}
    		
    		if(queryString.contains("allow")&&!cityname.isEmpty()&&!" ".equals(cityname)){
    			System.out.println(""+cityname+"允许"+Result+"移民");
    			return ""+cityname+"允许"+Result+"移民";
    		}
    		if(queryString.contains("allow")&&!content.getimmigrant().isEmpty()){
    			System.out.println("支持"+content.getimmigrant().get(0)+"移民的是"+Result+"");
    			return "支持"+content.getimmigrant().get(0)+"移民的是"+Result+"";
    		}
    		
    		if(queryString.contains("hasReturn")&&!content.getTag().isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"项目"+"有"+Result+"的回报");
    			return ""+findxml(content.getTag(),"name")+"项目"+"有"+Result+"的回报";
    		}
    		if(queryString.contains("hasReturn")&&content.getMatchedTags().contains("Return")){
    			System.out.println("拥有"+findxml(Result.get(0),"Return")+"回报率的项目是"+findxml(Result.get(0),"name")+"项目");
    			return "拥有"+findxml(Result.get(0),"Return")+"回报率的项目是"+findxml(Result.get(0),"name")+"项目";
    		}
    		if(queryString.contains("hasReturn")){
    			System.out.println("收益是"+Result+"");
    			return "收益是"+Result+"";
    		}
    		
    		if(queryString.contains("PisLocatein")&&!content.getcompany().isEmpty()){
    			System.out.println(""+content.getcompany().get(0)+"在"+Result+"");
    			return ""+content.getcompany().get(0)+"在"+Result+"";
    		}

    		if(queryString.contains("AisLocatein")&&content.isactivity()){
    			System.out.println("公司讲座在"+Result+"等地都有");
    			return "公司讲座在"+Result+"等地都有";
    		}
    		if(queryString.contains("hasright")&&!cityname.isEmpty()&&!" ".equals(cityname)){
    			System.out.println("在"+cityname+"拥有"+Result+"居住权");
    			return "在"+cityname+"拥有"+Result+"居住权";
    		}
    		if(queryString.contains("is_houseStyle_of")&&tag.isEmpty()){
    			System.out.println(""+findxml(content.getTag(),"name")+"的户型有"+Result+"");
    			return ""+findxml(content.getTag(),"name")+"的户型有"+Result+"";
    		}
    		if(queryString.contains("hasdownpayment")&&!cityname.isEmpty()&&!" ".equals(cityname)){
    			System.out.println(""+cityname+"的首付是"+Result+"");
    			return ""+cityname+"的首付是"+Result+"";
    		}
    		if(queryString.contains("fit")&&!cityname.isEmpty()&&!" ".equals(cityname)){
    			System.out.println(""+cityname+"适合"+content.getpurpose().get(0)+"的是"+Result+"");
    			return ""+cityname+"适合"+content.getpurpose().get(0)+"的是"+Result+"";
    		}
    		if(queryString.contains("hasprice")&&queryString.contains("isLocatein")&&!queryString.contains("isStyle_of")){
    			System.out.println(""+cityname+"的价格是"+Result+"");
    			return ""+cityname+"的价格是"+Result+"";
    		}
    		if(queryString.contains("isNearby")&&queryString.contains("isLocatein")&&!tag.isEmpty()){
    			System.out.println(""+Result+"项目附近有"+findxml(tag,"location")+"");
    			return ""+Result+"项目附近有"+findxml(tag,"location")+"";
    		}
    		if(queryString.contains("hasTime")&&queryString.contains("isLocatein")){
    			System.out.println(""+cityname+"讲座的时间是"+Result+"");
    			return ""+cityname+"讲座的时间是"+Result+"";
    		}
    		if(queryString.contains("hasservice")&&content.getTag().isEmpty()){
    			System.out.println(""+content.getTag()+"项目有"+Result+"的服务");
    			return ""+content.getTag()+"项目有"+Result+"的服务";
    		}
    		if(queryString.contains("hasprice")&&(queryString.contains("isStyle_of")&&!tag.isEmpty())){
    			System.out.println(""+findxml(tag,"name")+""+findxml(tag,"Hstyle")+"项目的价格是"+Result+"");
    			return ""+findxml(tag,"name")+""+findxml(tag,"Hstyle")+"项目的价格是"+Result+"";
    		}

    		//System.out.println(Reasoner1(queryString+"}",queryString.contains("?x"),queryString.contains("?y")));
//    		return Reasoner1(queryString+"}",queryString.contains("?x"),queryString.contains("?y")).get(0);
    	}
    		
    	}
        queryString4="";
        queryString="";
    	}
			return line;
    }
    public static String judege(List<String> s,List<String> k)
    {
    	String m="";
    	Iterator<String> iter = k.iterator();
    	 while(iter.hasNext())  
         {  
             if(s.contains(iter.next()))
            	 m=iter.next();
         }  
    	 return m;
    }
    public static String Reasoner2(String s){
        FileManager.get().addLocatorClassLoader(Arq.class.getClassLoader());
        Model model = FileManager.get().loadModel("first.owl");
        Query query = QueryFactory.create(s);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet results = qexec.execSelect();
        QuerySolution soln = results.nextSolution();
        Resource x = soln.getResource("x");
        try {
            while ( results.hasNext() ) {
                System.out.println(x.getLocalName());
            }}finally {
                qexec.close();
            }
        return x.getLocalName();
    }
    public static List<String> Reasoner1(String s,boolean k,boolean o){

    	String l="";
    	String m="";
    	String result="";
    	List<String> individual=new ArrayList();
        FileManager.get().addLocatorClassLoader(Arq.class.getClassLoader());
        Model model = FileManager.get().loadModel("first.owl");

        Query query = QueryFactory.create(s);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        try {
            ResultSet results = qexec.execSelect();
            while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                //Literal name = soln.getLiteral("x");
                if(k)
                {
                	Resource x = soln.getResource("x");
                	m = x.getLocalName();
                }
                if(o)
                {
                	Resource y = soln.getResource("y");
                	l = y.getLocalName();
                }
          //      System.out.println(m);
       //         System.out.println(l);
                 //System.out.println("结果：");
                 if(o&&k)
                 {
                 if(Tag.contains(l)&&Tag1.contains(m))
                 {
                	 tag=m;
                	result= findxml(m,l);
                 }
                 else if(!Tag.contains(l)&&Tag1.contains(m))
                 {
                	 result=findxml(m,"name")+l;
                 }
                 else
                 {
                	 result = m+l;
                 }
                 }
                if(k&&!o)
                {
                     if(Tag1.contains(m))
                     {
                    	 tag=m;
                    	 result=findxml(m,"name");
                     }
                     else
                     {
                         result=m;
                     }
                }
                if(!k&&o)
                {
                	if(Tag.contains(l)&&!"".equals(Tag2.get(0))){
                		result=findxml(Tag2.get(0),l);
                	}
                	else{	
                		result=l;
                	}
                	
                	
            }
                individual.add(result);
        }
        }finally {
            qexec.close();
        }
        System.out.println(individual);
        return individual;
    }

    
    public static String findxml(String s,String l){
    
     DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        Element theBook=null;
        Element root=null;
        try  {
            factory.setIgnoringElementContentWhitespace(true);
            
            DocumentBuilder db=factory.newDocumentBuilder();
            Document xmldoc=db.parse(Arq.class.getResource("/house.xml").getFile());
            root=xmldoc.getDocumentElement();
            theBook=(Element) selectSingleNode("/root/LINE[tag='"+s+"']", root);
       //     System.out.println(theBook.getElementsByTagName(l).item(0).getTextContent());
            //output(theBook);
            
       	 
         } catch (ParserConfigurationException e) {
             e.printStackTrace();
         } catch (SAXException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    
        return (theBook.getElementsByTagName(l).item(0).getTextContent());
    
    }
    public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    	}

}