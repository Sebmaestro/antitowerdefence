package sourceCode.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import sourceCode.model.*;


import sourceCode.model.Model;
import sourceCode.model.credit.Credit;
import sourceCode.model.tile.Tile;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
import sourceCode.view.Frame;
import sourceCode.view.Overlay;
import sourceCode.view.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static sourceCode.model.troop.Direction.EAST;

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
    private ArrayList<Troop> regularTroops;
    private ArrayList<Troop> troopsToKill;

    private BufferedImage[][] underlay, overlay;

    private final Object troopListLock = new Object();

    Credit money = new Credit();

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

        //sätter dessa bilder
        underlay = copyOff(imgArr.getTheWholeShit());
        overlay = copyOff(overlayimgArr.getTheWholeShit());

        //Skapar en frame med BufferedImageArrays
        frame = new Frame();
        frame.addScreen();
        frame.addButtonPanel();
        frame.getScreen().setImages(underlay, overlay);
        setRegularTroopListener();

        frame.getScreen().createGameScreen();


        //Skapar en trupp och lägger in den i listan
        regularTroops = new ArrayList<>();

        RegularTroop reg = new RegularTroop(startPos, EAST);
        regularTroops.add(reg);


        /*
        RegularTroop reg2 = new RegularTroop(startPos, Direction.EAST);
        reg2.setPosition(new Position(2,3));
        regularTroops.add(reg2);
        */



        //Lägger till truppen i listan hos overlayImage-klassen
        overlayimgArr.addRegularTroopList(regularTroops);





        //Loopar spelet
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {


                gameLoop();

                return null;
            }


        };

        worker.execute();

    }

    public void gameLoop() {


        double time = System.nanoTime();

        while(true) {


            try {
                SwingUtilities.invokeAndWait(() -> {

                  

                    frame.getButtonPanel().setMoneyField(money.getCredits());
                    overlayimgArr.updateImage();
                    frame.getScreen().updateOverlay(copyOff(overlayimgArr.getTheWholeShit()));
                    frame.getScreen().repaint();

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    removeTroops();

                    moveTroops();

                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    public void removeTroops(){
        Iterator<Troop> iter = regularTroops.iterator();
        synchronized (troopListLock) {
            while(iter.hasNext()){
                Troop reg = iter.next();
                if(reg.isGoalReached()){
                    iter.remove();
                    money.getGoalCredits();
                }
            }

        }
    }

    public void moveTroops(){
        synchronized (troopListLock) {
            if(regularTroops.size() > 0) {
                for (Troop reg : regularTroops) {
                    reg.move(tiles);
                }
            }
        }
    }


    public static BufferedImage[][] copyOff(BufferedImage[][] original){

        BufferedImage[][] copy = new BufferedImage[original.length][original.length];

        for(int i=0; i<original.length; i++){
            for(int j=0; j<original.length; j++){
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }

    //Calls all methods to start the gameScreen
    public void startGame(String xmlLevel){

    }

    private void getXMLLevels(String xmlLevel){
    }

    public void setRegularTroopListener(){
        frame.getButtonPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (money.getCredits() >= 100) {
                    Troop reg = new RegularTroop(startPos, EAST);
                    regularTroops.add(reg);
                    money.buyNewTroop(reg);
                }

            }
        }, "Regular");
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
