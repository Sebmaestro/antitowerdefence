package sourceCode.view;

import javafx.stage.Screen;

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
        setLayout(new GridLayout(1, 1, 0, 0));



        setVisible(true);
    }
}
