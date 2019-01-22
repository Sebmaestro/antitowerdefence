package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Author: Simon Lundkvist /Dennis Karlman
 * 2019-01-21
 * Class to represent the main frame of the game that contains
 * all of the components
 */
public class MainFrame extends JFrame{

    private static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underlay, overlay;
    private Screen screen;
    private ButtonPanel buttonPanel;
    private GameMenu menuBar;

    /**
     * Constructor: initializes the mainframe and its fields
     * @param underlay A 2D Array of BufferedImages that will represent the static part of the level
     * @param overlay A 2D Array of BufferedImages that will represent the dynamic parts of the level
     */
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

    public void notifyUser(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    /**
     * initFrame: initializes the frame
     */
    private void initFrame(){
        addScreen();
        addButtonPanel();
        addMenuBar();
        getScreen().setImages(underlay, overlay);
        getScreen().createGameScreen();
    }

    /**
     * getButtonPanel: getter for the button panel
     * @return the button panel
     */
    public ButtonPanel getButtonPanel(){
        return this.buttonPanel;
    }

    /**
     * getGameMenu: getter for the game menu
     * @return the game menu
     */
    public GameMenu getGameMenu() {
        return this.menuBar;
    }

    /**
     * getScreen: getter for the screen
     * @return the screen
     */
    public Screen getScreen(){
        return screen;
    }

    /**
     * addScreen: adds the screen to the main frame
     */
    private void addScreen(){
        add(screen, BorderLayout.CENTER);
    }

    /**
     * addButtonPanel: adds the button panel to the main frame
     */
    private void addButtonPanel() {
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * addMenuBar: adds the menu bar to the main frame
     */
    private void addMenuBar() {
        setJMenuBar(menuBar.createMenuBar());
    }
}