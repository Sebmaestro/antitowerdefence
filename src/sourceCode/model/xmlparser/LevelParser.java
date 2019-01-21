package sourceCode.model.xmlparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sourceCode.model.Position;
import sourceCode.model.reflection.Reflection;
import sourceCode.model.tile.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by denni and simon and Sebastian on 2018-12-05.
 * 2019-01-21
 * Class representing the level parser that parses an XML file
 * representing the levels and stores the information.
 */
public class LevelParser {
    private static ArrayList<Levels> levelsArrayList;

    /**
     * xmlparser: parses an xml file and stores the data
     * @param input path to the xml-file
     */
    public static void xmlparser(String input){
        Levels level;
        levelsArrayList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            FileInputStream fis = new FileInputStream(input);
            InputSource is = new InputSource(fis);
            Document doc = builder.parse(is);
            NodeList levelList = doc.getElementsByTagName("level");
            NodeList rowList = doc.getElementsByTagName("row");

            int k=0;

            for (int q = 0; q < levelList.getLength(); q++) {
                Tile[][] allTiles = new Tile[10][10];
                ArrayList<Position> pathPositions = new ArrayList<>();
                ArrayList<Position> grassPositions = new ArrayList<>();
                ArrayList<Position> towerZonePositions = new ArrayList<>();
                ArrayList<Position> boosterPositions = new ArrayList<>();
                ArrayList<Position> quicksandPositions = new ArrayList<>();
                ArrayList<Position> switchUpPositions = new ArrayList<>();
                ArrayList<Position> switchDownPositions = new ArrayList<>();
                ArrayList<Position> allSwitchPositions = new ArrayList<>();

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

                                Reflection reflection = new Reflection(tile.getAttribute("type"), position);
                                Object obj = reflection.getTile();

                                if (obj instanceof Path) {
                                    pathPositions.add(((Path) obj).getPosition());
                                } else if (obj instanceof Goal) {
                                    Position goalPos = ((Goal) obj).getPosition();
                                    level.addgoalPos(goalPos);
                                } else if (obj instanceof Start) {
                                    Position startPos = ((Start) obj).getPosition();
                                    level.addstartPos(startPos);
                                } else if (obj instanceof Towerzone) {
                                    towerZonePositions.add(((Towerzone) obj).getPosition());
                                } else if (obj instanceof Booster) {
                                    boosterPositions.add(((Booster) obj).getPosition());
                                } else if (obj instanceof Quicksand) {
                                    quicksandPositions.add(((Quicksand) obj).getPosition());
                                } else if (obj instanceof Switchdown) {
                                    switchDownPositions.add(((Switchdown) obj).getPosition());
                                    allSwitchPositions.add(((Switchdown) obj).getPosition());
                                } else if (obj instanceof Switchup) {
                                    switchUpPositions.add(((Switchup) obj).getPosition());
                                    allSwitchPositions.add(((Switchup) obj).getPosition());
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
                level.addAllSwitchPositions(allSwitchPositions);
                level.addLevels(allTiles);
                levelsArrayList.add(level);
            }
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * getLevelsArrayList: getter for the ArrayList of levels
     * @return ArrayList of levels
     */
    public ArrayList<Levels> getLevelsArrayList(){
        return levelsArrayList;
    }
}
