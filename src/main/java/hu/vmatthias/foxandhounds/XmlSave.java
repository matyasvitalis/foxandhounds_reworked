package hu.vmatthias.foxandhounds;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Gamesave to XML.
 */
public class XmlSave {
    /**
     * Gamesave to XML.
     */
    public static void xml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Mapdata");
        doc.appendChild(rootElement);

        Element map = doc.createElement("map");
        rootElement.appendChild(map);
        map.setAttribute("id", "0");

        Element value0 = doc.createElement("value0");
       value0.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap0()}));
        map.appendChild(value0);

        Element value1 = doc.createElement("value1");
        value1.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap1()}));
        map.appendChild(value1);

        Element value2 = doc.createElement("value2");
        value2.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap2()}));
        map.appendChild(value2);

        Element value3 = doc.createElement("value3");
        value3.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap3()}));
        map.appendChild(value3);

        Element value4 = doc.createElement("value4");
        value4.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap4()}));
        map.appendChild(value4);

        Element value5 = doc.createElement("value5");
        value5.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap5()}));
        map.appendChild(value5);

        Element value6 = doc.createElement("value6");
        value6.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap6()}));
        map.appendChild(value6);

        Element value7 = doc.createElement("value7");
        value7.setTextContent(Arrays.toString(new String[]{MapDataFromGame.getMap7()}));
        map.appendChild(value7);

        try (FileOutputStream output =
                     new FileOutputStream("d:\\javaTEMP\\save.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, FileOutputStream output)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }

    public static void runCommand() throws ParserConfigurationException, TransformerException {
        xml();
        System.out.println("Save success.");
    }
    }


