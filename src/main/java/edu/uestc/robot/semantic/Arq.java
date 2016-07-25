package edu.uestc.robot.semantic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

import edu.uestc.robot.nlp.roughlymatch.Ontology;

public class Arq {
	public static List<String> Tag=new ArrayList<String>();
	public static List<String> Tag1=new ArrayList<String>();

    public static String ARQ(String customContent){
    	Tag.add("p");
    	Tag.add("Pmethod");
    	Tag.add("location");
    	Tag1.add("UX");
    	
    	String city;
    	String project;
    	String spot;
    	String school;
    	String where;
    	String queryString="" ;
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
    	Scanner scanner = new Scanner(System.in);
    	String line = customContent;
        Content content = new Content();
        DataSet dataSet = new DataSet();       
        dataSet.getContent(line, content);
    	if(content.hasPrice()&&!"".equals(content.getTag()))
    	{
    		queryString4+="foaf:"+(judege(content.getMatchedTags(),Tag1))+" foaf:hasprice ?y.";
    	}
    	if(content.hasPrice()&&"".equals(content.getTag()))
    	{
    		queryString4+="?x foaf:hasprice ?y.";
    		
    	}
    	if(content.getMatchedTags().contains("p"))
    	{
    		queryString4+="?x foaf:hasprice foaf:p.";
    	}
    	if(content.hasCity())
    	{
    		city=content.getCities().get(0);
    		queryString4+= "?x foaf:isLocatein foaf:"+city+" .";
       	}
    	if(content.iswhere()&&!"".equals(content.getTag()))
    	{
    		where=content.getTag();
    		queryString4+= "foaf:"+where+" foaf:isLocatein ?y .";
       	}
    	if(content.isNearBy()&&!"".equals(content.getMatchedTags().contains("location")))
    	{
    		queryString4+="?x foaf:isNearby foaf:location.";
    		
    	}
 //   	if(content.isNearBy()&&(content.getMatchedTags().contains("location")))
  //  	{
    //		queryString3+="?x foaf:isNearby foaf:location.";
    		
  //  	}
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
    	return Reasoner(queryString+"}",queryString.contains("?x"),queryString.contains("?y"));	
    	
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
    public static String Reasoner(String s,boolean k,boolean o){

    	String l="";
    	String m="";
    	String str="";
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

                 System.out.println("结果：");
                 if(o&&k)
                 {
                 if(Tag.contains(l)&&Tag1.contains(m))
                 {
                	 findxml(m,l);
                	 str=findxml(m,l);
                 }
                 else if(!Tag.contains(l)&&Tag1.contains(m))
                 {
                	 findxml(m,"name");
                	 str=findxml(m,"name")+l;
                 }
                 else
                 {
                     str=m+l;
                 }
                 }
                if(k&&!o)
                {
                     if(Tag1.contains(m))
                     {
                    	 findxml(m,"name");
                    	 str=findxml(m,"name");
                     }
                     else
                     {
                         str=m;
                     }
                }
                if(!k&&o)
                {
                	str=l;
                }
                
        }
        }finally {
            qexec.close();
        }
        System.out.println("?x:");
        System.out.println(m);
        System.out.println("?y:");
        System.out.println(l);
        return str;
    	
    	
    	
    }
    public static List<String> findinstance(String s) throws IOException{

		List<Term> termList = HanLP.segment(s);
		List<String> instance = new ArrayList<String>();
		Ontology ontology = new Ontology("first.owl");
		 for (Term term : termList) {
           if (ontology.isOntology(term.word)) {
        	   instance.add(term.word);
    	
    	  }
		 }
		 return instance;
    }
    
    public static String findxml(String s,String l){
    
     DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        Element theBook=null;
        Element root=null;
        try  {
            factory.setIgnoringElementContentWhitespace(true);
            
            DocumentBuilder db=factory.newDocumentBuilder();
            Document xmldoc=db.parse(new File("house.xml"));
            root=xmldoc.getDocumentElement();
            theBook=(Element) selectSingleNode("/root/LINE[tag=tag='"+s+"']", root);
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