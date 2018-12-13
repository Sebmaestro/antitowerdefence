package sourceCode.view;
import sourceCode.model.ImageArray;
import sourceCode.model.Tile.*;
import sourceCode.model.Xmlparser.*;

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

    ImageArray imgArr;

    public Tile[][] tileMap;

    public Room(){
        define();


    }

    public void define(){

       // setSize(new Dimension(550,550));
        //setMaximumSize(new Dimension(550,550));
       // setPreferredSize(new Dimension(550,550));
        bufferi = new ImageArray().getTheWholeShit();
        imgArr = new ImageArray();
        //block = new Block[worldWidth][worldHeight];
        tileMap = new Tile[worldHeight][worldWidth];
        tileMap = LevelParser.xmlparser("src/Resources/testLevel.xml");
    }

    public void physic(){

    }


    public void draw(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;

       // rTroop.setBounds(235 + rTroop.getPosition().getX() * 55, rTroop.getPosition().getY() * 55, 55, 55);


       for(int i=0; i<imgArr.getTheWholeShit().length; i++ ){
            for( int j=0; j<imgArr.getTheWholeShit().length; j++){
                graphics2D.drawImage(bufferi[j][i],235 + i*55,j*55,null);
            }
        }

    }
}