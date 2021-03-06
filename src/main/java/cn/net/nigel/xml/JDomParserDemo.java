package cn.net.nigel.xml;

import java.io.File;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDomParserDemo {

    public static void main(String[] args) {
        try {
            String path = JDomParserDemo.class.getResource("").getPath() + "test.xml";
            File inputFile = new File(path.replace("target/classes", "src/main/java"));
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            List<Element> studentList = classElement.getChildren();
            System.out.println("----------------------------");

            for (Element student : studentList) {
                System.out.println("\nCurrent Element :" + student.getName());
                Attribute attribute = student.getAttribute("rollno");
                System.out.println("Student roll no : " + attribute.getValue());
                System.out.println("First Name : " + student.getChild("firstname").getText());
                System.out.println("Last Name : " + student.getChild("lastname").getText());
                System.out.println("Nick Name : " + student.getChild("nickname").getText());
                System.out.println("Marks : " + student.getChild("marks").getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
