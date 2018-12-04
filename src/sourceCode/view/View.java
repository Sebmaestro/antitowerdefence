package sourceCode.view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    public static String title = "Level 1";
    public static Dimension size = new Dimension(650, 550);

    public View(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

    }

    public void init() {
        setVisible(true);
    }
}
