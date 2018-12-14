package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame{
    public static String title = "Mammaspel";
    public static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underLay, overLay;
    private Screen screen;

    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init(){
        setLayout(new BorderLayout());
        screen = new Screen();

        add(screen, BorderLayout.CENTER);
        setVisible(true);
    }

    public Screen getScreen(){
        return screen;
    }
}