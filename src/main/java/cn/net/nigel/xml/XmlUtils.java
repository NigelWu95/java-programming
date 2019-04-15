package cn.net.nigel.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtils {

    public static void main(String[] args) throws DocumentException {

        String path = DomParserDemo.class.getResource("").getPath() + "test.xml";
        File inputFile = new File(path.replace("target/classes", "src/main/java"));
        inputFile = new File("/Users/wubingheng/Downloads/download.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputFile);
//        System.out.println(document.asXML());
//        long beginTime = System.currentTimeMillis();
        Map<String, Object> map = XmlUtils.Dom2Map(document);
//        System.out.println(map.toString());
//        System.out.println("Use time:"+(System.currentTimeMillis()-beginTime));

    }

    public static Map<String, Object> Dom2Map(Document doc) {
        Map<String, Object> map = new HashMap<>();
        if(doc == null) return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            List list = e.elements();
            if (list.size() > 0) {
                map.put(e.getName(), Dom2Map(e));
            } else {
                map.put(e.getName(), e.getText());
            }
        }
        return map;
    }

    public static Map<String, Object> Dom2Map(Element e){
        Map<String, Object> map = new HashMap<>();
        List list = e.elements();
        if (list.size() > 0) {
            for (Object aList : list) {
                Element iter = (Element) aList;
                List mapList = new ArrayList();

                if (iter.elements().size() > 0) {
                    Map m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else
                        map.put(iter.getName(), m);
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        if ("Key".equals(iter.getName())) System.out.println(iter.getText());
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }
}
