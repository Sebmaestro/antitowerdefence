package sourceCode.controller;
import java.util.concurrent.TimeUnit;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.tile.Tile;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
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
    private ArrayList<Position> troopPosition;
    private ArrayList<RegularTroop> regularTroops;


    public Controller() throws IOException {
        int height = 700;
        int width = 1080;

        //startGame("src/Resources/testLevel.xml");
       // imgArr = new ImageArray();

        //Inläsning
        levelP = new LevelParser();
        tiles = levelP.xmlparser("src/Resources/testlevel.xml");
        pathPosition = levelP.getPathPositions();
        startPos = levelP.getStartPos();
        goalPos = levelP.getGoalPos();

        //Skapar BufferedImageArrays
        imgArr = new ImageArray(tiles);
        overlayimgArr = new OverlayImageArray(tiles.length);
        overlayimgArr.addPaths(pathPosition, startPos, goalPos);

        //Skapar en frame med BufferedImageArrays
        frame = new Frame();
        System.out.println("mammi");
        frame.getScreen().setImages(imgArr.getTheWholeShit(), overlayimgArr.getTheWholeShit());


        //Skapar en trupp och lägger in den i listan
        regularTroops = new ArrayList<>();
        RegularTroop reg = new RegularTroop(startPos, Direction.EAST);
        regularTroops.add(reg);

        //Lägger till truppen i listan hos overlayImage-klassen
        overlayimgArr.addRegularTroopList(regularTroops);


        //frame.getScreen().repaint();

        //Loopar spelet
        gameLoop();
    }

    public void gameLoop(){

        RegularTroop reg = regularTroops.get(0);
        frame.getScreen().repaint();

        overlayimgArr.updateImage();
        frame.getScreen().repaint();

        reg.move(tiles);

        overlayimgArr.updateImage();



/*
        int j =0;

        while(j < 100000000 && !reg.isGoalReached()) {

            if (j > 100000) {
                reg.move(tiles);
                overlayimgArr.updateImage();
                j = 0;


                //frame.getScreen().updateOverlay(overlayimgArr.getTheWholeShit());
            }
            System.out.println("mammaGame");
            j++;
        }

*/

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
