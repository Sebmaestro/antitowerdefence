package sourceCode.view;

import sourceCode.model.ImageArray;
import sourceCode.model.OverlayImageArray;
import sourceCode.model.tile.Tile;
import sourceCode.model.xmlparser.LevelParser;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni on 2018-12-13.
 */

public class Overlay extends JLayeredPane {
    BufferedImage[][] overlayImg;

    public Overlay(BufferedImage[][] overlayImg) {
        this.overlayImg = overlayImg;
        define();
    }

    public void define() {
    }

    public void updateOverlay(BufferedImage[][] overlayImg) {
        this.overlayImg = overlayImg;

    }


    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        for(int i=0; i<overlayImg.length; i++ ){
            for( int j=0; j<overlayImg.length; j++){
                graphics2D.drawImage(overlayImg[j][i],235 + i*55,j*55,null);
            }
        }
    }
}