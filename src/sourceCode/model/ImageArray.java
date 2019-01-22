package sourceCode.model;

import sourceCode.model.tile.Tile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by denni and simon on 2018-12-13.
 */
public class ImageArray {

    private BufferedImage[][] theWholeShit;

    public ImageArray(Tile[][] allTiles) {

        theWholeShit = new BufferedImage[10][10];

        for(int i=0; i<allTiles.length; i++){
            for(int j=0; j<allTiles.length;j++){

                try {
                    theWholeShit[i][j] = ImageIO.read(ImageArray.class.getResourceAsStream(allTiles[i][j].getGraphic()));
                } catch (IOException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    public void setTowerPics(ArrayList<Position> towerpositions){


        for(Position p: towerpositions){
            try {
                theWholeShit[p.getY()][p.getX()] = ImageIO.read(ImageArray.class.getResourceAsStream("/tower.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
