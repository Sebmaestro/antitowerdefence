/*
package sourceCode.model.xmlparser;

import sourceCode.model.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sourceCode.model.reflection.Reflection;
import sourceCode.model.tile.*;
import sourceCode.model.tower.Tower;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LevelParser {
    public static Position startPos;
    public static Position goalPos;
    public static ArrayList<Position> switchPositions = new ArrayList<>();
    public static ArrayList<Position> pathPositions = new ArrayList<>();
    public static ArrayList<Position> grassPositions = new ArrayList<>();
    public static ArrayList<Position> towerZonePositions = new ArrayList<>();
    public static ArrayList<Position> boosterPositions = new ArrayList<>();
    public static ArrayList<Position> quicksandPositions = new ArrayList<>();
    public static ArrayList<Position> switchUpPositions = new ArrayList<>();
    public static ArrayList<Position> switchDownPositions = new ArrayList<>();
    public static Tile[][] allTiles = new Tile[10][10];

    public static Tile[][] xmlparser(String input){

        //Tile[][] allTiles = new Tile[10][10];

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            int big = 0;
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


                            big++;

                            Reflection reflection = new Reflection(tile.getAttribute("type"), position);
                            Object obj = reflection.getTile();

                            if (obj instanceof Path) {
                                pathPositions.add(((Path) obj).getPosition());
                            } else if (obj instanceof Goal) {

                                goalPos = ((Goal) obj).getPosition();
                            } else if (obj instanceof Start) {
                                startPos = ((Start) obj).getPosition();

                            } else if (obj instanceof Towerzone) {
                                    towerZonePositions.add(((Towerzone) obj).getPosition());
                            } else if (obj instanceof Booster) {
                                boosterPositions.add(((Booster) obj).getPosition());

                            } else if (obj instanceof Quicksand) {
                                quicksandPositions.add(((Quicksand) obj).getPosition());

                            } else if (obj instanceof Switchdown) {
                                switchDownPositions.add(((Switchdown) obj).getPosition());

                            } else if (obj instanceof Switchup) {
                                switchUpPositions.add(((Switchup) obj).getPosition());
                            }


                            allTiles[i][tileNr] = (Tile) obj;


                            tileNr++;
                        }
                    }
                }
            }
        }

        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


        return allTiles;

    }

    public ArrayList<Position> getPathPositions(){
        return pathPositions;
    }

    public ArrayList<Position> getSwitchUpPositions(){
        return switchUpPositions;
    }

    public ArrayList<Position> getSwitchDownPositions(){
        return switchDownPositions;
    }

    public ArrayList<Position> getQuicksandPositions(){
        return quicksandPositions;
    }

    public ArrayList<Position> getBoosterPositions(){
        return boosterPositions;
    }

    public ArrayList<Position> getTowerZonePositions(){
        return towerZonePositions;
    }
    public Position getStartPos(){
        return startPos;
    }

    public Position getGoalPos(){
        return goalPos;
    }
}
*/