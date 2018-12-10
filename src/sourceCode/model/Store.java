package sourceCode.model;
import java.awt.*;
import sourceCode.model.*;

/**
 * Created by denni on 2018-12-10.
 */
public class Store {
    public static int shopWidth = 3;
    public static int buttonSize = 52;
    public static int cellSpace = 2;

    public Rectangle[] button = new Rectangle[shopWidth];
    public Store(){
        define();
    }

    public void define(){
        for(int i =0; i<button.length; i++){
            button[i]  = new Rectangle((Screen.myWidth/2) - ((shopWidth*(buttonSize+cellSpace))/2) + ((buttonSize+cellSpace)*i), 575, buttonSize, buttonSize);
        }

    }

    public void draw(Graphics g ){

        for(int i=0; i<button.length; i++){
            if(button[i].contains(Screen.msc)){
                g.setColor(new Color(255,255,255, 150));
                g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
            }
            g.drawImage(Screen.tileset_res[0],button[i].x, button[i].y, button[i].width, button[i].height, null);
            //g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
        }
    }
}