package sourceCode.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by David Eriksson / Simon Lundkvist
 */
public class GameMenu extends JMenuBar{

    private JMenuItem restart;
    private JMenuItem pause;
    private JMenuItem quit;
    private JMenuItem help;
    private JMenuItem about;


    GameMenu(){
        createMenuBar();
    }

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

    public void setRestartListener(ActionListener actionListener){
        restart.addActionListener(actionListener);
    }

    public void setPauseListener(ActionListener actionListener){
        pause.addActionListener(actionListener);
    }

    public void setQuitListener(ActionListener actionListener){
        quit.addActionListener(actionListener);
    }

    public void setHelpListener(ActionListener actionListener){
        help.addActionListener(actionListener);
    }

    public void setAboutListener(ActionListener actionListener){
        about.addActionListener(actionListener);
    }

    public void setRestartNewGameText(String str) {
        restart.setText(str);
    }

    public void setPauseText(String str) {
        pause.setText(str);
    }

}
