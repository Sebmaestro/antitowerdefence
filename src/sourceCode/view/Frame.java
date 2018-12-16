package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame{
    public static String title = "Mammaspel";
    public static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underLay, overLay;
    private Screen screen;
    private ButtonPanel buttonPanel;

    public Frame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        screen = new Screen();
        buttonPanel = new ButtonPanel();
        //init();
    }

    public ButtonPanel getButtonPanel(){
        return this.buttonPanel;
    }

    public void addScreen(){
        add(screen, BorderLayout.CENTER);
    }
    public void addButtonPanel() {
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void init(){

        //screen = new Screen();

        //add(screen, BorderLayout.CENTER);

    }

    public Screen getScreen(){
        return screen;
    }
}