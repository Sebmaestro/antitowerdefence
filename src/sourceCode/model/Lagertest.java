package sourceCode.model;

import sourceCode.model.Tile.Path;
import sourceCode.model.Troop.Direction;
import sourceCode.model.Troop.RegularTroop;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Lagertest extends JPanel {
    public Path gubbe;
    public int worldWidth = 1;
    public int worldHeight = 1;
    int blockSize = 32;
    public RegularTroop rTroop;



    public Lagertest(){
        define();
    }

    public void define(){
        rTroop = new RegularTroop(new Position(1,3), Direction.EAST);

        rTroop.setBounds(235 + rTroop.getPosition().getX()*55,rTroop.getPosition().getY()*55,55,55);

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
