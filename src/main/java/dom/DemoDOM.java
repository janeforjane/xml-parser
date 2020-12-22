package dom;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DemoDOM {

    public String find(String fieldName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(DemoDOM.class.getClassLoader().getResourceAsStream("sample.xml"));

        Element documentElement = document.getDocumentElement();

        NodeList userNodes = documentElement.getChildNodes();
        for (int i = 0; i < userNodes.getLength(); i++) {
            Node userItem = userNodes.item(i);
            if (userItem.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) userItem;

                String userAttribute = userElement.getAttribute(fieldName);
                if (userAttribute != null && !userAttribute.isEmpty()) {
                    return userAttribute;
                }
                NodeList userFields = userElement.getChildNodes();
                for (int j = 0; j < userFields.getLength(); j++) {
                    Node fieldItem = userFields.item(j);
                    if (fieldItem.getNodeType() == Node.ELEMENT_NODE) {
                        Element fieldElement = (Element) fieldItem;

                        String fieldAttribute = fieldElement.getAttribute(fieldName);
                        if (fieldAttribute != null && !fieldAttribute.isEmpty()) {
                            return fieldAttribute;
                        }

                        if (fieldElement.getTagName().equals(fieldName)) {
                            return fieldElement.getTextContent();
                        }
                    }
                }
            }
        }

        return null;
    }
}
