package edu.uestc.robot.semantic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yb on 2016/7/20 0020.
 */
public class Content {
    private List<String> cities;
    private boolean price;
    private boolean where;
    private boolean doubts;
    private boolean ispayment;
    private boolean isstyle;
    private boolean isservice;
    private boolean isimmigrant;
    private boolean isReturn;
    private boolean iscompany;
    private boolean isactivity;
    private boolean ispaper;
    private boolean isdownpayment;
    private boolean isright;
    private boolean islayout;
    private boolean istime;
    private List<String> Oty;
    private List<String> spots;
    private List<String> matchedTags;
    private List<String> service;
    private List<String> immigrant;
    private List<String> company;
    private List<String> pmethod;
    private List<String> purpose;
    
    private String tag;
    public Content(List<String> purpose,List<String> pmethod,List<String> company,List<String> immigrant,List<String> cities,boolean istime,boolean islayout,boolean isright,boolean isdownpayment,boolean ispaper,boolean isactivity,boolean iscompany,boolean isReturn, boolean price, List<String> spots,boolean where,boolean doubts,List<String> Oty,List<String> payment,List<String> style,boolean isstyle,boolean isservice,boolean isimmigrant) {
        this.cities = cities;
        this.price = price;
        this.spots = spots;
        this.where =where;
        this.isstyle=isstyle;
        this.Oty=Oty;
        this.doubts=doubts;
        this.iscompany=iscompany;
        this.isimmigrant=isimmigrant;
        this.immigrant=immigrant;
        this.isReturn=isReturn;
        this.company=company;
        this.isactivity=isactivity;
        this.ispaper=ispaper;
        this.pmethod=pmethod;
        this.isdownpayment=isdownpayment;
        this.isright=isright;
        this.islayout=islayout;
        this.istime=istime;
        this.purpose=purpose;
    }

    public Content() {
        cities = new ArrayList<String>();
        spots = new ArrayList<String>();
        Oty =new ArrayList<String>();
        service=new ArrayList<String>();
        immigrant=new ArrayList<String>();
        company=new ArrayList<String>();
        pmethod=new ArrayList<String>();
        purpose=new ArrayList<String>();
        istime=false;
        islayout=false;
        isright=false;
        isdownpayment=false;
        isactivity=false;
        iscompany=false;
        isReturn=false;
        ispayment=false;
        price = false;
        where = false;
        doubts= false;
        isstyle=false;
        isservice=false;
        isimmigrant=false;
        ispaper=false;
        matchedTags = new ArrayList<String>();
        tag = "";
    }
    public boolean istime(){
    	return istime;
    }
    public boolean islayout(){
    	return islayout;
    }
    public boolean isright(){
    	return isright;
    }
    public boolean isdownpayment(){
    	return isdownpayment;
    }
    public boolean ispaper(){
    	return ispaper;
    }
    public boolean isactivity(){
    	return isactivity;
    }
    public boolean iscompany(){
    	return iscompany;
    }
    public boolean isReturn(){
    	return isReturn;
    }
    public boolean isimmigrant(){
    	return isimmigrant;
    }
    public boolean isservice(){
    	return isservice;
    }

    public boolean hasPrice() {
        return price;
    }
    public boolean iswhere() {
        return where;
    }

    public boolean hasCity() {
        return !cities.isEmpty();
    }

    public boolean isNearBy() {
        return !spots.isEmpty();
    }
    public boolean isdoubt(){
    	return doubts;
    }
    public boolean ispayment(){
    	return ispayment;
    }
    public boolean isstyle(){
    	return isstyle;
    }

    public List<String> getpurpose(){
    	return purpose;
    }
    public List<String> getCities() {
        return cities;
    }
    public List<String> getimmigrant(){
    	return immigrant;
    }

    public List<String> getSpots() {
        return spots;
    }
    public List<String> getOty(){
    	return Oty;
    }
    public List<String> getcompany(){
    	return company;
    }
    public List<String> getpmethod(){
    	return pmethod;
    }
    
    public void settime(boolean istime){
    	this.istime=istime;
    }
    public void setlayout(boolean islayout){
    	this.islayout=islayout;
    }
    public void setright(boolean isright){
    	this.isright=isright;
    }
    public void setdownpayment(boolean isdownpayment){
    	this.isdownpayment=isdownpayment;
    }
    public void setpaper(boolean ispaper){
    	this.ispaper=ispaper;
    }
    public void setactivity(boolean isactivity){
    	this.isactivity=isactivity;
    }
    public void setReturn(boolean isReturn){
    	this.isReturn= isReturn;
    }
    public void setimmigrant(boolean isimmigrant){
    	this.isimmigrant=isimmigrant;
    }
    public void set_ispay(boolean ispayment){
    	this.ispayment= ispayment;
    }
    public void setservice(boolean isservice){
    	this.isservice=isservice;
    }
    public void setCities(List<String> cities) {
        this.cities.addAll(cities);
    }
    public void setwheres(boolean where)
    {
    	this.where=where;
    }
    public void setstyle(boolean isstyle){
    	this.isstyle=isstyle;
    }
    public void setPrice(boolean price) {
        this.price = price;
    }
    public void setwhere(boolean where) {
        this.price = where;
    }

    public void setdoubt(boolean doubts){
    	this.doubts= doubts;
    }

    public List<String> getMatchedTags() {
        return matchedTags;
    }

    public void setMatchedTags(List<String> matchedTags) {
        this.matchedTags.addAll(matchedTags);
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isPrice() {
        return price;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "是否询问价格：" + hasPrice() + "\n";
        ret += "是否包含城市：" + hasCity() + "\n";

//        System.out.println("是否询问价格：" + hasPrice());
//        System.out.println("是否包含城市：" + hasCity());

        if (hasCity()) {
//            System.out.println("包含的城市为：" + cities.toString());
            ret += "包含的城市为：" + cities.toString() + "\n";
        }
        ret += "是否要求某个地点附近：" + isNearBy() + "\n";
//        System.out.println("是否要求某个地点附近：" + isNearBy());
        if (isNearBy()) {
//            System.out.println("要求在 " + spots.toString() + " 的附近。");
            ret += "要求在 " + spots.toString() + " 的附近。" + "\n";
        }
        ret += "tag标记为：" + matchedTags.toString() + "\n";
        return ret;
    }
}
