package sourceCode.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static String title = "Mammaspel";
    public static Dimension size = new Dimension(1080,700);

    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

   /* public void setSize(Dimension dim){

    }
    */

    public void init(){
        setLayout(new BorderLayout());

        // BufferedImage b = new BufferedImage(100,100,2);

        //Graphics g = b.getGraphics();

        Screen screen = new Screen(this);

        // g = screen.getGraphics();
        add(screen, BorderLayout.CENTER);
        setVisible(true);
    }
}