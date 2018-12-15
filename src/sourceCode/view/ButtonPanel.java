package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton troop1, troop2, troop3;
    private JTextField moneyField;
    public ButtonPanel() {
        define();
    }
    public void define() {
        troop1 = new JButton("Regular - $100");
        troop2 = new JButton("Teleport - $700");
        troop3 = new JButton("Mamma - Free");
        moneyField = new JTextField();
        moneyField.setPreferredSize(new Dimension(120,30));
        moneyField.setEditable(false);
        add(moneyField);
        add(troop1);
        add(troop2);
        add(troop3);
    }

    public void addActionListener(ActionListener e, String troop) {
        if (troop.equals("Regular")) {
            troop1.addActionListener(e);
        } else if (troop.equals("Teleport")) {
            troop2.addActionListener(e);
        } else {
            troop3.addActionListener(e);
        }
    }
    public void setMoneyField(int money) {
        moneyField.setText("Credits: $"+money);
    }
}
