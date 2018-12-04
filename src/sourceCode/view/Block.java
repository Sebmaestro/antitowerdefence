package sourceCode.view;
import java.awt.*;

/**
 * Created by denni on 2018-12-04.
 */
public class Block extends Rectangle{
    public int id;

    public Block(int x, int y, int width, int height){
        setBounds(x,y,width,height);
    }

    public void draw(Graphics g){
        g.drawRect(x,y,width,height);
    }
}
