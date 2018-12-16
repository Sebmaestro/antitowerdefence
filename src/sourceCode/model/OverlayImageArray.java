package sourceCode.model;

import sourceCode.model.tile.Path;
import sourceCode.model.tile.Tile;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;

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
    private ArrayList<Position> pathPositions, regTroopPosition, telepTroopPosition;
    private BufferedImage path, regular, invisible, start, goal, tower;
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
            invisible = ImageIO.read(new File("src/Resources/invisible.png"));
            start = ImageIO.read(new File("src/Resources/start.png"));
            goal = ImageIO.read(new File("src/Resources/goal.png"));
            tower = ImageIO.read(new File("src/Resources/tower.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void addRegularTroopList(ArrayList<Troop> regTroopList){
        this.regTroopList = regTroopList;
    }

    public void addTeleportTroopList(ArrayList<Position> troopPositions){

    }

    public void clearThePath(){
        for(Position p :pathPositions){
            theWholeShit[p.getY()][p.getX()] = path;
        }

        theWholeShit[goalPos.getY()][goalPos.getX()] = goal;
        theWholeShit[startPos.getY()][startPos.getX()] = start;

    }

    public void addPaths(ArrayList<Position> pathPositions, Position startPos, Position goalPos){
        this.pathPositions = pathPositions;
        this.startPos = startPos;
        this.goalPos = goalPos;

    }

    public void laser(){

    }

    public void updateImage(){
        clearThePath();

        try {
            for (Troop reg : regTroopList) {
                theWholeShit[reg.getPosition().getY()][reg.getPosition().getX()] = regular;
            }
        }catch (NullPointerException e){}
    }




    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
