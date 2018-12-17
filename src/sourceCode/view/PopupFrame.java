package sourceCode.view;

import sourceCode.model.database.HighscoreInfo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PopupFrame extends JFrame {

    private JPanel highscore;
    private JPanel buttonPanel;
    private JTextArea idArea;
    private JTextArea playerArea;
    private JTextArea timeArea;
    private JButton playAgain;
    private JButton quit;

    public PopupFrame(String s) {
        super(s);
        setSize(300, 380);

        add(buildHighscorePanel(), BorderLayout.CENTER);
        add(buildButtonPanel(), BorderLayout.SOUTH);
        setVisible(true);

        highscore.setBackground(Color.DARK_GRAY);

    }

    private JPanel buildHighscorePanel() {
        highscore = new JPanel();
        highscore.setLayout(new FlowLayout());
        idArea = new JTextArea();
        playerArea = new JTextArea();
        timeArea = new JTextArea();
        idArea.setEditable(false);
        playerArea.setEditable(false);
        timeArea.setEditable(false);
        highscore.add(idArea);
        highscore.add(playerArea);
        highscore.add(timeArea);

        return highscore;
    }

    private JPanel buildButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        playAgain = new JButton("Play again");
        quit = new JButton("Quit");

        buttonPanel.add(playAgain);
        buttonPanel.add(quit);

        return buttonPanel;
    }

    public void setColumns() {
        idArea.append("ID\n\n");
        playerArea.append("PLAYERNAME\n\n");
        timeArea.append("TIME\n\n");
    }

    public void showHighscores(List<HighscoreInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            idArea.append(String.valueOf(i+1));
            playerArea.append(list.get(i).getPlayer());
            timeArea.append(String.valueOf(list.get(i).getFinishTime()));
            if (i < 9) {
                idArea.append("\n");
                playerArea.append("\n");
                timeArea.append("\n");
            }
        }
    }

    public void clear() {
        idArea.setText(null);
        playerArea.setText(null);
        timeArea.setText(null);
    }

    public void addActionListener(ActionListener e, String s) {
        if (s.equals("quit")) {
            quit.addActionListener(e);
        } else {
            playAgain.addActionListener(e);
        }
    }
}
