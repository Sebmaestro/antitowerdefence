package sourceCode.view;

import sourceCode.model.database.HighscoreInfo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PopupShowHighscores extends JFrame {

    private JPanel highscore1;
    private JPanel highscore2;
    private JPanel buttonPanel;
    private JTextArea idArea1;
    private JTextArea playerArea1;
    private JTextArea timeArea1;
    private JTextArea idArea2;
    private JTextArea playerArea2;
    private JTextArea timeArea2;
    private JButton playAgain;
    private JButton quit;
    //private JTextField map1;
    private JLabel map1;
    private JLabel map2;

    public PopupShowHighscores(String s) {
        super(s);
        setSize(380, 500);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        add(buildHighscorePanel1());
        add(buildHighscorePanel2());
        add(buildButtonPanel(), BorderLayout.SOUTH);
        setVisible(true);

        //highscore1.setBackground(Color.DARK_GRAY);
        //highscore2.setBackground(Color.DARK_GRAY);

    }

    private JPanel buildHighscorePanel1() {
        highscore1 = new JPanel();
        highscore1.setLayout(new BorderLayout());
        idArea1 = new JTextArea();
        idArea1.setColumns(2);
        playerArea1 = new JTextArea();
        playerArea1.setColumns(10);
        timeArea1 = new JTextArea();
        //map1 = new JTextField("Map1");
        map1 = new JLabel("Map1");
        //map1.setEditable(false);
        idArea1.setEditable(false);
        playerArea1.setEditable(false);
        timeArea1.setEditable(false);
        highscore1.add(map1, BorderLayout.NORTH);
        highscore1.add(idArea1, BorderLayout.WEST);
        highscore1.add(playerArea1, BorderLayout.CENTER);
        highscore1.add(timeArea1, BorderLayout.EAST);

        return highscore1;
    }

    private JPanel buildHighscorePanel2() {
        highscore2 = new JPanel();
        highscore2.setLayout(new BorderLayout());
        idArea2 = new JTextArea();
        idArea2.setColumns(2);
        playerArea2 = new JTextArea();
        playerArea2.setColumns(10);
        timeArea2 = new JTextArea();
        map2 = new JLabel("Map2");
        idArea2.setEditable(false);
        playerArea2.setEditable(false);
        timeArea2.setEditable(false);
        highscore2.add(map2, BorderLayout.NORTH);
        highscore2.add(idArea2, BorderLayout.WEST);
        highscore2.add(playerArea2, BorderLayout.CENTER);
        highscore2.add(timeArea2, BorderLayout.EAST);

        return highscore2;
    }

    private JPanel buildButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        playAgain = new JButton("Play");
        quit = new JButton("Quit");

        buttonPanel.add(playAgain);
        buttonPanel.add(quit);

        return buttonPanel;
    }

    public void setColumns() {
        idArea1.append("ID\n\n");
        playerArea1.append("PLAYER\n\n");
        timeArea1.append("TIME\n\n");

        idArea2.append("ID\n\n");
        playerArea2.append("PLAYER\n\n");
        timeArea2.append("TIME\n\n");
    }

    public void showHighscores(List<HighscoreInfo> list, String map) {
        if (map.equals("map1")) {
            for (int i = 0; i < list.size(); i++) {
                idArea1.append(String.valueOf(i+1));
                playerArea1.append(list.get(i).getPlayer());
                timeArea1.append(String.valueOf(list.get(i).getFinishTime()));
                if (i < 9) {
                    idArea1.append("\n");
                    playerArea1.append("\n");
                    timeArea1.append("\n");
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                idArea2.append(String.valueOf(i+1));
                playerArea2.append(list.get(i).getPlayer());
                timeArea2.append(String.valueOf(list.get(i).getFinishTime()));
                if (i < 9) {
                    idArea2.append("\n");
                    playerArea2.append("\n");
                    timeArea2.append("\n");
                }
            }
        }
    }

    public void clear(String map) {
        if (map.equals("map1")) {
            idArea1.setText(null);
            playerArea1.setText(null);
            timeArea1.setText(null);
        } else {
            idArea2.setText(null);
            playerArea2.setText(null);
            timeArea2.setText(null);
        }
    }

    public void addActionListener(ActionListener e, String s) {
        if (s.equals("quit")) {
            quit.addActionListener(e);
        } else {
            playAgain.addActionListener(e);
        }
    }
}
