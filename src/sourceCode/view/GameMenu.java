package sourceCode.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by David on 2018-12-14.
 */
public class GameMenu extends JMenuBar{

    private JMenuItem restart;
    private JMenuItem pause;
    private JMenuItem quit;
    private JMenuItem help;
    private JMenuItem about;

    private JMenuBar menu, menu2;
    private JMenu firstMenu;
    private JMenu secondMenu;




    public GameMenu(){
        menu = createMenuBar();
    }


    public JMenuBar createMenuBar() {

        menu2 = new JMenuBar();

        firstMenu = new JMenu("Menu");
        secondMenu = new JMenu("Help");

        restart = new JMenuItem("New Game/Restart");
        pause = new JMenuItem("Pause/Resume");
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


}
