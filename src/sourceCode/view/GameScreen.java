package sourceCode.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

/**
 * Created by denni on 2018-12-11.
 */
public class GameScreen {

    private JPanel gameScreenJPanel;
    private static String DEFAULT_IMG = "src/Resources/atd.jpg";
    private BufferedImage levelBufferImg = null;
    private BufferedImage allBufferImg[][];

    /**
     * Starts the gameScreen
     * @param ml
     * @param defaultImage
     */
    public GameScreen(MouseListener ml, String defaultImage){
        levelBufferImg = getImage(defaultImage);


        if(levelBufferImg == null){
            System.out.println("ska inte komma hit");
            levelBufferImg = getImage(DEFAULT_IMG);

        }

        gameScreenJPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                drawTheLevel(g);
            }
        };

        gameScreenJPanel.setBackground(Color.DARK_GRAY);

    }

    /**
     * Starts the GameScreen with an image
     * @param ml
     */
    public GameScreen(MouseListener ml){
        this(ml, DEFAULT_IMG);
    }

    /**
     * Returns the gameScreen as a JPanel to be showed on the mainframe
     * @return
     */
    public JPanel getJpanel(){
        return gameScreenJPanel;
    }

    /**
     * Draws the level
     */
    private void drawTheLevel(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.drawImage(levelBufferImg, 0, 0, null);
    }

    /**
     * Loads the image from the resource map. Returns null if Exception
     * appears.
     * @param imagePath
     * @return
     */
    private BufferedImage getImage(String imagePath){
        System.out.println(imagePath);
        BufferedImage img;
        File file = new File(imagePath);
        try{
            img = ImageIO.read(file);
        }catch (IllegalArgumentException | IOException e){
            System.out.println(e);
            img = null;
        }

        return img;
    }

    public void setAllBufferImg(BufferedImage[][] bfg){

        allBufferImg = bfg;
    }
}
