package sourceCode.controller;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;
import sourceCode.view.Frame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    private Frame frame;
    private Model model;
    private Tile[][] tiles;
    private LevelParser levelP;
    private BufferedImage[][] allBufferimg;
    private String[][] stringPaths;
    ImageArray imgArr;

    public Controller() throws IOException {
        int height = 700;
        int width = 1080;

        //startGame("src/Resources/testLevel.xml");
       // imgArr = new ImageArray();
        frame = new Frame();

    }

    //Calls all methods to start the gameScreen
    public void startGame(String xmlLevel){
        //mainframe = Mainframe.getInstance();

       // getXMLLevels(xmlLevel);


    }

    private void getXMLLevels(String xmlLevel){
        try{
            //tiles = new LevelParser().xmlparser(xmlLevel);

           // gameScreen.setAllBufferImg(tiles);
        }catch (Exception e){
        }
    }

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

}
