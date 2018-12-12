package sourceCode.controller;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;
import sourceCode.view.GameScreen;
import sourceCode.view.Mainframe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static sourceCode.model.Screen.tileset_ground;

public class Controller {
    private Frame frame;
    private Model model;
    private Mainframe mainframe;
    private Tile[][] tiles;
    private LevelParser levelP;
    private GameScreen gameScreen;
    private BufferedImage[][] allBufferimg;
    private String[][] stringPaths;

    public Controller() throws IOException {
        int height = 700;
        int width = 1080;

        startGame("src/Resources/testLevel.xml");
        // frame = new Frame();

    }

    //Calls all methods to start the gameScreen
    public void startGame(String xmlLevel){
        mainframe = Mainframe.getInstance();

        getXMLLevels(xmlLevel);


    }

    private void getXMLLevels(String xmlLevel){
        try{
            tiles = new LevelParser().xmlparser(xmlLevel);

            tileset_ground[0] = new ImageIcon("src/Resources/grass.png").getImage();
            tileset_ground[1] = new ImageIcon("src/Resources/path.png").getImage();
            tileset_ground[2] = new ImageIcon("src/Resources/towerzone.png").getImage();
            tileset_ground[3] = new ImageIcon("src/Resources/start.png").getImage();
            tileset_ground[4] = new ImageIcon("src/Resources/goal.png").getImage();





            for(int i=0; i<10;i++){
                for(int j=0; j<10; j++){
                    System.out.println(j);
                    if(tiles[i][j].getGraphic().equals("grass")){
                        System.out.println("grass");
                        //allBufferimg[i][j]=getImage("src/Resources/grass.png");
                    }
                    else if(tiles[i][j].getGraphic().equals("path")){
                        System.out.println("path");
                        //allBufferimg[i][j] = getImage("src/Resources/path.png");
                    }
                    else if(tiles[i][j].getGraphic().equals("TowerZone")){
                        System.out.println("towerzone");
                        //allBufferimg[i][j] = getImage("src/Resources/towerzone.png");
                    }
                    else if(tiles[i][j].getGraphic().equals("start")){
                        System.out.println("start");
                        allBufferimg[i][j] = getImage("src/Resources/start.png");
                    }
                    else if(tiles[i][j].getGraphic().equals("goal")){
                        System.out.println("goal");
                        allBufferimg[i][j] = getImage("src/Resources/goal.png");
                    }

                }
            }



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
