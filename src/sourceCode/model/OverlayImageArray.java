package sourceCode.model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sourceCode.model.tile.Path;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by denni on 2018-12-13.
 */
public class OverlayImageArray {
    private BufferedImage allPics;
    Tile[][] allTiles;
    private BufferedImage[][] theWholeShit;
    private ArrayList<Position> pathPositions, quicksandPosition, boosterPosition,
            regTroopPosition, telepTroopPosition, towerPositions, switchDownPosition,
            switchUpPosition, teleporterTile1Positons, teleporterTile2Positions;
    private ArrayList<Position> switchUpPositionsCopy = new ArrayList<>();
    private ArrayList<Position> quicksandPositionsCopy = new ArrayList<>();
    private ArrayList<Position> booserPositionsCopy = new ArrayList<>();
    private ArrayList<Position> pathPositionsCopy = new ArrayList<>();
    private ArrayList<Position> switchDownPositionsCopy = new ArrayList<>();

    private BufferedImage path, regular, invisible, start, goal, tower, quicksand, booster,
                            switchDown, switchUp, teleporter, teleporterTile1, teleporterTile2;
    private int worldSize;
    private Position startPos, goalPos, startPosCopy, goalPosCopy;
    private ArrayList<Troop> regTroopList;

    public OverlayImageArray(int worldSize) {
        this.worldSize = worldSize;
        readImages();
        theWholeShit = new BufferedImage[10][10];
        regTroopPosition = new ArrayList<>();
        teleporterTile1Positons = new ArrayList<>();
        teleporterTile2Positions = new ArrayList<>();

        for(int i=0; i<worldSize; i++){
            for(int j=0; j<worldSize;j++){
                    theWholeShit[i][j] = invisible;
            }
        }

    }

    private void readImages(){

        try {
            path = ImageIO.read(new File("src/Resources/path.png"));
            regular = ImageIO.read(new File("src/Resources/regular.png"));
            teleporter = ImageIO.read(new File("src/Resources/teleporter.png"));
            invisible = ImageIO.read(new File("src/Resources/invisible.png"));
            start = ImageIO.read(new File("src/Resources/start.png"));
            goal = ImageIO.read(new File("src/Resources/goal.png"));
            tower = ImageIO.read(new File("src/Resources/tower.png"));
            quicksand = ImageIO.read(new File("src/Resources/quicksand.png"));
            booster = ImageIO.read(new File("src/Resources/booster.png"));
            switchDown = ImageIO.read(new File("src/Resources/switch-down.png"));
            switchUp = ImageIO.read(new File("src/Resources/switch-up.png"));
            teleporterTile1 = ImageIO.read(new File("src/Resources/teleporter1.png"));
            teleporterTile2 = ImageIO.read(new File("src/Resources/teleporter2.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void addRegularTroopList(ArrayList<Troop> regTroopList){
        this.regTroopList = regTroopList;
    }

    public void addTeleportTroopList(ArrayList<Position> troopPositions){

    }

    public void addTowerZones(ArrayList<Position> towerListPositions){
        towerPositions = towerListPositions;
    }

    public void clearThePath(){
        for(Position p :pathPositions){
            theWholeShit[p.getY()][p.getX()] = path;
        }
        for(Position p : quicksandPosition){
            theWholeShit[p.getY()][p.getX()] = quicksand;
        }

        for(Position p :boosterPosition){
            theWholeShit[p.getY()][p.getX()] = booster;
        }

        for(Position p :switchDownPosition){
            theWholeShit[p.getY()][p.getX()] = switchDown;
        }

        for(Position p :switchUpPosition){
            theWholeShit[p.getY()][p.getX()] = switchUp;
        }

        if(teleporterTile1Positons.size() > 0) {
            for (Position p : teleporterTile1Positons) {
                theWholeShit[p.getY()][p.getX()] = teleporterTile1;
            }
        }





        theWholeShit[goalPos.getY()][goalPos.getX()] = goal;
        theWholeShit[startPos.getY()][startPos.getX()] = start;

    }

    public void addPaths(ArrayList<Position> pathPositions, ArrayList<Position> quicksandPositions,
                         ArrayList<Position> boosterPositions, ArrayList<Position> switchDown,
                         ArrayList<Position> switchUp, Position startPos, Position goalPos){
        this.pathPositions = pathPositions;
        this.quicksandPosition = quicksandPositions;
        this.boosterPosition = boosterPositions;
        this.switchDownPosition = switchDown;
        this.switchUpPosition = switchUp;
        this.startPos = startPos;
        this.goalPos = goalPos;
    }

    public void changeSwitchUpToDown(Position p){
        int i = 0;
        boolean found = false;
        for(Position pos: switchUpPosition){
            if(pos == p){
                found = true;
                System.out.println(i);
                break;
            }
            i++;
        }
        if(found){
            switchUpPosition.remove(i);
            switchDownPosition.add(p);
        }
    }


    public void copyAllWalkables(){
        pathPositionsCopy = pathPositions;
        booserPositionsCopy = boosterPosition;
        quicksandPositionsCopy = quicksandPosition;
        switchDownPositionsCopy = switchDownPosition;
        switchUpPositionsCopy = switchUpPosition;
        startPosCopy = startPos;
        goalPosCopy = goalPos;
    }

    public void resetToOriginalWalkables(){
        pathPositions = pathPositionsCopy;
        boosterPosition = booserPositionsCopy;
        quicksandPosition = quicksandPositionsCopy;
        switchDownPosition = switchDownPositionsCopy;
        switchUpPosition = switchUpPositionsCopy;
        startPos = startPosCopy;
        goalPos = goalPosCopy;
    }

    public void addTeleportPic(Position p){
        int i = 0;
        int j = 0;
        int k = 0;
        boolean found = false;
        boolean boosterfound = false;
        boolean quicksandfound = false;
        for(Position pos: pathPositions){
            if(pos.getX() == p.getX() && pos.getY() == p.getY()){
                found = true;
                break;
            }
            i++;
        }

        for(Position pos: boosterPosition){
            if(pos.getX() == p.getX() && pos.getY() == p.getY()){
                boosterfound = true;
                break;
            }
            j++;
        }

        for(Position pos: quicksandPosition){
            if(pos.getX() == p.getX() && pos.getY() == p.getY()){
                quicksandfound = true;
                break;
            }
            k++;
        }

        if(found){
            pathPositions.remove(i);
            teleporterTile1Positons.add(p);
        }

        if(boosterfound){
            boosterPosition.remove(j);
            teleporterTile1Positons.add(p);
        }

        if(quicksandfound){
            quicksandPosition.remove(k);
            teleporterTile1Positons.add(p);
        }
    }

    public void changeSwitchDownToUp(Position p){
        int j = 0;
        boolean found = false;
        for(Position pos: switchDownPosition){
            if(pos == p){
                found = true;
                break;
            }
            j++;
        }
        if(found){
            switchDownPosition.remove(j);
            switchUpPosition.add(p);
        }
    }

    public void updateImage(){
        clearThePath();

        try {
            for (Troop reg : regTroopList) {

                if(reg.getGraphic().equals("Regular")) {
                    theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = regular;
                }
                else if(reg.getGraphic().equals("Teleporter")){
                    theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = teleporter;
                }
            }
        }catch (NullPointerException e){}
    }




    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
