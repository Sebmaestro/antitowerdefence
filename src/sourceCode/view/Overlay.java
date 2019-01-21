package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni and simon on 2018-12-13.
 */

class Overlay extends JLayeredPane {
    private BufferedImage[][] overlayImg;

    /**
     * Constructor: creates new Overlay
     * @param overlayImg - a BufferedImage[][]
     */
    Overlay(BufferedImage[][] overlayImg) {
        this.overlayImg = overlayImg;
        define();
    }

    /**
     * Does not do anything in particular
     */
    private void define() {
    }

    /**
     * updates the overlayImg
     * @param overlayImg - a BufferedImage[][] to be updated
     */
    void updateOverlay(BufferedImage[][] overlayImg) {
        this.overlayImg = overlayImg;

    }

    /**
     * Draws the overlaying image correctly on the screen.
     * @param g - a Graphics.
     */
    void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        for(int i=0; i<overlayImg.length; i++ ){
            for( int j=0; j<overlayImg.length; j++){
                graphics2D.drawImage(overlayImg[j][i], 235 + i*55,j*55,null);
            }
        }
    }
}