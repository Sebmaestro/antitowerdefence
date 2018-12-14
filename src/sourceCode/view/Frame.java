package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame {
    public static String title = "Mammaspel";
    public static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underLay, overLay;
    private Screen screen;

    public Frame(BufferedImage[][] underLay, BufferedImage[][] overLay){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.underLay = underLay;
        this.overLay = overLay;

        init();
    }

    private void init(){
        setLayout(new BorderLayout());
        screen = new Screen(this, underLay, overLay);

        add(screen, BorderLayout.CENTER);
        setVisible(true);
    }

    public Screen getScreen(){
        return screen;
    }
}