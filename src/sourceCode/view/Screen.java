package sourceCode.view;
import sourceCode.model.KeyHandel;
import sourceCode.model.Store;
import sourceCode.model.Tile.Tile;
import sourceCode.view.*;

import javax.swing.*;
import java.awt.*;
/**
 * Created by denni on 2018-12-10.
 */

public class Screen extends JLayeredPane implements Runnable{
    public Thread thread = new Thread(this);

    public static Image[] tileset_ground = new Image[6];
    public static Image[] tileset_res = new Image[5];
    public static Image[] tileset_troop = new Image[2];
    public static Image[] tileset_tower = new Image[2];
    public static Tile[][] tiles;
    public static boolean isFirst = true;
    public static int myWidth, myHeight;
    public static Room room;
    public static Store store;
    public static Lagertest layer;
    public static TowerMofo torn;

    public static Point msc = new Point(0,0);

    public Screen(sourceCode.view.Frame frame) {
        frame.addMouseListener(new KeyHandel());
        frame.addMouseMotionListener(new KeyHandel());

        thread.start();
    }

    public void define(){

        room = new Room();
        setSize(new Dimension(550,550));
        store = new Store();
        layer = new Lagertest();
        torn = new TowerMofo();


        tileset_troop[0] = new ImageIcon("src/resources/regular.png").getImage();

        tileset_res[0] = new ImageIcon("src/resources/cell.png").getImage();
        tileset_tower[0] = new ImageIcon("src/resources/tower_2.png").getImage();

    }

    public void paintComponent(Graphics g){


        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();

            define();

            isFirst = false;
        }

        g.setColor(new Color(70,70,70));
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(new Color(0,0,0));
        setLayer(room, DEFAULT_LAYER);
        setLayer(torn, PALETTE_LAYER);
        setLayer(layer, DEFAULT_LAYER);

        room.draw(g); //Drawing the room
        store.draw(g); // drawing the store
        torn.draw(g);
        layer.draw(g);
    }


    public void run(){
        while(true){

            if(!isFirst) {
                room.physic();
                layer.physic();
                torn.physics(layer.rTroop);
            }

            repaint();
            try {
                thread.sleep(1);
            }catch(Exception e){}
        }
    }

}

