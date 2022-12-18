package hu.vmatthias.foxandhounds.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import hu.vmatthias.foxandhounds.data.Gameboard;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Loading savegame from XML.
 */
public class XmlLoad {
    /**
     * Save file location.
     */
    private static final String FILENAME = "d:\\javaTEMP\\save.xml";

    /**
     * Loading savegame from XML. Incorrect values will be fixed in this section.
     */
    public static void load() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("map");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String value0 = element.getElementsByTagName("value0").item(0).getTextContent();
                    String value1 = element.getElementsByTagName("value1").item(0).getTextContent();
                    String value2 = element.getElementsByTagName("value2").item(0).getTextContent();

                    String value0temp = value0.replace("[", "");
                    String value0temp2 = value0temp.replace("]", "");
                    String value0new = value0temp2.replace(" ", "");
                    String[] strArray0 = value0new.split(",");
                    String[][] array0 = new String[strArray0.length][];
                    int a = 0;
                    for (String row : strArray0) {
                        array0[a++] = row.split(",");
                    }
                    String value1temp = value1.replace("[", "");
                    String value1temp2 = value1temp.replace("]", "");
                    String value1new = value1temp2.replace(" ", "");
                    String[] strArray1 = value1new.split(",");
                    String[][] array1 = new String[strArray1.length][];
                    int b = 0;
                    for (String row : strArray1) {
                        array1[b++] = row.split(",");
                    }
                    String value2temp = value2.replace("[", "");
                    String value2temp2 = value2temp.replace("]", "");
                    String value2new = value2temp2.replace(" ", "");
                    String[] strArray2 = value2new.split(",");
                    String[][] array2 = new String[strArray2.length][];
                    int c = 0;
                    for (String row : strArray2) {
                        array2[c++] = row.split(",");
                    }
                    String value3 = element.getElementsByTagName("value3").item(0).getTextContent();
                    String value3temp = value3.replace("[", "");
                    String value3temp2 = value3temp.replace("]", "");
                    String value3new = value3temp2.replace(" ", "");
                    String[] strArray3 = value3new.split(",");
                    String[][] array3 = new String[strArray3.length][];
                    int d = 0;
                    for (String row : strArray3) {
                        array3[d++] = row.split(",");
                    }
                    String value4 = element.getElementsByTagName("value4").item(0).getTextContent();
                    String value4temp = value4.replace("[", "");
                    String value4temp2 = value4temp.replace("]", "");
                    String value4new = value4temp2.replace(" ", "");
                    String[] strArray4 = value4new.split(",");
                    String[][] array4 = new String[strArray4.length][];
                    int e = 0;
                    for (String row : strArray4) {
                        array4[e++] = row.split(",");
                    }
                    String value5 = element.getElementsByTagName("value5").item(0).getTextContent();
                    String value5temp = value5.replace("[", "");
                    String value5temp2 = value5temp.replace("]", "");
                    String value5new = value5temp2.replace(" ", "");
                    String[] strArray5 = value5new.split(",");
                    String[][] array5 = new String[strArray5.length][];
                    int f = 0;
                    for (String row : strArray5) {
                        array5[f++] = row.split(",");
                    }
                    String value6 = element.getElementsByTagName("value6").item(0).getTextContent();
                    String value6temp = value6.replace("[", "");
                    String value6temp2 = value6temp.replace("]", "");
                    String value6new = value6temp2.replace(" ", "");
                    String[] strArray6 = value6new.split(",");
                    String[][] array6 = new String[strArray6.length][];
                    int g = 0;
                    for (String row : strArray6) {
                        array6[g++] = row.split(",");
                    }
                    String value7 = element.getElementsByTagName("value7").item(0).getTextContent();
                    String value7temp = value7.replace("[", "");
                    String value7temp2 = value7temp.replace("]", "");
                    String value7new = value7temp2.replace(" ", "");
                    String[] strArray7 = value7new.split(",");
                    String[][] array7 = new String[strArray7.length][];
                    int h = 0;
                    for (String row : strArray7) {
                        array7[h++] = row.split(",");
                    }
            for (int x = 0; x < 8; x++) {
                        Gameboard.getShortTable()[0][x] = array0[x][0];
                        Gameboard.getShortTable()[1][x] = array1[x][0];
                        Gameboard.getShortTable()[2][x] = array2[x][0];
                        Gameboard.getShortTable()[3][x] = array3[x][0];
                        Gameboard.getShortTable()[4][x] = array4[x][0];
                        Gameboard.getShortTable()[5][x] = array5[x][0];
                        Gameboard.getShortTable()[6][x] = array6[x][0];
                        Gameboard.getShortTable()[7][x] = array7[x][0];
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Save file (save.xml) not exists");
        }
        System.out.println("Load success.");
    }
}
