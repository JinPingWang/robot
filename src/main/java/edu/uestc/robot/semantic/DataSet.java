package edu.uestc.robot.semantic;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import edu.uestc.robot.nlp.roughlymatch.Ontology;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by yb on 2016/7/20 0020.
 */
public class DataSet {
    private Set<String> prices;
    private Set<String> nearSpots;
    private Set<String> wheres;
    private Set<String> doubt;
    private Set<String> payment;
    private Set<String> style;
    private Set<String> service;
    private Set<String> immigrant;
    private Set<String> Immigrant;
    private Set<String> Return;
    private Set<String> company;
    private Set<String> activity;
    private Set<String> paper;
    private Set<String> pmethod;
    private Set<String> downpayment;
    private Set<String> right;
    private Set<String> layout;
    private Set<String> time;
    private Set<String> purpose;
    public DataSet(Set<String> purpose,Set<String> time,Set<String> layout,Set<String> right,Set<String> downpayment,Set<String> pmethod,Set<String> paper,Set<String> activity,Set<String> company,Set<String> Return,Set<String> Immigrant,Set<String> prices, Set<String> nearSpots,Set<String> wheres,Set<String> doubt,Set<String> payment,Set<String> style,Set<String> service,Set<String> immigrant) {
        this.prices = prices;
        this.nearSpots = nearSpots;
        this.wheres=wheres;
        this.doubt=doubt;
        this.payment=payment;
        this.style=style;
        this.service=service;
        this.immigrant=immigrant;
        this.Immigrant=Immigrant;
        this.Return=Return;
        this.company=company;
        this.activity=activity;
        this.paper=paper;
        this.pmethod=pmethod;
        this.downpayment=downpayment;
        this.right=right;
        this.layout=layout;
        this.time=time;
        this.purpose=purpose;
    }

    public DataSet() {
        prices = new HashSet<String>();
        nearSpots = new HashSet<String>();
        wheres = new HashSet<String>();
        doubt =new HashSet<String>();
        payment =new HashSet<String>();
        style =new HashSet<String>();
        service=new HashSet<String>();
        immigrant=new HashSet<String>();
        Immigrant=new HashSet<String>();
        Return=new HashSet<String>();
        company=new HashSet<String>();
        activity=new HashSet<String>();
        paper=new HashSet<String>();
        pmethod=new HashSet<String>();
        downpayment=new HashSet<String>();
        right=new HashSet<String>();
        layout=new HashSet<String>();
        time=new HashSet<String>();
        purpose=new HashSet<String>();
        prices.add("价格");
        prices.add("房价");
        prices.add("钱");
        prices.add("价位");
        nearSpots.add("学校");
        nearSpots.add("医院");
        nearSpots.add("超市");
        nearSpots.add("大学");
        wheres.add("哪里");
        wheres.add("位于");
        doubt.add("吗");
        doubt.add("是否");
        doubt.add("么");
        payment.add("支付");
        style.add("房型");
        style.add("类型");
        service.add("服务");
        immigrant.add("移民");
        immigrant.add("支持");
        Immigrant.add("技术");
        Immigrant.add("购房");
        Return.add("回报");
        Return.add("回报率");
        Return.add("收益");
        Return.add("利益");
        company.add("总部");
        company.add("分公司");
        company.add("分部");
        company.add("联系点");
        activity.add("活动");
        activity.add("讲座");
        paper.add("流程");
        pmethod.add("贷款");
        pmethod.add("全款");
        downpayment.add("首付");
        right.add("签证");
        right.add("产权");
        right.add("红本");
        layout.add("户型");
        time.add("时间");
        time.add("日期");
        purpose.add("投资");
        purpose.add("自住");
    }
    public Set<String> getpurpose(){
    	return purpose;
    }
    public Set<String> gettime(){
    	return time;
    }
    public Set<String> getlayout(){
    	return layout;
    }
    public Set<String> getright(){
    	return right;
    }
    public Set<String> getdownpayment(){
    	return downpayment;
    }
    public Set<String> getpmethod(){
    	return pmethod;
    }
    public Set<String> getpaper(){
    	return paper;
    }
    public Set<String> getactivity(){
    	return activity;
    }
    public Set<String> getcompany(){
    	return company;
    }
    public Set<String> getReturn(){
    	return Return;
    }
    public Set<String> getImmigrant(){
    	return Immigrant;
    }
    public Set<String> getimmigrant(){
    	return immigrant;
    }
    public Set<String> getservice(){
    	return service;
    }
    public Set<String> getPrices() {
        return prices;
    }
    public Set<String> getstyle(){
    	return style;
    }
    public Set<String> getwheres() {
        return wheres;
    }
    public Set<String> getpayment() {
        return payment;
    }

    public void setPrices(Set<String> prices) {
        this.prices = prices;
    }

    public Set<String> getNearSpots() {
        return nearSpots;
    }
    public Set<String> getdoubt(){
    	 return doubt; 
    }

    public void setNearSpots(Set<String> nearSpots) {
        this.nearSpots = nearSpots;
    }

    public void hasRecommend(List<Term> terms, Content content) {
        ArrayList<String> res = new ArrayList<String>();
        try {
            InputStream inputStream = DataSet.class.getResourceAsStream("/house.xml");;
            SAXReader saxReader = new SAXReader();
            Document root = saxReader.read(inputStream);
            List<Node> LINES = root.selectNodes("//LINE");
            for (Node node : LINES) {
//                String name = ((Element) node).elementTextTrim("name");
            	
                List<Element> children = ((Element) node).elements();
                for (Element child : children) {
                    String[] names = child.getTextTrim().split(" ");
                    for (String name : names) {
                    	for (Term term : terms) {
                            if (name.equals(term.word)) {
                                String s = child.getName();
                                if ("name".equals(s)) {
                                    content.setTag(((Element) node).elementTextTrim("tag"));
                                }
                                else {
                                    res.add(child.getName());
                                }

                            }
                        }
                    }
                    
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        content.setMatchedTags(res);
    }

    public void getContent(String question, Content content) throws IOException {
        List<Term> terms = HanLP.segment(question);
//        content.setMatchedTags(hasRecommend(terms));
        Ontology ontology = new Ontology("first.owl");
        hasRecommend(terms, content);
        for (Term term: terms) {
            if ("ns".equals(term.nature.name()) || "nsf".equals(term.nature.name())) {
                content.getCities().add(term.word);
            }
            if (this.getPrices().contains(term.word)) {
                content.setPrice(true);
            }
            if (this.getwheres().contains(term.word)) {
                content.setwheres(true);
            }
            
            if (this.getNearSpots().contains(term.word)) {
                content.getSpots().add(term.word);
                }
            if (this.getdoubt().contains(term.word)){
            	content.setdoubt(true);
            }
            if (this.getpayment().contains(term.word)){
            	content.set_ispay(true);
            }
            if (this.getstyle().contains(term.word)){
            	content.setstyle(true);
            }
            if (this.getservice().contains(term.word)){
            	content.setservice(true);
            }
            if (this.getimmigrant().contains(term.word)){
            	content.setimmigrant(true);
            }
            if (this.getImmigrant().contains(term.word)){
            	content.getimmigrant().add(term.word);
            }
            if (this.getReturn().contains(term.word)){
            	content.setReturn(true);
            }
            if (this.getcompany().contains(term.word)){
            	content.getcompany().add(term.word);
            }
            if (this.getactivity().contains(term.word)){
            	content.setactivity(true);
            }
            if(this.getpaper().contains(term.word)){
            	content.setpaper(true);
            }
            if(this.getpmethod().contains(term.word)){
            	content.getpmethod().add(term.word);
            }
            if(this.getdownpayment().contains(term.word)){
            	content.setdownpayment(true);
            }
            if(this.getright().contains(term.word)){
            	content.setright(true);
            }
            if(this.getlayout().contains(term.word)){
            	content.setlayout(true);
            }
            if(this.gettime().contains(term.word)){
            	content.settime(true);
            }
            if(this.getpurpose().contains(term.word)){
            	content.getpurpose().add(term.word);
            }
            
        }
         if(content.isdoubt()){
              	

             for(Term tem: terms){
              		if(ontology.isOntology(tem.word)){
                  		content.getOty().add(tem.word);
                  		
             }  
              		
         }
        	 if(!"".equals(content.getTag())){
           		content.getOty().add(content.getTag());
          }
          if(!"".equals(content.getMatchedTags())){
           		content.getOty().addAll(content.getMatchedTags());
          }
        }
    }
}
