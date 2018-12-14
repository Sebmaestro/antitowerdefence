package sourceCode.view;

import javax.swing.*;

public class ButtonPanel extends JPanel {
    JButton troop1, troop2, troop3;
    public ButtonPanel() {
        define();
    }
    public void define() {
        troop1 = new JButton("Regular");
        troop2 = new JButton("Teleport");
        troop3 = new JButton("Mamma");
        add(troop1);
        add(troop2);
        add(troop3);

    }
}
