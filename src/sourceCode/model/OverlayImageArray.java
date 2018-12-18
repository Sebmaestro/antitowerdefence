package sourceCode.model;

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

/**
 * Created by denni on 2018-12-13.
 */
public class OverlayImageArray {
    private BufferedImage allPics;
    Tile[][] allTiles;
    private BufferedImage[][] theWholeShit;
    private ArrayList<Position> pathPositions, quicksandPosition, boosterPosition,
            regTroopPosition, telepTroopPosition, towerPositions, switchDownPosition,
            switchUpPosition;
    private BufferedImage path, regular, invisible, start, goal, tower, quicksand, booster,
                            switchDown, switchUp, teleporter;
    private int worldSize;
    private Position startPos, goalPos;
    private ArrayList<Troop> regTroopList;

    public OverlayImageArray(int worldSize) {
        this.worldSize = worldSize;
        readImages();
        theWholeShit = new BufferedImage[10][10];
        regTroopPosition = new ArrayList<>();

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

    public void laser(){

    }

    public void updateImage(){
        clearThePath();

        try {
            for (Troop reg : regTroopList) {
                if(reg.getGraphic().equals("reg")) {
                    theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = regular;
                }
                else if(reg.getGraphic().equals("tel")){
                    theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = teleporter;
                }
            }
        }catch (NullPointerException e){}
    }




    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
