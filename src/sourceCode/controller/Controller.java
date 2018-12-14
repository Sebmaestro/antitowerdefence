package sourceCode.controller;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;
import sourceCode.view.Frame;
import sourceCode.view.Overlay;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    private Frame frame;
    private Model model;
    private Tile[][] tiles;
    private LevelParser levelP;
    private BufferedImage[][] allBufferimg;
    private String[][] stringPaths;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition;
    private Position startPos, goalPos;


    public Controller() throws IOException {
        int height = 700;
        int width = 1080;

        //startGame("src/Resources/testLevel.xml");
       // imgArr = new ImageArray();
        levelP = new LevelParser();
        tiles = levelP.xmlparser("src/Resources/testlevel.xml");
        pathPosition = levelP.getPathPositions();
        imgArr = new ImageArray(tiles);
        overlayimgArr = new OverlayImageArray(tiles.length);
        frame = new Frame(imgArr.getTheWholeShit(), overlayimgArr.getTheWholeShit());


        startPos = levelP.getStartPos();
        goalPos = levelP.getGoalPos();
        overlayimgArr.clearThePath(pathPosition,startPos, goalPos);
        overlayimgArr.changeImage();









    }

    //Calls all methods to start the gameScreen
    public void startGame(String xmlLevel){

    }

    private void getXMLLevels(String xmlLevel){
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
