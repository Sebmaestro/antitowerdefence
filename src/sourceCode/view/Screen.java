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
    public static Overlay overlay;
    private BufferedImage[][] underlayimg, overlayimg;
    private Line2D laser;
    Position laserStartPos, laserEndPos;

    private boolean laserIsOK;


    public static Point msc = new Point(0,0);

    public Screen() {
        //frame.addMouseListener(new KeyHandel());
        //frame.addMouseMotionListener(new KeyHandel());
        setSize(new Dimension(1080,700));
        laserIsOK = false;
        laser = new Line2D() {
            @Override
            public double getX1() {
                return 0;
            }

            @Override
            public double getY1() {
                return 0;
            }

            @Override
            public Point2D getP1() {
                return null;
            }

            @Override
            public double getX2() {
                return 0;
            }

            @Override
            public double getY2() {
                return 0;
            }

            @Override
            public Point2D getP2() {
                return null;
            }

            @Override
            public void setLine(double x1, double y1, double x2, double y2) {

            }

            @Override
            public Rectangle2D getBounds2D() {
                return null;
            }
        };
    }


    public void setImages(BufferedImage[][] underLay, BufferedImage[][] overLay) {
        underlayimg = underLay;
        overlayimg = overLay;
    }

    public void createGameScreen(){
        room = new Room(underlayimg);
        overlay = new Overlay(overlayimg);
    }

    public void drawLaser(Position laserStartPos, Position laserEndPos) {
        this.laserStartPos = laserStartPos;
        this.laserEndPos = laserEndPos;
        laserIsOK = true;
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

        if(laserIsOK){
            g.drawLine(laserStartPos.getX(), laserStartPos.getY(), laserEndPos.getX(), laserEndPos.getY());
        }


        setLayer(room, DEFAULT_LAYER);
        //setLayer(torn, PALETTE_LAYER);
        setLayer(overlay, PALETTE_LAYER);

        room.draw(g); //Drawing the room
        overlay.draw(g);
        //store.draw(g); // drawing the store
        //torn.draw(g);
        //layer.draw(g);
    }



    public Overlay getOverlay(){
        return overlay;
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

