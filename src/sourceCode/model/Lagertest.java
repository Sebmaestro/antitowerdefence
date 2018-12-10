package sourceCode.model;
import sourceCode.model.Tile.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denni on 2018-12-04.
 */
public class Lagertest extends JPanel {
    public Path gubbe;
    public int worldWidth = 1;
    public int worldHeight = 1;
    int blockSize = 32;



    public Lagertest(){
        define();
    }

    public void define(){
        gubbe = new Path(new Position(1,3));
        gubbe.setGroundId(5);
        gubbe.setBounds(235 + gubbe.getPosition().getX()*55,gubbe.getPosition().getY()*55,55,55);
    }

    public void physic(){

    }


    public void draw(Graphics g){
        gubbe.draw(g);
    }
}
