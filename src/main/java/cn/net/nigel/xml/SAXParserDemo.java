package cn.net.nigel.xml;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {

    public static void main(String[] args) {

        try {
            String path = DomParserDemo.class.getResource("").getPath() + "test.xml";
            File inputFile = new File(path.replace("target/classes", "src/main/java"));
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
