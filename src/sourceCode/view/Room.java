package sourceCode.view;
import sourceCode.model.ImageArray;
import sourceCode.model.tile.*;
import sourceCode.model.xmlparser.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni on 2018-12-04.
 */
public class Room extends JLayeredPane {

    private BufferedImage[][] underLay;

    public Room(BufferedImage[][] underLay){
        this.underLay = underLay;
    }


    public void updateRoom(BufferedImage[][] underLay){
        this.underLay = underLay;
    }


    public void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;

       for(int i=0; i<underLay.length; i++ ){
            for( int j=0; j<underLay.length; j++){
                graphics2D.drawImage(underLay[j][i],235 + i*55,j*55,null);
            }
        }

    }
}