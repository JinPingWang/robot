package edu.uestc.robot.semantic;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by yb on 2016/7/20 0020.
 */
public class DataSet {
    private Set<String> prices;
    private Set<String> nearSpots;
    private Set<String> wheres;

    public DataSet(Set<String> prices, Set<String> nearSpots,Set<String> wheres) {
        this.prices = prices;
        this.nearSpots = nearSpots;
        this.wheres=wheres;
    }

    public DataSet() {
        prices = new HashSet<String>();
        nearSpots = new HashSet<String>();
        wheres = new HashSet<String>();
        prices.add("价格");
        prices.add("房价");
        nearSpots.add("学校");
        nearSpots.add("医院");
        wheres.add("哪里");
        wheres.add("位于");
    }

    public Set<String> getPrices() {
        return prices;
    }
    public Set<String> getwheres() {
        return wheres;
    }

    public void setPrices(Set<String> prices) {
        this.prices = prices;
    }

    public Set<String> getNearSpots() {
        return nearSpots;
    }

    public void setNearSpots(Set<String> nearSpots) {
        this.nearSpots = nearSpots;
    }

    public void hasRecommend(List<Term> terms, Content content) {
        ArrayList<String> res = new ArrayList<String>();
        try {
//            InputStream inputStream = new FileInputStream("/house.xml");
            InputStream inputStream = DataSet.class.getResourceAsStream("/house.xml");
            SAXReader saxReader = new SAXReader();
            Document root = saxReader.read(inputStream);
            List<Node> LINES = root.selectNodes("//LINE");
            for (Node node : LINES) {
//                String name = ((Element) node).elementTextTrim("name");
                List<Element> children = ((Element) node).elements();
                for (Element child : children) {
                    String name = child.getTextTrim();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        content.setMatchedTags(res);
    }

    public void getContent(String question, Content content) {
        List<Term> terms = HanLP.segment(question);
//        content.setMatchedTags(hasRecommend(terms));
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
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null) {
//            List<Term> terms = HanLP.segment(line);
            Content content = new Content();
            DataSet dataSet = new DataSet();
            dataSet.getContent(line, content);

            System.out.println(content.toString());

        }
    }
}
