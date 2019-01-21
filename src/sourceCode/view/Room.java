package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Dennis and Simon
 * 2019-01-21
 *
 * Class room
 */
class Room extends JLayeredPane {

    private BufferedImage[][] underLay;

    /**
     * Constructor: creates the underlay BufferedImage[][]
     */
    Room(BufferedImage[][] underLay){
        this.underLay = underLay;
    }

    /**
     * Draws the underLay on the right places on the screen, creating the
     * background image of the Level that the player sees. 
     * @param g - a Graphics
     */
    void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;

       for(int i=0; i<underLay.length; i++ ){
            for( int j=0; j<underLay.length; j++){
                graphics2D.drawImage(underLay[j][i],235 + i*55,j*55,null);
            }
        }

    }
}