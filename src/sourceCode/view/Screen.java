package sourceCode.view;
import javax.swing.*;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Screen extends JPanel implements Runnable{
    public static int myWidth, myHeight;
    public static boolean isFirst = true;
    public Screen(){

    }

    protected void paintComponent(Graphics g){

       g.clearRect(0,0, getWidth(), getHeight());
    }

    public void run(){
        while(true){
            repaint();
        }
    }
}
