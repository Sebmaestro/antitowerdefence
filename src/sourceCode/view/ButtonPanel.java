package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton troop1, troop2, teleportButton;
    private JTextField moneyField;
    private JTextField goalCounter;
    private JTextField timer;

    public ButtonPanel() {
        define();
    }
    public void define() {

        troop1 = new JButton("Regular - $100");
        troop2 = new JButton("Teleport - $700");
        teleportButton = new JButton("Set Teleport");
        moneyField = new JTextField();
        moneyField.setPreferredSize(new Dimension(120,30));
        moneyField.setEditable(false);

        goalCounter = new JTextField();
        goalCounter.setPreferredSize(new Dimension(200,30));
        goalCounter.setEditable(false);

        timer = new JTextField();
        timer.setPreferredSize(new Dimension(100, 30));
        timer.setEditable(false);

        add(moneyField);
        add(teleportButton);
        add(troop1);
        add(troop2);
        add(goalCounter);

        add(timer);
    }

    public void addActionListener(ActionListener e, String troop) {
        if (troop.equals("Regular")) {
            troop1.addActionListener(e);
        } else if (troop.equals("Teleport")) {
            troop2.addActionListener(e);
        }
    }

    public void addSetTeleportListener(ActionListener e) {
        teleportButton.addActionListener(e);
    }

    public void setMoneyField(int money) {
        moneyField.setText("Credits: $"+money);
    }
    public void setGoalCounter(int goalCounter) {
        this.goalCounter.setText(goalCounter+"/50 troops in goal");
    }
    public void setTimer(Long time) {
        timer.setText("Time: "+time);
    }

}
