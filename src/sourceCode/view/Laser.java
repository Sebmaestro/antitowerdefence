package sourceCode.view;

import sourceCode.model.LaserPositions;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by denni on 2018-12-16.
 * 2019-01-21
 */
public class Laser extends JLayeredPane{
    private ArrayList<LaserPositions> toBeDrawn;
    private ArrayList<Line2D> laserList;


    /**
     * Constructor: for the Laser Object
     */
    Laser(){
        laserList = new ArrayList<>();
        toBeDrawn = new ArrayList<>();
    }

    /**
     * fills the ArrayList laserList with Line2D that later on will be
     * drawn as lasers on the screen.
     */
    public void setLasers(){
        for(LaserPositions laserpos: toBeDrawn){
            Line2D laseri = new Line2D.Double();
            laseri.setLine(235+27+(laserpos.getTowerPosition().getX()*55), 27+ (laserpos.getTowerPosition().getY()*55),
                    235 +27+ (laserpos.getTroopPosition().getX()*55),27 + (laserpos.getTroopPosition().getY() * 55));
            laserList.add(laseri);
        }
    }

    /**
     * Sets the positions of the lasers
     * @param laserpossi - an ArrayList<LaserPositions> that holds all the
     *                   positions of the lasers
     */
    public void setPositons(ArrayList<LaserPositions> laserpossi){
        this.toBeDrawn = laserpossi;
    }


    /**
     * Draws the lasers on the right places of the screen and then clears
     * the laserList. 
     * @param g - a Graphics
     */
    void draw(Graphics g){

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(4));

        for(Line2D laseri: laserList){

            graphics2D.draw(laseri);
        }
        laserList.clear();
    }
}
