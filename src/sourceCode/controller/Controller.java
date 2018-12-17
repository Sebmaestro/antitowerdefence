package sourceCode.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
import sourceCode.view.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import static sourceCode.model.troop.Direction.EAST;

public class Controller {
    private MainFrame mainFrame;
    private Model model;
    private Tile[][] tiles;
    private LevelParser levelP;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition, towerPosition, quicksandPositions,
            boosterPositions, switchUpPositions, switchDownPositions;
    private Position startPos, goalPos;
    private ArrayList<Troop> regularTroops;
    private ArrayList<Tower> towers;
    private ArrayList<LaserPositions> laserPositionList;
    private int goalCounter = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();

    private PopupFrame popupFrame;
    private PopupHighscoreFrame newHighscore;
    private Database db;
    private HighscoreHandler handler;
    private StartMenuFrame start;
    private Game g;

    //private int gameWon = 0;
    private Credit money;


    public Controller() throws IOException {
        g = new Game();
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
        //newHighscore = new PopupHighscoreFrame();
        //popupFrame = new PopupFrame("map2");
        //mainFrame = new MainFrame();

        /*
        setSubmitButtonListener();
        setQuitButtonListener();
        setRegularTroopListener();
        */
    }

    public void setPlayagainListener() {
        popupFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Kör igen
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
                //g.init();
            }
        }, "map1");
    }

    public void setMap2Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Välj xml för andra mappen och starta spelet
            }
        }, "map2");
    }

    public void setHighscoreListener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupFrame = new PopupFrame("Highscore");
                popupFrame.setColumns();
                db = new Database();
                //handler = new HighscoreHandler(db.getHighscores("map1"));
                //handler.checkAndInsertHighscore(new HighscoreInfo("Simon", 40));
                //handler.checkAndInsertHighscore(new HighscoreInfo("dunkarn", 20));
                //db.saveHighscores(handler.getList(), "map1");
                popupFrame.showHighscores(db.getHighscores("map2"), "map2");
                popupFrame.showHighscores(db.getHighscores("map1"), "map1");
            }
        }, "highscore");
    }

    /*
    public void setSubmitButtonListener() {
        newHighscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.checkAndInsertHighscore(new HighscoreInfo(newHighscore.getTextfieldInfo(), 5));
                popupFrame.clear();
                popupFrame.setColumns();
                popupFrame.showHighscores(handler.getList());
                db.saveHighscores(handler.getList(), "Map2");
                newHighscore.dispose();
            }
        });
    }
    */

    public void setQuitButtonListener() {
        popupFrame.addActionListener(new ActionListener() {
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
                if (money.getCredits() >= 100) {
                    Troop reg = new RegularTroop(startPos, EAST);
                    regularTroops.add(reg);
                    money.buyNewTroop(reg);
                }

            }
        }, "Regular");
    }
}

