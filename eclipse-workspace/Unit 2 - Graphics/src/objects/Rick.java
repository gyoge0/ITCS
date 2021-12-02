package objects;

import java.io.File;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class Rick {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        Element rootElement;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/objects/rick.svg"));
            rootElement = document.getDocumentElement();

            NodeList nodeList = rootElement.getElementsByTagName("path");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node n = nodeList.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) n;


                    // get the attribute value
                    String attr = elem.getAttribute("d");

                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Iterable<Node> iterable(final NodeList n) {

        return new Iterable<Node>() {

            @Override
            public Iterator<Node> iterator() {

                return new Iterator<Node>() {

                    int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < n.getLength();
                    }

                    @Override
                    public Node next() {
                        if (hasNext()) {
                            return n.item(index++);
                        } else {
                            throw new NoSuchElementException();
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
