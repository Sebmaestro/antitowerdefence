package sourceCode.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import sourceCode.model.*;
import sourceCode.model.Model;
import sourceCode.model.credit.Credit;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;
import sourceCode.model.logic.Game;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.Troop;
//import sourceCode.model.xmlparser.LevelParser;
import sourceCode.model.xmlparser.Levels;
import sourceCode.view.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static sourceCode.model.logic.Game.copyOff;

public class Controller {
    private MainFrame mainFrame;
    private Model model;
    private Tile[][] tiles;
    //private LevelParser levelP;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition, towerPosition, quicksandPositions,
            boosterPositions, switchUpPositions, switchDownPositions;
    private Position startPos, goalPos;
    private ArrayList<Troop> regularTroops;
    private ArrayList<Tower> towers;
    private int goalCounter = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();

    private PopupShowHighscores popupShowHighscores;
    private PopupNewHighscoreSetter newHighscore;
    private Database db;
    private HighscoreHandler handler;
    private StartMenuFrame start;
    private Game g;

    private boolean gameWon = false;
    private boolean wasSet = false;
    private boolean gameDone = false;

    private long elapsedSeconds;

    private ArrayList<LaserPositions> laserPosList;

    private ArrayList<Levels> levelList;

    //private int gameWon = 0;
    private Credit money;


    public Controller() throws IOException {
        db = new Database();
        g = new Game();
        levelList = new ArrayList<>();
        //mainFrame = new MainFrame(g.getOverlay(), g.getUnderlay());

        //g.init();


        start = new StartMenuFrame();
        setStartmenuQuitButtonListener();
        setMap1Listener();
        setMap2Listener();
        setHighscoreListener();

        //g.init();
        //money = new Credit();
        //db = new Database();
        //handler = new HighscoreHandler(db.getHighscores("map2"));
        //newHighscore = new PopupNewHighscoreSetter();
        //popupShowHighscores = new PopupShowHighscores("map2");
        //mainFrame = new MainFrame();

        /*
        setSubmitButtonListener();
        setQuitButtonListener();
        setRegularTroopListener();
        */
    }

    public void initGame(){
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
        long startTime = System.currentTimeMillis();

        while(!gameDone) {
            try {
                SwingUtilities.invokeAndWait(() -> {


                    mainFrame.getButtonPanel().setGoalCounter(g.getGoalCounter());
                    mainFrame.getButtonPanel().setMoneyField(g.getMoney());
                    g.getOverlayimgArr().updateImage();
                    mainFrame.getScreen().updateOverlay(copyOff(g.getOverlayimgArr().getTheWholeShit()));
                    mainFrame.getScreen().repaint();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    laserPosList = g.shootTroops();
                    g.removeTroops();
                    g.moveTroops();
                    mainFrame.getScreen().getLaser().setPositons(laserPosList);
                    mainFrame.getScreen().getLaser().setLasers();
                    mainFrame.getScreen().drawLaser();

                    //Här uppdaterar vi vyn

                    if (g.getGoalCounter() > 1) {
                        if (!gameWon) {
                            if (handler.getList().isEmpty() || (handler.getTimeAtEndOfList() > (int)elapsedSeconds)) {
                                newHighscore = new PopupNewHighscoreSetter();
                                setSubmitButtonListener();
                            }


                            popupShowHighscores = new PopupShowHighscores("Highscores!");
                            popupShowHighscores.setColumns();
                            popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
                            popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
                            gameWon = true;
                            gameDone = true;
                            mainFrame.dispose();
                            if (!wasSet) {
                                setPlayagainListener();
                                setQuitButtonListener();
                                //wasSet = true;
                            }
                        }
                    }
                });
            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            elapsedSeconds = elapsedTime / 1000;
            mainFrame.getButtonPanel().setTimer(elapsedSeconds);
        }
    }

    public void setPlayagainListener() {
        popupShowHighscores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.dispose();
                start = new StartMenuFrame();
                popupShowHighscores.dispose();
                setHighscoreListener();
                setMap1Listener();
                setMap2Listener();
            }
        }, "play");
    }

    public void setStartmenuQuitButtonListener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, "quit");
    }

    public void setMap1Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.dispose();
                levelList = g.getLevelsArrayList();
                g.setLevel("Level 1");
                mainFrame = new MainFrame(g.getUnderlay(), g.getOverlay());
                gameDone = false;
                initGame();
                setRegularTroopListener();
                gameWon = false;
                g.resetGame();
                handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
            }
        }, "map1");
    }

    public void setMap2Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.dispose();
                levelList = g.getLevelsArrayList();
                g.setLevel("Level 2");
                mainFrame = new MainFrame(g.getUnderlay(), g.getOverlay());
                gameDone = false;
                initGame();
                setRegularTroopListener();
                setTeleporterTroopListener();
                g.resetGame();
                gameWon = false;
                handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
            }
        }, "map2");
    }

    public void setHighscoreListener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupShowHighscores = new PopupShowHighscores("Highscore");
                popupShowHighscores.setColumns();
                //db = new Database();
                //handler = new HighscoreHandler(db.getHighscores("map1"));
                //handler.checkAndInsertHighscore(new HighscoreInfo("Simon", 40));
                //handler.checkAndInsertHighscore(new HighscoreInfo("dunkarn", 20));
                //db.saveHighscores(handler.getList(), "map1");
                popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
                popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
                start.dispose();
                if (!wasSet) {
                    setPlayagainListener();
                    //wasSet = true;
                }
                setQuitButtonListener();
            }
        }, "highscore");
    }

    public void setSubmitButtonListener() {
        newHighscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //handler.checkAndInsertHighscore(new HighscoreInfo(newHighscore.getTextfieldInfo(), 5));
                //popupShowHighscores.clear();
                //popupShowHighscores.setColumns();
                //popupShowHighscores.showHighscores(handler.getList());
                //db.saveHighscores(handler.getList(), "Map2");
                //newHighscore.dispose();
                handler.checkAndInsertHighscore(new HighscoreInfo(newHighscore.getTextfieldInfo(), (int)elapsedSeconds));
                newHighscore.dispose();
                db.saveHighscores(handler.getList(), g.getCurrentLevelname());
                popupShowHighscores.dispose();
                popupShowHighscores = new PopupShowHighscores("halloj");
                popupShowHighscores.setColumns();
                popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
                popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
                setPlayagainListener();
                setQuitButtonListener();
            }
        });
    }

    public void setQuitButtonListener() {
        popupShowHighscores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, "quit");
    }

    public void setRegularTroopListener(){
        mainFrame.getButtonPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.sendRegularTroop();

            }
        }, "Regular");
    }

    public void setTeleporterTroopListener(){
        mainFrame.getButtonPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.sendTeleporterTroop();

            }
        }, "Teleport");
    }
}

