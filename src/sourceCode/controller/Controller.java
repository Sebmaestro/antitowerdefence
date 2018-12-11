package sourceCode.controller;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.Tile.Tile;
import sourceCode.model.Xmlparser.LevelParser;
import sourceCode.view.Mainframe;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {
    private Frame frame;
    private Model model;
    private Mainframe mainframe;
    private Tile[][] tiles;
    private LevelParser levelP;

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
        }catch (Exception e){
        }
    }

}
