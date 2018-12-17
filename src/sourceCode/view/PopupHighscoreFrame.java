package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PopupHighscoreFrame extends JFrame {
    private JButton submit;
    private JTextField player;
    public PopupHighscoreFrame() {
        setSize(400, 400);
        JPanel write = new JPanel();
        write.setLayout(new FlowLayout());
        player = new JTextField();
        player.setPreferredSize(new Dimension(80, 40));
        write.add(player);
        submit = new JButton("Submit");
        write.add(submit);
        add(write);

        getRootPane().setDefaultButton(submit);

        setVisible(true);
    }

    public void addActionListener(ActionListener e) {
        submit.addActionListener(e);
    }

    public String getTextfieldInfo() {
        return player.getText();
    }
}
