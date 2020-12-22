package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FindHandler extends DefaultHandler {

    private String toFind;

    public FindHandler(String toFind) {
        this.toFind = toFind;
    }

    private String result;

    public String getResult() {
        return result;
    }

    boolean found = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println("start element: " + qName);
        String value = attributes.getValue(toFind);
        if (value != null) {
            result = value;
        }
        if (qName.equals(toFind)) {
            found = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        System.out.println("Characters: " + new String(ch, start, length) + ", start: " + start + ", length: " + length);
        if (found) {
            result = new String(ch, start, length);
            found = false;
        }
    }
}
