package sourceCode.model.Xmlparser;
import sourceCode.model.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sourceCode.model.Tile.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by denni on 2018-12-05.
 */
public class LevelParser {
    public static Position startPos;
    public static Tile[][] allTiles = new Tile[10][10];

    public static Tile[][] xmlparser(String input){

        //Tile[][] allTiles = new Tile[10][10];

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            FileInputStream fis = new FileInputStream(input);
            InputSource is = new InputSource(fis);

            Document doc = builder.parse(is);

            NodeList rowList = doc.getElementsByTagName("row");

            for (int i = 0; i < rowList.getLength(); i++) {
                int tileNr = 0;
                Node r = rowList.item(i);
                if (r.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) r;
                    NodeList tiles = row.getChildNodes();
                    for (int j = 0; j < tiles.getLength(); j++) {

                        Node t = tiles.item(j);
                        if (t.getNodeType() == Node.ELEMENT_NODE) {

                            Element tile = (Element) t;
                            Position position = new Position(tileNr, (i));

                            if (tile.getAttribute("type").equals("model.Tile.Grass")) {
                                Grass grass = new Grass(position);
                                allTiles[i][tileNr] = grass;
                            } else if (tile.getAttribute("type").equals("model.Tile.Path")) {
                                Path path = new Path(position);
                                allTiles[i][tileNr] = path;
                            } else if (tile.getAttribute("type").equals("model.Tile.Start")) {
                                Start start = new Start(position);
                                startPos = start.getPosition();
                                allTiles[i][tileNr] = start;
                            } else if (tile.getAttribute("type").equals("model.Tile.Goal")) {
                                Goal goal = new Goal(position);
                                allTiles[i][tileNr] = goal;
                            } else if (tile.getAttribute("type").equals("model.Tile.Towerzone")) {
                                Towerzone towerzone = new Towerzone(position);
                                allTiles[i][tileNr] = towerzone;
                            }

                            System.out.println("Rad " + (i) + " Tile " + tileNr + " är type " +
                                    tile.getAttribute("type"));

                            System.out.println(allTiles[i][tileNr].toString());
                            tileNr++;
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return allTiles;

    }
}
