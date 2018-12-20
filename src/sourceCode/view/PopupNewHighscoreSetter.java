package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Author: Sebastian Arledal
 */
public class PopupNewHighscoreSetter extends JFrame {
    private JButton submit;
    private JTextField textField;

    public PopupNewHighscoreSetter() {
        super("New Highscore!");
        setSize(400, 250);
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        JPanel topPanel = new JPanel();

        panel.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea("Congratulations! You have set a new highscore!" + "\n\n" + "Please enter your name:" +
                "(MAX 18 CHARACTERS)");
        textArea.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        textArea.setSize(new Dimension(200, 200));
        textArea.setEditable(false);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(180, 30));
        submit = new JButton("Submit");

        topPanel.add(textArea);
        panel.add(textField);
        panel.add(submit);

        add(topPanel);
        add(panel);

        getRootPane().setDefaultButton(submit);

        setVisible(true);
    }

    public void addActionListener(ActionListener e) {
        submit.addActionListener(e);
    }

    public String getTextfieldInfo() {
        return textField.getText();
    }
}
