package edu.uestc.robot.nlp.roughlymatch;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yb on 2016/6/28 0028.
 */
public class RoughlyMatch {
    public Document loadRepository() throws DocumentException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("out5.xml");
        SAXReader saxReader = new SAXReader();
        return saxReader.read(inputStream);
    }
    
//    public readSegResults
    public Matches roughlyMatch(String question, QuestionBean questionBean, ArrayList<AnswerBean> answerBeans) throws DocumentException {
        Matches matches = new Matches();
        matches.userQuestion = question;

        matches.matchedQuestions = new ArrayList<String>();
        matches.matchedAnswers = new ArrayList<String>();
        matches.matchedQuestionsOntology = new ArrayList<String>();
        matches.recallRates = new ArrayList<Double>();
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
                    matches.matchedAnswers.add(s);
                    matches.matchedQuestions.add(q);
                    matches.matchedQuestionsOntology.add(qa.element("cqOntology").getTextTrim());
                    matches.recallRates.add(1.0 * cnt / len);
                }
            }
        } else {                              // 问题有本体，按照本体匹配
            for (Element qa : QA) {
                Element ele = qa.element("cqOntology");
                if (ele == null) continue;
                String cqOntology = ele.getTextTrim();
                if ("".equals(cqOntology)) continue;
                String[] cqOntologies = cqOntology.split(" ");
                for (String onto : cqOntologies) {
                    if (matches.userQuestionOntology.indexOf(onto) >= 0) {
                        matches.matchedAnswers.add(qa.element("sa").getTextTrim());
//                        String[] answerOntology = qa.element("saOntology").getTextTrim().split(" ");
//                        matches.matchedAnswersOntology = new ArrayList<String>(answerOntology);
//                        Collections.addAll(matches.matchedAnswersOntology, answerOntology);
//                        matches.matchedAnswersOntology.add(qa.element("saOntology").getTextTrim());
                        matches.matchedQuestions.add(qa.element("cq").getTextTrim());
                        matches.matchedQuestionsOntology.add(qa.element("cqOntology").getTextTrim());
                        break;
                    }
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
                AnswerBean answerBean = new AnswerBean("", "", new ArrayList<String>());
                answerBean.setQStr(matches.matchedQuestions.get(i));
                answerBean.setAStr(matches.matchedAnswers.get(i));
                Collections.addAll(answerBean.getQOntology(), matches.matchedQuestionsOntology.get(i).split(" "));
                answerBeans.add(answerBean);
            }
        }

        return matches;
    }

    public static void main(String[] args) {
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
//            System.out.println(matches.toString());
        }

    }
}
