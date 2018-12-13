package sourceCode.view;

import sourceCode.model.ImageArray;
import sourceCode.model.OverlayImageArray;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni on 2018-12-13.
 */

public class Overlay extends JLayeredPane {
    public int worldWidth = 10;
    public int worldHeight = 10;
    int blockSize = 32;
    BufferedImage[][] bufferi;
    OverlayImageArray overimgArr;

    public Overlay() {
        define();


    }

    public void define() {
        bufferi = new OverlayImageArray().getTheWholeShit();


    }

    public void physic() {


    }


    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        for(int i=0; i<bufferi.length; i++ ){
            for( int j=0; j<bufferi.length; j++){
                graphics2D.drawImage(bufferi[j][i],235 + i*55,j*55,null);
            }
        }
    }
}