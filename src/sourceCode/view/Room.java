package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni and Simon on 2018-12-04.
 */
class Room extends JLayeredPane {

    private BufferedImage[][] underLay;

    Room(BufferedImage[][] underLay){
        this.underLay = underLay;
    }


    void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;

       for(int i=0; i<underLay.length; i++ ){
            for( int j=0; j<underLay.length; j++){
                graphics2D.drawImage(underLay[j][i],235 + i*55,j*55,null);
            }
        }

    }
}