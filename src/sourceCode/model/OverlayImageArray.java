package sourceCode.model;

import sourceCode.model.Tile.Path;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;

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
    private ArrayList<Position> pathPositions;
    private BufferedImage path, regular, invisible, start, goal;
    private int worldSize;

    public OverlayImageArray(int worldSize) {
        this.worldSize = worldSize;
        readImages();
        theWholeShit = new BufferedImage[10][10];



        for(int i=0; i<worldSize; i++){
            for(int j=0; j<worldSize;j++){
                    theWholeShit[i][j] = invisible;
            }
        }

            theWholeShit[3][0] = regular;

    }

    private void readImages(){

        try {
            path = ImageIO.read(new File("src/Resources/path.png"));
            regular = ImageIO.read(new File("src/Resources/regular.png"));
            invisible = ImageIO.read(new File("src/Resources/invisible.png"));
            start = ImageIO.read(new File("src/Resources/start.png"));
            goal = ImageIO.read(new File("src/Resources/goal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeImage(){
        theWholeShit[3][1] = regular;
    }


    public void drawRegularTroops(ArrayList<Position> troopPositions){

    }

    public void drawTeleporterTroops(ArrayList<Position> troopPositions){

    }

    public void clearThePath(ArrayList<Position> pathPositions, Position startPos, Position goalPos){
        this.pathPositions = pathPositions;

        for(Position p :pathPositions){
            theWholeShit[p.getY()][p.getX()] = path;
        }

        theWholeShit[goalPos.getY()][goalPos.getX()] = this.goal;
        theWholeShit[startPos.getY()][startPos.getX()] = this.start;

    }


    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
