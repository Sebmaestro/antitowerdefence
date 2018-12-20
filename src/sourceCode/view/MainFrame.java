package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Author: Simon Lundkvist /Dennis Karlman
 */
public class MainFrame extends JFrame{

    private static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underlay, overlay;
    private Screen screen;
    private ButtonPanel buttonPanel;
    private GameMenu menuBar;

    public MainFrame(BufferedImage[][] underlay, BufferedImage[][] overlay) {
        this.underlay = underlay;
        this.overlay = overlay;
        String title = "Mammaspel";
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        screen = new Screen();
        buttonPanel = new ButtonPanel();
        menuBar = new GameMenu();
        initFrame();
    }

    private void initFrame(){
        addScreen();
        addButtonPanel();
        addMenuBar();
        getScreen().setImages(underlay, overlay);
        getScreen().createGameScreen();
    }

    public ButtonPanel getButtonPanel(){
        return this.buttonPanel;
    }

    public GameMenu getGameMenu() {
        return this.menuBar;
    }

    public Screen getScreen(){
        return screen;
    }

    private void addScreen(){
        add(screen, BorderLayout.CENTER);
    }

    private void addButtonPanel() {
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addMenuBar() {
        setJMenuBar(menuBar.createMenuBar());
    }
}