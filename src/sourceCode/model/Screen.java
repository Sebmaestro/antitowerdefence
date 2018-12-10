package sourceCode.model;
import sourceCode.model.Tile.Tile;
import sourceCode.model.*;

import javax.swing.*;
import java.awt.*;
/**
 * Created by denni on 2018-12-10.
 */

public class Screen extends JLayeredPane implements Runnable{
    public Thread thread = new Thread(this);

    public static Image[] tileset_ground = new Image[6];
    public static Image[] tileset_res = new Image[5];
    public static Tile[][] tiles;
    public static boolean isFirst = true;
    public static int myWidth, myHeight;
    public static Room room;
    public static Store store;
    public static Lagertest layer;

    public static Point msc = new Point(0,0);

    public Screen(Frame frame) {
        frame.addMouseListener(new KeyHandel());
        frame.addMouseMotionListener(new KeyHandel());

        thread.start();
    }

    public void define(){

        room = new Room();
        setSize(new Dimension(1080,700));
        store = new Store();
        layer = new Lagertest();




        tileset_ground[0] = new ImageIcon("src/Resources/grass.png").getImage();
        tileset_ground[1] = new ImageIcon("src/Resources/path.png").getImage();
        tileset_ground[2] = new ImageIcon("src/Resources/towerzone.png").getImage();
        tileset_ground[3] = new ImageIcon("src/Resources/start.png").getImage();
        tileset_ground[4] = new ImageIcon("src/Resources/goal.png").getImage();
        tileset_ground[5] = new ImageIcon("src/Resources/regular.png").getImage();
        //tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0,26 * i,26,26)));

        tileset_res[0] = new ImageIcon("src/Resources/cell.png").getImage();

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
        setLayer(layer, PALETTE_LAYER);
        room.draw(g); //Drawing the room
        store.draw(g); // drawing the store
        layer.draw(g);
    }


    public void run(){
        while(true){

            if(!isFirst) {
                room.physic();
            }

            repaint();
            try {
                thread.sleep(1);
            }catch(Exception e){}
        }
    }

}

