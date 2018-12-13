package sourceCode.model;

import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by denni on 2018-12-13.
 */
public class OverlayImageArray {
    private BufferedImage allPics;
    Tile[][] allTiles;
    private BufferedImage[][] theWholeShit;

    public OverlayImageArray() {

        theWholeShit = new BufferedImage[10][10];


        allTiles = LevelParser.xmlparser("src/Resources/testlevel.xml");


        for(int i=0; i<allTiles.length; i++){
            for(int j=0; j<allTiles.length;j++){

                try {
                    theWholeShit[i][j] = ImageIO.read(new File("src/Resources/invisible.png"));
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }

            }
        }

        try {
            theWholeShit[3][0] = ImageIO.read(new File("src/Resources/regular.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public BufferedImage[][] getTheWholeShit(){
        return theWholeShit;
    }
}
