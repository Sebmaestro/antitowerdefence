package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Author: Simon Lundkvist / Sebastian Arledal
 * 2019-01-21
 * Class to represent the button panel during the game session,
 * containing the buttons for sending troops and displaying
 * various information such as credits and time.
 */
public class ButtonPanel extends JPanel {
    private JButton troop1, troop2, troop3, teleportButton;
    private JTextField moneyField;
    private JTextField goalCounter;
    private JTextField timer;

    /**
     * Constructor: calls the define method to initialize the panel and its fields.
     */
    ButtonPanel() {
        define();
    }

    /**
     * define: Initializes the panel and its fields.
     */
    private void define() {

        troop1 = new JButton("Regular - $100");
        troop2 = new JButton("Teleport - $700");
        troop3 = new JButton("Tank - $300");
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
        add(troop3);
        add(goalCounter);

        add(timer);
    }

    /**
     * addActionListener: adds an ActionListener to a troop button.
     * @param e An ActionListener that will be used
     * @param troop The troop button which the listener will be set to.
     */
    public void addActionListener(ActionListener e, String troop) {
        if (troop.equals("Regular")) {
            troop1.addActionListener(e);
        } else if (troop.equals("Teleport")) {
            troop2.addActionListener(e);
        } else {
            troop3.addActionListener(e);
        }
    }

    /**
     * addSetTeleportListener: adds an ActionListener to the Set Teleport button
     * @param e An ActionListener
     */
    public void addSetTeleportListener(ActionListener e) {
        teleportButton.addActionListener(e);
    }

    /**
     * setMoneyField: sets the money field to a new value
     * @param money The value to set the field to
     */
    public void setMoneyField(int money) {
        moneyField.setText("Credits: $"+money);
    }

    /**
     * setGoalCounter: sets the goal counter to a new value
     * @param goalCounter the value to set the goal counter to
     */
    public void setGoalCounter(int goalCounter) {
        this.goalCounter.setText(goalCounter+"/20 troops in goal");
    }

    /**
     * setTimer: sets the timer to a new value
     * @param time the value to set the timer to
     */
    public void setTimer(Long time) {
        timer.setText("Time: "+time);
    }
}
