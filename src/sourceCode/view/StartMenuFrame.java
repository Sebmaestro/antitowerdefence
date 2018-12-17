package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenuFrame extends JFrame {
    private JButton highscores;
    private JButton map1;
    private JButton map2;
    private JButton quit;

    public StartMenuFrame() {
        super("Anti Towerdefence");

        setSize(300, 90);

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
        setVisible(true);
    }

    public void addActionListener(ActionListener e, String s) {
        if (s.equals("map1")) {
            map1.addActionListener(e);
        } else if (s.equals("map2")) {
            map2.addActionListener(e);
        } else if (s.equals("highscore")){
            highscores.addActionListener(e);
        } else {
            quit.addActionListener(e);
        }
    }
}
