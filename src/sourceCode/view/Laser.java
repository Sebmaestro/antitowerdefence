package sourceCode.view;

import sourceCode.model.LaserPositions;
import sourceCode.model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by denni on 2018-12-16.
 */
public class Laser extends JLayeredPane{
    private Position startPos, endPos;
    Line2D laser;
    ArrayList<LaserPositions> toBeDrawn;
    ArrayList<Line2D> laserList;



    public Laser(){
        laser = new Line2D.Double();
        laserList = new ArrayList<>();
        toBeDrawn = new ArrayList<>();
    }

    public void setLaserPosition(Position StartPos, Position EndPos){
        this.startPos = StartPos;
        this.endPos = EndPos;
        laser.setLine(235+27+(startPos.getX()*55), 27+ (startPos.getY()*55) , 235 +27+ (endPos.getX()*55),27 + (endPos.getY() * 55));

    }

    public void setLasers(){
        for(LaserPositions laserpos: toBeDrawn){
            Line2D laseri = new Line2D.Double();
            laseri.setLine(235+27+(laserpos.getTowerPosition().getX()*55), 27+ (laserpos.getTowerPosition().getY()*55),
                    235 +27+ (laserpos.getTroopPosition().getX()*55),27 + (laserpos.getTroopPosition().getY() * 55));
            laserList.add(laseri);
        }
    }

    public void setPositons(ArrayList<LaserPositions> laserpossi){
        this.toBeDrawn = laserpossi;
    }



    public void draw(Graphics g){

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(4));


        //graphics2D.draw(laser);

        for(Line2D laseri: laserList){

            graphics2D.draw(laseri);
        }

        laserList.clear();




    }



}
