package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class DemoSAX {

    public String find(String fieldName) throws Exception {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        FindHandler handler = new FindHandler(fieldName);
        saxParser.parse(DemoSAX.class.getClassLoader().getResourceAsStream("sample.xml"), handler);

        System.out.println(handler.getResult());

        return handler.getResult();
    }

}
