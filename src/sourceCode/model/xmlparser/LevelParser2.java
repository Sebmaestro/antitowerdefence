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
public class LevelParser2 {
    public static Position startPos;
    public static Position goalPos;
    public static ArrayList<Position> pathPositions;
    public static ArrayList<Position> grassPositions;
    public static ArrayList<Position> towerZonePositions;
    public static ArrayList<Position> boosterPositions;
    public static ArrayList<Position> quicksandPositions;
    public static ArrayList<Position> switchUpPositions;
    public static ArrayList<Position> switchDownPositions;
    public static Tile[][] allTiles;
    public static ArrayList<Levels> levelsArrayList;



    public static void xmlparser(String input){
        Levels level;
        levelsArrayList = new ArrayList<>();

        //Tile[][] allTiles = new Tile[10][10];

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            int big = 0;
            DocumentBuilder builder = factory.newDocumentBuilder();
            FileInputStream fis = new FileInputStream(input);
            InputSource is = new InputSource(fis);

            Document doc = builder.parse(is);


            NodeList levelList = doc.getElementsByTagName("level");

            NodeList rowList = doc.getElementsByTagName("row");


            int k=0;

            for (int q = 0; q < levelList.getLength(); q++) {
                allTiles = new Tile[10][10];
                pathPositions = new ArrayList<>();
                grassPositions = new ArrayList<>();
                towerZonePositions = new ArrayList<>();
                boosterPositions = new ArrayList<>();
                quicksandPositions = new ArrayList<>();
                switchUpPositions = new ArrayList<>();
                switchDownPositions = new ArrayList<>();

                level = new Levels();
                Node s = levelList.item(q);
                if (s.getNodeType() == Node.ELEMENT_NODE) {
                    Element levelName = (Element) s;
                   level.setLevelName(levelName.getAttribute("name"));
                }

                if(q==1){
                    k=10*q;
                }

                for (int i = 0 ; i < 10; i++) {
                    int tileNr = 0;
                    Node r = rowList.item(i+k);
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
                                    level.addgoalPos(goalPos);
                                } else if (obj instanceof Start) {
                                    startPos = ((Start) obj).getPosition();
                                    level.addstartPos(startPos);

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
                level.addPathPositions(pathPositions);
                level.addGrassPositions(grassPositions);
                level.addTowerZonePositions(towerZonePositions);
                level.addBoosterPositions(boosterPositions);
                level.addQuicksandPositions(quicksandPositions);
                level.addSwitchUpPositions(switchUpPositions);
                level.addSwitchDownPositions(switchDownPositions);
                level.addLevels(allTiles);
                levelsArrayList.add(level);
            }
        }

        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


        //return allTiles;

    }

    public ArrayList<Levels> getLevelsArrayList(){
        return levelsArrayList;
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
