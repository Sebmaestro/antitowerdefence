package sourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PopupNewHighscoreSetter extends JFrame {
    private JButton submit;
    private JTextField textField;
    private JTextArea textArea;
    public PopupNewHighscoreSetter() {
        super("New Highscore!");
        setSize(400, 250);
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        JPanel topPanel = new JPanel();

        panel.setLayout(new FlowLayout());

        textArea = new JTextArea("Congratulations! You have set a new highscore!" +"\n\n"+ "Please enter your name:" +
                "(MAX 10 CHARACTERS)");
        textArea.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        textArea.setSize(new Dimension(200, 200));
        textArea.setEditable(false);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30));
        submit = new JButton("Submit");

        topPanel.add(textArea);
        panel.add(textField);
        panel.add(submit);

        add(topPanel);
        add(panel);

        //setLocationRelativeTo(null);
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
