package sourceCode.model;

import javafx.geometry.Pos;
import sourceCode.model.Tile.Path;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Troop.Direction;
import sourceCode.model.Troop.RegularTroop;
import sourceCode.model.Xmlparser.LevelParser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Lagertest extends JPanel {
    public Path gubbe;
    public int worldWidth = 10;
    public int worldHeight = 10;
    int blockSize = 32;
    public RegularTroop rTroop;
    public Tile[][] tileMap;
    public Position startPos;
    public Position east;
    public Position south;
    public Position west;
    public Position north;




    public Lagertest(){
        define();
    }

    public void define(){

       Position startPos = LevelParser.startPos;
       tileMap = LevelParser.allTiles;


        rTroop = new RegularTroop(startPos, Direction.EAST);


        east = rTroop.getPosition().getPosToEast();

        System.out.println(tileMap[east.getY()][east.getX()].getGraphic());

        if(tileMap[east.getY()][east.getX()].getGraphic().equals("path")){
            System.out.println("mamma");
            rTroop.setPosition(east);
            rTroop.setBounds(235 + rTroop.getPosition().getX()*55,rTroop.getPosition().getY()*55,55,55);
        }

        //gubbe = new Path(new Position(1,3));
       // gubbe.setGroundId(5);
       // gubbe.setBounds(235 + gubbe.getPosition().getX()*55,gubbe.getPosition().getY()*55,55,55);
    }

    public void physic(){

    }


    public void draw(Graphics g){
        rTroop.draw(g);
    }
}
