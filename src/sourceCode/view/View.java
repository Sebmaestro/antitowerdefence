package sourceCode.view;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 * Created by denni on 2018-12-05.
 */
public class View extends JFrame{
    public JFrame gameFrame;
    public Canvas canvas = new Canvas();
    private String gameInfoString;


    public View(){
        gameFrame = new JFrame("Anti TD Game");
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTheSize(gameFrame, (new Dimension(1080, 750)));
        gameFrame.setResizable(false);

        setTheSize(canvas, new Dimension(1080,600));


        gameFrame.add(canvas, BorderLayout.CENTER);

        gameInfoString = "";


        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        canvas.createBufferStrategy(3);






    }

    private void setTheSize(Component component, Dimension dimension){
        component.setMaximumSize(dimension);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
    }

}
