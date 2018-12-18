package sourceCode.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import sourceCode.model.*;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;
import sourceCode.model.logic.Game;
import sourceCode.model.xmlparser.Levels;
import sourceCode.view.*;

import javax.swing.*;
import java.io.IOException;

import static sourceCode.model.logic.Game.copyOff;

/**
 *
 */
public class Controller {
    private MainFrame mainFrame;

    private PopupShowHighscores popupShowHighscores;
    private PopupNewHighscoreSetter newHighscore;

    private Database db;
    private HighscoreHandler handler;

    private StartMenuFrame start;

    private Game g;

    private boolean gameWon = false;
    private boolean gameDone = false;
    private boolean isPaused = false;
    private boolean restartPressed = false;

    private long elapsedSeconds;

    private ArrayList<LaserPositions> laserPosList;

    private ArrayList<Levels> levelList;

    /**
     *
     * @throws IOException
     */
    public Controller() throws IOException {
        db = new Database();
        g = new Game();
        levelList = new ArrayList<>();


        start = new StartMenuFrame();
        setStartmenuQuitButtonListener();
        setMap1Listener();
        setMap2Listener();
        setHighscoreListener();
    }

    private void initGame(){
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

    private void gameLoop() {
        long startTime = System.currentTimeMillis();

        gameDone = false;
        restartPressed = false;
        while(!gameDone) {
            try {
                SwingUtilities.invokeAndWait(() -> {

                    if (!isPaused) {

                    }
                    mainFrame.getButtonPanel().setGoalCounter(g.getGoalCounter());
                    mainFrame.getButtonPanel().setMoneyField(g.getMoney());
                    g.getOverlayimgArr().updateImage();
                    mainFrame.getScreen().updateOverlay(copyOff(g.getOverlayimgArr().getTheWholeShit()));
                    mainFrame.getScreen().repaint();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    laserPosList = g.shootTroops();
                    g.removeTroops();
                    g.moveTroops();
                    mainFrame.getScreen().getLaser().setPositons(laserPosList);
                    mainFrame.getScreen().getLaser().setLasers();
                    mainFrame.getScreen().drawLaser();

                    if (g.getGoalCounter() > 1) {
                        if (!gameWon) {
                            if (handler.getList().isEmpty() || !handler.listFull()
                                   || (handler.getTimeAtEndOfList() > (int)elapsedSeconds)) {
                                newHighscore = new PopupNewHighscoreSetter();
                                setSubmitButtonListener();
                            }


                            popupShowHighscores = new PopupShowHighscores("Highscores!");
                            popupShowHighscores.setColumns();
                            popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
                            popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
                            gameWon = true;
                            gameDone = true;
                            mainFrame.getGameMenu().setRestartNewGameText("New Game");
                            setPlayagainListener();
                            setQuitButtonListener();
                        }
                    } else if (restartPressed) {

                        mainFrame.dispose();
                        levelList = g.getLevelsArrayList();
                        g.setLevel(g.getCurrentLevelname());
                        mainFrame = new MainFrame(g.getUnderlay(), g.getOverlay());
                        gameDone = true;

                    }
                });


            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            elapsedSeconds = elapsedTime / 1000;
            mainFrame.getButtonPanel().setTimer(elapsedSeconds);
        }
        if(restartPressed){

            initGame();
            setRegularTroopListener();
            setMenuQuitListener();
            setAboutListener();
            setHelpListener();
            setRestartListener();
            g.resetGame();
            handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
            mainFrame.getGameMenu().setRestartNewGameText("Restart");
        }
    }

    private void setPlayagainListener() {
        popupShowHighscores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainFrame != null){
                    mainFrame.dispose();
                }
                if (start != null) {
                    start.dispose();
                }
                start = new StartMenuFrame();
                popupShowHighscores.dispose();
                setHighscoreListener();
                setMap1Listener();
                setMap2Listener();
                setStartmenuQuitButtonListener();
            }
        }, "play");
    }

    private void setStartmenuQuitButtonListener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, "quit");
    }

    private void setMap1Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.dispose();
                levelList = g.getLevelsArrayList();
                g.setLevel("Level 1");
                initMainframeAndSetListeners();
                setAboutListener();
                setRestartListener();
                mainFrame.getGameMenu().setRestartNewGameText("Restart");
                gameWon = false;
                g.resetGame();
                handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
            }
        }, "map1");
    }

    private void setMap2Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.dispose();
                levelList = g.getLevelsArrayList();
                g.setLevel("Level 2");
                initMainframeAndSetListeners();
                setRestartListener();
                mainFrame.getGameMenu().setRestartNewGameText("Restart");
                g.resetGame();
                gameWon = false;
                handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
            }
        }, "map2");
    }

    private void setHighscoreListener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupShowHighscores = new PopupShowHighscores("Highscore");
                popupShowHighscores.setColumns();
                popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
                popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
                start.dispose();
                setPlayagainListener();
                setQuitButtonListener();
            }
        }, "highscore");
    }

    private void setSubmitButtonListener() {
        newHighscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private void setQuitButtonListener() {
        popupShowHighscores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, "quit");
    }

    private void setRegularTroopListener(){
        mainFrame.getButtonPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.sendTroop();

            }
        }, "Regular");
    }

    private void setMenuQuitListener() {
        mainFrame.getGameMenu().setQuitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(mainFrame,
                        "Are you sure you want to exit?", "Confirm exit",
                        JOptionPane.YES_NO_OPTION);

                if(choice == JOptionPane.YES_OPTION) {
                    mainFrame.dispose();
                    start = new StartMenuFrame();
                    setHighscoreListener();
                    setMap1Listener();
                    setMap2Listener();
                    setStartmenuQuitButtonListener();
                }
            }
        });
    }

    private void setAboutListener() {
        mainFrame.getGameMenu().setAboutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Made by:\n" +
                        "Simon Lundkvist, Sebastian Arledal, Dennis Karlman, David Eriksson","About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

    private void setHelpListener() {
        mainFrame.getGameMenu().setHelpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "The goal is to get 50 troops to reach the goal alive as fast as possible.\n" +
                                "You can send troops by using the buttons on the bottom of the screen.\n" +
                                "Sending a troop costs credits, the cost is displayed on the associated buttons.\n" +
                                "You can view your available credits on the bottom of the screen.\n" +
                                "Every troop that reaches the goal alive will grant you credits.");
            }
        });
    }

    private void setRestartListener() {
        mainFrame.getGameMenu().setRestartListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameDone) {
                    popupShowHighscores.dispose();
                }
                restartPressed = true;
            }
        });
    }

    private void initMainframeAndSetListeners() {
        mainFrame = new MainFrame(g.getUnderlay(), g.getOverlay());
        gameDone = false;
        initGame();
        setRegularTroopListener();
        setMenuQuitListener();
        setAboutListener();
        setHelpListener();
        setRestartListener();
    }
}

