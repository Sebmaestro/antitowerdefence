package sourceCode.model;

import sourceCode.model.tile.Tile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by denni and simon
 * 2019-01-25
 *
 * Class that builds up a 2d buffered image array that represents the level
 */
public class ImageArray {

    private BufferedImage[][] theWholeShit;

    /**
     * Constructor for ImageArray
     * @param allTiles - Tiles that constructs the level
     * @throws IOException - Exception when reading from IO
     */
    public ImageArray(Tile[][] allTiles) throws IOException {

        theWholeShit = new BufferedImage[10][10];

        for(int i=0; i<allTiles.length; i++){
            for(int j=0; j<allTiles.length;j++){

                theWholeShit[i][j] = ImageIO.read(ImageArray.class.
                        getResourceAsStream(allTiles[i][j].getGraphic()));

            }
        }
    }

    /**
     * Method that adds tower pictures to all tower positions
     * @param towerpositions - ArrayList with tower positions
     * @throws IOException - Exception when reading from IO
     */
    public void setTowerPics(ArrayList<Position> towerpositions)
            throws IOException {


        for(Position p: towerpositions){
            theWholeShit[p.getY()][p.getX()] = ImageIO.read(
                    ImageArray.class.getResourceAsStream("/tower.png"));
        }

    }

    /**
     * Method that returns the BufferedImage[][] that represents the level
     * @return - theWholeShit - a BufferedImage[][] that represents the level
     */
    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
