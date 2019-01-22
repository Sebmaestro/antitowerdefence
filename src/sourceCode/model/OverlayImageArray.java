package sourceCode.model;

import sourceCode.model.troop.Troop;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dennis and Simon on 2018-12-13.
 * 2019-01-21
 */
public class OverlayImageArray {
    private BufferedImage[][] theWholeShit;
    private ArrayList<Position> pathPositions;
    private ArrayList<Position> quicksandPosition;
    private ArrayList<Position> boosterPosition;
    private ArrayList<Position> switchDownPosition;
    private ArrayList<Position> switchUpPosition;
    private ArrayList<Position> teleporterTile1Positons;

    private BufferedImage path;
    private BufferedImage regular;
    private BufferedImage invisible;
    private BufferedImage start;
    private BufferedImage goal;
    private BufferedImage quicksand;
    private BufferedImage booster;
    private BufferedImage switchDown;
    private BufferedImage switchUp;
    private BufferedImage teleporter;
    private BufferedImage teleporterTile1;
    private BufferedImage tank;
    private Position startPos;
    private Position goalPos;
    private ArrayList<Troop> regTroopList;

    /**
     * Constructor: creates a new OverlayImageArray
     * @param worldSize - an int of the levels size
     */
    public OverlayImageArray(int worldSize) {
        readImages();
        theWholeShit = new BufferedImage[10][10];
        teleporterTile1Positons = new ArrayList<>();

        for(int i=0; i<worldSize; i++){
            for(int j=0; j<worldSize;j++){
                    theWholeShit[i][j] = invisible;
            }
        }

    }


    /**
     * Reads all the images from the resources
     */
    private void readImages(){

        try {
            path = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/path.png"));
            regular = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/regular.png"));
            teleporter = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/teleporter.png"));
            invisible = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/invisible.png"));
            start = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/start.png"));
            goal = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/goal.png"));
            quicksand = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/quicksand.png"));
            booster = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/booster.png"));
            switchDown = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/switch-down.png"));
            switchUp = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/switch-up.png"));
            teleporterTile1 = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/teleporter1.png"));

            tank = ImageIO.read(OverlayImageArray.class.getResourceAsStream("/tank.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * sets an ArrayList<Troop>
     * @param regTroopList - an ArrayList<Troop> to be set
     */
    public void addRegularTroopList(ArrayList<Troop> regTroopList){
        this.regTroopList = regTroopList;
    }


    /**
     * clears the path for visible areas of the overlaying image
     */
    private void clearThePath(){
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

    /**
     * adds all the positions that should be drawn on the overlaying image
     * @param pathPositions - ArrayList with pathPositions
     * @param quicksandPositions - ArrayList with quicksandPositions
     * @param boosterPositions - ArrayList with boosterPositions
     * @param switchDown - ArrayList with switchDownPositions
     * @param switchUp - ArrayList with switchUpPositions
     * @param startPos - ArrayList with startPositions
     * @param goalPos - ArrayList with goalPositions
     */
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

    /**
     * changes the switchTile from an up- to downSwitch
     * @param p - the position of the switchDownTile to be changed
     */
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

    /**
     * Adds a teleportTile to a certain position
     * @param p - a Positon for the teleportTile
     */
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

    /**
     * changes the switchTile from a down- to an upSwitch
     * @param p - the position of the switchDownTile to be changed
     */
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

    /**
     * Clears the overlaying image
     * and updates it with the latest information.
     */
    public void updateImage(){
        clearThePath();

        try {
            for (Troop reg : regTroopList) {

                switch (reg.getGraphic()) {
                    case "Regular":
                        theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = regular;
                        break;
                    case "Teleporter":
                        theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = teleporter;
                        break;
                    case "Tank":
                        theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = tank;
                        break;
                }
            }
        }catch (NullPointerException ignored){}
    }

    /**
     * gets the while overlaying image as a BufferedImage[][]
     * @return theWholeShit - an BufferedImage[][]
     */
    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
