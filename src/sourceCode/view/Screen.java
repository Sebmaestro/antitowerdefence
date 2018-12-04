package sourceCode.view;
import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Screen extends JPanel implements Runnable{
    public static int myWidth, myHeight;
    public static boolean isFirst = true;
    public static int fpsFrame=0, fps = 30;
    public static Room room;
    public Screen(){

    }

    public void define(){
        room = new Room();

    }
    protected void paintComponent(Graphics g){
        if(!isFirst){
            define();

            isFirst = false;
        }

       g.clearRect(0,0, getWidth(), getHeight());

        room.draw(g);
    }

    public void run(){
        while(true){
            if(!isFirst){
                define();

                isFirst = false;
            }
            repaint();
        }
    }
}
