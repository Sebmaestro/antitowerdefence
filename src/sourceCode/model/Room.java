package sourceCode.model;
import sourceCode.model.Tile.*;
import sourceCode.model.Xmlparser.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Room extends JPanel {

    public int worldWidth = 10;
    public int worldHeight = 10;
    int blockSize = 32;

    public Tile[][] tileMap;

    public Room(){
        define();
    }

    public void define(){
        //block = new Block[worldWidth][worldHeight];
        tileMap = new Tile[worldHeight][worldWidth];
        tileMap = LevelParser.xmlparser("src/Resources/testLevel.xml");
    }

    public void physic(){

    }


    public void draw(Graphics g){
        for(int y=0;y<tileMap.length;y++){
            for(int x=0; x<tileMap[0].length; x++){
                tileMap[y][x].draw(g);
                //block[y][x] = new Block(x * blockSize, y * blockSize, blockSize, blockSize, 0, 0);
            }
        }
    }
}