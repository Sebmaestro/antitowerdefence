package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenuFrame extends JFrame {
    private JButton highscores;
    private JButton map1;
    private JButton map2;

    public StartMenuFrame() {
        super("Anti Towerdefence");

        setSize(300, 85);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        map1 = new JButton("map1");
        map2 = new JButton("map2");
        highscores = new JButton("Highscore");

        panel.add(map1);
        panel.add(map2);
        panel.add(highscores);

        add(panel);

        setVisible(true);
    }

    public void addActionListener(ActionListener e, String s) {
        if (s.equals("map1")) {
            map1.addActionListener(e);
        } else if (s.equals("map2")) {
            map2.addActionListener(e);
        } else {
            highscores.addActionListener(e);
        }
    }
}
