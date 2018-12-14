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

    public int worldWidth = 10;
    public int worldHeight = 10;
    int blockSize = 32;
    BufferedImage[][] bufferi;
    private BufferedImage[][] underLay;

    ImageArray imgArr;

    public Tile[][] tileMap;

    public Room(BufferedImage[][] underLay){
        this.underLay = underLay;

        define();


    }

    public void define(){
    }

    public void physic(){
    }


    public void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;

       // rTroop.setBounds(235 + rTroop.getPosition().getX() * 55, rTroop.getPosition().getY() * 55, 55, 55);

       for(int i=0; i<underLay.length; i++ ){
            for( int j=0; j<underLay.length; j++){
                graphics2D.drawImage(underLay[j][i],235 + i*55,j*55,null);
            }
        }

    }
}