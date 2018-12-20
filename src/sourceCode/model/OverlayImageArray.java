package sourceCode.model;

import sourceCode.model.troop.Troop;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by denni and simon on 2018-12-13.
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

    private void readImages(){

        try {
            path = ImageIO.read(new File("src/Resources/path.png"));
            regular = ImageIO.read(new File("src/Resources/regular.png"));
            teleporter = ImageIO.read(new File("src/Resources/teleporter.png"));
            invisible = ImageIO.read(new File("src/Resources/invisible.png"));
            start = ImageIO.read(new File("src/Resources/start.png"));
            goal = ImageIO.read(new File("src/Resources/goal.png"));
            quicksand = ImageIO.read(new File("src/Resources/quicksand.png"));
            booster = ImageIO.read(new File("src/Resources/booster.png"));
            switchDown = ImageIO.read(new File("src/Resources/switch-down.png"));
            switchUp = ImageIO.read(new File("src/Resources/switch-up.png"));
            teleporterTile1 = ImageIO.read(new File("src/Resources/teleporter1.png"));

            tank = ImageIO.read(new File("src/Resources/tank.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void addRegularTroopList(ArrayList<Troop> regTroopList){
        this.regTroopList = regTroopList;
    }



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

    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
