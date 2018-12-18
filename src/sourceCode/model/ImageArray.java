package sourceCode.model;

import sourceCode.model.tile.Tile;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by denni on 2018-12-13.
 */
public class ImageArray {

    private BufferedImage allPics;
    Tile[][] allTiles;
    private BufferedImage[][] theWholeShit;

    public ImageArray(Tile[][] allTiles) {

        theWholeShit = new BufferedImage[10][10];

        allPics = new BufferedImage(55, 55, BufferedImage.TYPE_INT_RGB);
        this.allTiles = allTiles;



        for(int i=0; i<allTiles.length; i++){
            for(int j=0; j<allTiles.length;j++){

                try {
                    theWholeShit[i][j] = ImageIO.read(new File(allTiles[i][j].getGraphic()));
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public void setTowerPics(ArrayList<Position> towerpositions){


        for(Position p: towerpositions){
            try {
                theWholeShit[p.getY()][p.getX()] = ImageIO.read(new File("src/Resources/tower.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public BufferedImage getAllPics(){
        return allPics;
    }

    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }



}
