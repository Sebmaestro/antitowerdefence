package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainFrame extends JFrame{

    public static String title = "Mammaspel";
    public static Dimension size = new Dimension(1080,700);
    private BufferedImage[][] underlay, overlay;
    private Screen screen;
    private ButtonPanel buttonPanel;
    private GameMenu menuBar;
    public MainFrame(BufferedImage[][] underlay, BufferedImage[][] overlay) {
        this.underlay = underlay;
        this.overlay = overlay;
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

    public MainFrame initFrame(){
        addScreen();
        addButtonPanel();
        addMenuBar();
        getScreen().setImages(underlay, overlay);
        getScreen().createGameScreen();

        return this;
    }

    public ButtonPanel getButtonPanel(){
        return this.buttonPanel;
    }

    public GameMenu getGameMenu() {
        return this.menuBar;
    }

    public void addScreen(){
        add(screen, BorderLayout.CENTER);
    }
    public void addButtonPanel() {
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public void addMenuBar() {
        setJMenuBar(menuBar.createMenuBar());
    }
    private void init(){

        //screen = new Screen();

        //add(screen, BorderLayout.CENTER);

    }

    public Screen getScreen(){
        return screen;
    }

    public void setRestartListener(ActionListener actionListener){
        menuBar.setRestartListener(actionListener);
    }

    public void setPauseListener(ActionListener actionListener){
        menuBar.setPauseListener(actionListener);
    }

    public void setQuitListener(ActionListener actionListener){
        menuBar.setQuitListener(actionListener);
    }

    public void setHelpListener(ActionListener actionListener){
        menuBar.setHelpListener(actionListener);
    }

    public void setAboutListener(ActionListener actionListener){
        menuBar.setAboutListener(actionListener);
    }
}