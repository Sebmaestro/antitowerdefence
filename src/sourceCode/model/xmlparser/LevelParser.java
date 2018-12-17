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

/**
 * Created by denni on 2018-12-05.
 */
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

                            Reflection xd = new Reflection(tile.getAttribute("type"), position);
                            Object gg = xd.getTile();

                            if (gg instanceof Path) {
                                    pathPositions.add(((Path) gg).getPosition());
                            } else if (gg instanceof Goal) {

                                goalPos = ((Goal) gg).getPosition();
                            } else if (gg instanceof Start){
                                startPos = ((Start) gg).getPosition();

                            } else if (gg instanceof Towerzone){
                                towerZonePositions.add(((Towerzone) gg).getPosition());

                            } else if (gg instanceof Booster){
                                boosterPositions.add(((Booster) gg).getPosition());

                            } else if (gg instanceof Quicksand){
                                quicksandPositions.add(((Quicksand) gg).getPosition());

                            } else if (gg instanceof Switchdown){
                                switchDownPositions.add(((Switchdown) gg).getPosition());

                            }else if (gg instanceof Switchup){
                                switchUpPositions.add(((Switchup) gg).getPosition());
                            }


                            allTiles[i][tileNr] = (Tile) gg;

                            /*
                            if (tile.getAttribute("type").equals("model.Tile.Grass")) {
                                Grass grass = new Grass(position);
                                grassPositions.add(position);
                                allTiles[i][tileNr] = grass;
                            } else if (tile.getAttribute("type").equals("model.Tile.Path")) {
                                Path path = new Path(position);
                                pathPositions.add(position);
                                allTiles[i][tileNr] = path;
                            } else if (tile.getAttribute("type").equals("model.Tile.Start")) {
                                Start start = new Start(position);
                                startPos = start.getPosition();
                                allTiles[i][tileNr] = start;
                            } else if (tile.getAttribute("type").equals("model.Tile.Goal")) {
                                Goal goal = new Goal(position);
                                goalPos = goal.getPosition();
                                allTiles[i][tileNr] = goal;
                            } else if (tile.getAttribute("type").equals("model.Tile.Towerzone")) {
                                Towerzone towerzone = new Towerzone(position);
                                towerZonePositions.add(position);
                                allTiles[i][tileNr] = towerzone;
                            }
                            else if (tile.getAttribute("type").equals("model.Tile.Pathswitch")) {
                                PathSwitch switcha = new PathSwitch(position);
                                switchPositions.add(position);
                                allTiles[i][tileNr] = switcha;
                            }
                            */
                            //System.out.println("Rad " + (i) + " Tile " + tileNr + " är type " +
                                   // tile.getAttribute("type"));

                            //System.out.println(allTiles[i][tileNr].toString());
                            tileNr++;
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
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
