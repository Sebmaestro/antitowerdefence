package sourceCode.view;
import sourceCode.model.KeyHandel;
import sourceCode.model.Position;
import sourceCode.model.Store;
import sourceCode.model.tile.Tile;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by denni on 2018-12-10.
 */

public class Screen extends JLayeredPane implements Runnable{
    //public Thread thread = new Thread(this);

    public static Tile[][] tiles;
    public static boolean isFirst = true;
    public static int myWidth, myHeight;
    public static Room room;
    public static Store store;
    public static Laser laser;
    public static Overlay overlay;
    private BufferedImage[][] underlayimg, overlayimg;
    Position laserStartPos, laserEndPos;

    private boolean laserBoolean;


    public static Point msc = new Point(0,0);

    public Screen() {
        //frame.addMouseListener(new KeyHandel());
        //frame.addMouseMotionListener(new KeyHandel());
        setSize(new Dimension(1080, 700));

        laserBoolean = false;

    }


    public void setImages(BufferedImage[][] underLay, BufferedImage[][] overLay) {
        underlayimg = underLay;
        overlayimg = overLay;
    }

    public void createGameScreen(){
        room = new Room(underlayimg);
        overlay = new Overlay(overlayimg);
        laser = new Laser();
    }

    public void drawLaser() {

        laserBoolean = true;

    }

    public void updateOverlay(BufferedImage[][] overLay){
        overlay.updateOverlay(overLay);
    }


    public void paintComponent(Graphics g){


        myWidth = getWidth();
        myHeight = getHeight();
        g.setColor(new Color(70,70,70));
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(new Color(0,0,0));

        setLayer(room, DEFAULT_LAYER);
        //setLayer(torn, PALETTE_LAYER);
        setLayer(overlay, PALETTE_LAYER);



        room.draw(g); //Drawing the room
        overlay.draw(g);


        if(laserBoolean) {
            setLayer(laser, PALETTE_LAYER);
            laser.draw(g);
            laserBoolean = false;
        }





        //store.draw(g); // drawing the store
        //torn.draw(g);
        //layer.draw(g);
    }



    public Overlay getOverlay(){
        return overlay;
    }

    public Laser getLaser(){
        return laser;
    }






    public void run(){


/*

        while(true){

            if(!isFirst) {
                room.physic();
                //layer.physic();
                torn.physics(layer.rTroop);
            }

            repaint();
            try {
                thread.sleep(1);
            }catch(Exception e){}
        }
        */
    }


}

