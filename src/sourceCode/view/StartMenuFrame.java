package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Author: Sebastian Arledal
 */
public class StartMenuFrame extends JFrame {
    private JButton highscores;
    private JButton map1;
    private JButton map2;
    private JButton quit;

    public StartMenuFrame() {
        super("Anti Towerdefence");

        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        map1 = new JButton("Map1");
        map2 = new JButton("Map2");
        highscores = new JButton("Highscore");
        quit = new JButton("Quit");

        panel.add(map1);
        panel.add(highscores);
        panel.add(map2);
        panel.add(quit);

        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    /**
     *
     *
     * @param e - e
     * @param s - s
     */
    public void addActionListener(ActionListener e, String s) {
        switch (s) {
            case "map1":
                map1.addActionListener(e);
                break;
            case "map2":
                map2.addActionListener(e);
                break;
            case "highscore":
                highscores.addActionListener(e);
                break;
            default:
                quit.addActionListener(e);
                break;
        }
    }
}
