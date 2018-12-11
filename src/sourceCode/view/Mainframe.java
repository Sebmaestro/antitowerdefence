package sourceCode.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * Created by denni on 2018-12-11.
 */
public class Mainframe {
    private JFrame frame;
    private JPanel upper;
    private JPanel down;
    private JPanel center;
    private JPanel right;
    private GameScreen gameScreen;
    private MouseListener mouseListener = new MouseListenerClass();

    private static Mainframe mainframeinstance = null;

    private Mainframe(){

    }

    public static Mainframe getInstance(){
        mainframeinstance = new Mainframe("New MammaGame", 800, 600);

        return mainframeinstance;
    }


    /**
     *
     * @param title
     * @param width
     * @param height
     */
    private Mainframe(String title, int width, int height){
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame(title);
            frame.setLayout(new BorderLayout());
            frame.setMaximumSize(new Dimension(width,height));
            frame.setPreferredSize(new Dimension(width, height));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            gameScreen = new GameScreen(mouseListener);

            //Build all the panels
            center = gameScreen.getJpanel();



            frame.add(center, BorderLayout.CENTER);

            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.pack();



            frame.setVisible(true);

        });



    }
}
