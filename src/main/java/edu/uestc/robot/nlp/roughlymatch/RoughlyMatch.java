package edu.uestc.robot.nlp.roughlymatch;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.*;

import org.apache.xerces.util.XMLChar;

/**
 * Created by yb on 2016/6/28 0028.
 */
public class RoughlyMatch {
    public Document loadRepository() throws DocumentException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("out5.xml");
        SAXReader saxReader = new SAXReader();
        return saxReader.read(inputStream);
    }
    public boolean isCity(String name) {
        List<Term> termList = HanLP.segment(name);
        return "ns".equals(termList.get(0).nature.name()) || "nsf".equals(termList.get(0).nature.name()) ;
    }

    //    public readSegResults
    public Matches roughlyMatch(String question, QuestionBean questionBean, ArrayList<AnswerBean> answerBeans) throws DocumentException {
        Matches matches = new Matches();
        matches.userQuestion = HanLP.convertToSimplifiedChinese(question);

        matches.matchedQuestions = new ArrayList<String>();
        matches.matchedAnswers = new ArrayList<String>();
        matches.matchedQuestionsOntology = new ArrayList<String>();
        matches.matchedAnswersOntology = new ArrayList<String>();
        matches.recallRates = new ArrayList<Double>();
        matches.matchedOntoNums = new ArrayList<Integer>();
        matches.matchedOntoCityNums = new ArrayList<Integer>();
        List<Term> termList = HanLP.segment(question);
        StringBuffer sb = new StringBuffer();
        Ontology ontology = new Ontology("second.owl");
        for (Term term : termList) {
//            sb.append(term.word + " ");
            if (ontology.isOntology(term.word)) {
                sb.append(term.word + " ");
            }
        }

        String problem = sb.toString().trim();

        matches.userQuestionOntology = sb.toString().trim();
        Document root = this.loadRepository();
        List<Element> QA =(List<Element>) root.selectNodes("//qa");
        int len = termList.size();
        if ("".equals(sb)) {                  // 问题没有本体，按照普通的字符串匹配
            for (Element qa : QA) {
                Element ele = qa.element("cqSeg");
                if (ele == null) continue;
                String cSeg = ele.getTextTrim();
                String[] cSegs = cSeg.split(" ");
                int cnt = 0;
                for (String cseg : cSegs) {
                    String[] words = cseg.split("/");
                    String word = words[0];
                    String nature = words[1];
                    if ("vn".equals(nature) || "n".equals(nature) || "ns".equals(nature)) {
                        if (problem.indexOf(word) >= 0) {
                            ++cnt;
                        }
                    }
                }
                if (cnt > 0) {
//                    String s = qa.elementTextTrim("s");
                    String s = qa.element("sa").getTextTrim();
                    String q = qa.element("cq").getTextTrim();
                    matches.matchedAnswers.add(HanLP.convertToSimplifiedChinese(s));
                    matches.matchedQuestions.add(HanLP.convertToSimplifiedChinese(q));
                    matches.matchedQuestionsOntology.add(HanLP.convertToSimplifiedChinese(qa.element("cqOntology").getTextTrim()));
                    matches.matchedAnswersOntology.add(HanLP.convertToSimplifiedChinese(qa.element("saOntology").getTextTrim()));
                    matches.recallRates.add(1.0 * cnt / len);
                    matches.matchedOntoCityNums.add(cnt);
                    matches.matchedOntoNums.add(0);
                }
            }
        } else {                              // 问题有本体，按照本体匹配
            for (Element qa : QA) {
                Element ele = qa.element("cqOntology");
                if (ele == null) continue;
                String cqOntology = HanLP.convertToSimplifiedChinese(ele.getTextTrim());
                if ("".equals(cqOntology)) continue;
                String[] cqOntologies = cqOntology.split(" ");
                int matchedOntoNum = 0;
                int matchedOntoCityNum = 0;
                String[] userQuestionOntologies = matches.userQuestionOntology.split(" ");

                HashSet<String> userQuestionOntologySet = new HashSet<String>();
                for (String s : userQuestionOntologies) {
                    userQuestionOntologySet.add(s);
                }
                for (String onto : cqOntologies) {
                    if (userQuestionOntologySet.contains(onto)) {
                        ++matchedOntoNum;
                        if (isCity(onto)) {
                            ++matchedOntoCityNum;
                        }
//                      String[] answerOntology = qa.element("saOntology").getTextTrim().split(" ");
//                      matches.matchedAnswersOntology = new ArrayList<String>(answerOntology);
//                      Collections.addAll(matches.matchedAnswersOntology, answerOntology);
//                      matches.matchedAnswersOntology.add(qa.element("saOntology").getTextTrim());
                    }
                }
                if (matchedOntoNum > 0) {
                    matches.matchedAnswers.add(HanLP.convertToSimplifiedChinese(qa.element("sa").getTextTrim()));
                    matches.matchedQuestions.add(HanLP.convertToSimplifiedChinese(qa.element("cq").getTextTrim()));
                    matches.matchedQuestionsOntology.add(HanLP.convertToSimplifiedChinese(qa.element("cqOntology").getTextTrim()));
                    matches.matchedAnswersOntology.add(HanLP.convertToSimplifiedChinese(qa.element("saOntology").getTextTrim()));
                    matches.matchedOntoNums.add(matchedOntoNum);
                    matches.matchedOntoCityNums.add(matchedOntoCityNum);
                }
            }
        }

        questionBean.setQStr(matches.userQuestion);
        if (!"".equals(matches.userQuestionOntology)) {
            Collections.addAll(questionBean.getQOntology(), matches.userQuestionOntology.split(" "));
        }
        int length = matches.matchedAnswers.size();
        if (length > 0) {
            for (int i = 0; i < length; ++i) {
                AnswerBean answerBean = new AnswerBean("", "", new ArrayList<String>(), new ArrayList<>());
                answerBean.setQStr(matches.matchedQuestions.get(i));
                answerBean.setAStr(matches.matchedAnswers.get(i));
                answerBean.setMatchedOntoNum(matches.matchedOntoNums.get(i));
                answerBean.setMatchedOntoCityNum(matches.matchedOntoCityNums.get(i));
                HashSet<String> set = new HashSet<String>();
                String[] ontos = matches.matchedQuestionsOntology.get(i).split(" ");
                for (String s : ontos) {
                    set.add(s);
                }
                for (String s: set) {
                    answerBean.getQOntology().add(s);
                }
                String[] saOntos = matches.matchedAnswersOntology.get(i).split(" ");
                for (String s : saOntos) {
                    answerBean.getAOntology().add(s);
                }
//                Collections.addAll(answerBean.getQOntology(), );
                answerBeans.add(answerBean);
            }
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(answerBeans);
        Collections.reverse(answerBeans);
        System.out.println("---------------------------------");
        System.out.println(questionBean.toString());
        for (AnswerBean ans: answerBeans) {
            System.out.println(ans.toString());
        }
        System.out.println("---------------------------------");
        return matches;
    }

    public static void main(String[] args) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        RoughlyMatch roughlyMatch = new RoughlyMatch();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            QuestionBean questionBean = new QuestionBean("", new ArrayList<String>());
            ArrayList<AnswerBean> answerBeans = new ArrayList<AnswerBean>();
            Matches matches = null;
            try {
                matches = roughlyMatch.roughlyMatch(s, questionBean, answerBeans);

            } catch (DocumentException e) {
                e.printStackTrace();
            }
            System.out.println(matches.toString());
        }

    }
}
