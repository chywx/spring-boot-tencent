package cn.chendahai.reptile.mock;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author: Dylan
 * @date: 2022/10/20 15:30
 */
public class FoodCategory {

    public static void main(String[] args) throws IOException {
        String url = "http://db.foodmate.net/2760-2014//index.php?m=index&a=index";
        Document doc = Jsoup.parse(new URL(url), 10000);
        String xPath = "//*[@id=\"menu\"]/ul";

        JXDocument jxDocument = new JXDocument(doc.getAllElements());
        List<JXNode> jxNodes = jxDocument.selN(xPath);

        for (JXNode jxNode : jxNodes) {
            Element element = jxNode.asElement();

            for (Element child : element.children()) {
                for (Element c : child.children()) {
                    System.out.println(c.getElementsByTag("span").text());
                }
            }

            for (Node childNode : element.childNodes()) {
                List<Node> nodes = childNode.childNodes();
                for (Node node : nodes) {
//                    System.out.println(node);
//                    TextNode d = (TextNode)node;
//                    System.out.println(d.getElementsByTag("span").text());
//                    System.out.println(d);
                }
            }

            Elements elementsByTag = element.getElementsByTag("li");
//            element.get
            for (Element liRoot : elementsByTag) {
//                System.out.println(liRoot.getElementsByTag("a").text());
//                System.out.println(liRoot.get);
            }

//            Elements allElements = element.getAllElements();
//            for (Element allElement : allElements) {
//                System.out.println(allElement.text());
//            }
        }
    }
}
