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
    private List<String> spots;
    private List<String> matchedTags;
    private String tag;
    public Content(List<String> cities, boolean price, List<String> spots,boolean where) {
        this.cities = cities;
        this.price = price;
        this.spots = spots;
        this.where =where;
    }

    public Content() {
        cities = new ArrayList<String>();
        spots = new ArrayList<String>();
        price = false;
        where = false;
        matchedTags = new ArrayList<String>();
        tag = "";
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

    public List<String> getCities() {
        return cities;
    }

    public List<String> getSpots() {
        return spots;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
    public void setwheres(boolean where)
    {
    	this.where=where;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }
    public void setwhere(boolean where) {
        this.price = where;
    }

    public void setSpots(List<String> spots) {
        this.spots = spots;
    }

    public List<String> getMatchedTags() {
        return matchedTags;
    }

    public void setMatchedTags(List<String> matchedTags) {
        this.matchedTags = matchedTags;
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
