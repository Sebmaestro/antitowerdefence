package sourceCode.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by David Eriksson / Simon Lundkvist
 * 2019-01-21
 * Class to represent the drop down menu bar in the top left corner.
 */
public class GameMenu extends JMenuBar{

    private JMenuItem restart;
    private JMenuItem pause;
    private JMenuItem quit;
    private JMenuItem help;
    private JMenuItem about;

    /**
     * Constructor: calls the createMenuBar method that initializes the menu.
     */
    GameMenu(){
        createMenuBar();
    }

    /**
     * createMenuBar: initializes the menu bar and its fields.
     * @return the JMenuBar
     */
    JMenuBar createMenuBar() {

        JMenuBar menu2 = new JMenuBar();

        JMenu firstMenu = new JMenu("Menu");
        JMenu secondMenu = new JMenu("Help");

        restart = new JMenuItem("New Game");
        pause = new JMenuItem("Pause");
        quit = new JMenuItem("Quit");

        help = new JMenuItem("Help");
        about = new JMenuItem("About");

        firstMenu.add(restart);
        firstMenu.add(pause);
        firstMenu.add(quit);

        secondMenu.add(help);
        secondMenu.add(about);

        menu2.add(firstMenu);
        menu2.add(secondMenu);

        return menu2;
    }

    /**
     * setRestartListener: sets the restart menu item listener
     * @param actionListener an ActionListener to set the restart item to
     */
    public void setRestartListener(ActionListener actionListener){
        restart.addActionListener(actionListener);
    }

    /**
     * setPauseListener: sets the pause menu item listener
     * @param actionListener an ActionListener to set the pause item to
     */
    public void setPauseListener(ActionListener actionListener){
        pause.addActionListener(actionListener);
    }

    /**
     * setQuitListener: sets the quit menu item listener
     * @param actionListener an ActionListener to set the quit item to
     */
    public void setQuitListener(ActionListener actionListener){
        quit.addActionListener(actionListener);
    }

    /**
     * setHelpListener: sets the help menu item listener
     * @param actionListener an ActionListener to set the help item to
     */
    public void setHelpListener(ActionListener actionListener){
        help.addActionListener(actionListener);
    }

    /**
     * setAboutListener: sets the about menu item listener
     * @param actionListener an ActionListener to set the about item to
     */
    public void setAboutListener(ActionListener actionListener){
        about.addActionListener(actionListener);
    }

    /**
     * setRestartNewGameText: sets the restart menu items text
     * @param str a string to set the restart item text to
     */
    public void setRestartNewGameText(String str) {
        restart.setText(str);
    }

    /**
     * setPauseText: sets the pause menu items text
     * @param str a string to set the pause item text to
     */
    public void setPauseText(String str) {
        pause.setText(str);
    }

}
