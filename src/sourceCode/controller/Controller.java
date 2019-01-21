package sourceCode.controller;

import sourceCode.model.LaserPositions;
import sourceCode.model.Position;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;
import sourceCode.model.logic.Game;
import sourceCode.view.MainFrame;
import sourceCode.view.PopupNewHighscoreSetter;
import sourceCode.view.PopupShowHighscores;
import sourceCode.view.StartMenuFrame;
import java.util.Timer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.TimerTask;
import static sourceCode.model.logic.Game.copyOff;

/**
 * Author: Sebastian Arledal / Dennis Karlman / Simon Lundkvist / David Eriksson
 *
 * Class: Controller
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
    private boolean restartPressed;
    private int paused = 0;
    private long startTime;
    private long elapsed;
    private int finishTime;
    private ArrayList<LaserPositions> laserPosList;
    private Timer timer;
    private boolean timerTicker;
    private String currentGame;
    private String xmlName;

    /**
     * Constructor
     */
    public Controller(String s) {
        xmlName = s;
        db = new Database();
        g = new Game(xmlName);


        start = new StartMenuFrame();
        setStartmenuQuitButtonListener();
        setMap1Listener();
        setMap2Listener();
        setHighscoreListener();
    }

    private void initGame(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {

                setSwitchListener();
                gameLoop();
                return null;
            }
        };
        worker.execute();
    }

    private void gameLoop() {
        elapsed = 0;
        finishTime = 0;
        timerTicker = false;
        currentGame = g.getCurrentLevelname();

        scheduleTimeRate();
        startTimer();

        gameDone = false;
        restartPressed = false;

        while (!gameDone) {
            try {
                SwingUtilities.invokeAndWait(() -> {

                    if (!isPaused) {

                        if (timerTicker) {
                            mainFrame.getButtonPanel().setGoalCounter(g.getGoalCounter());
                            mainFrame.getButtonPanel().setMoneyField(g.getMoney());
                            g.getOverlayimgArr().updateImage();
                            mainFrame.getScreen().updateOverlay(copyOff(g.getOverlayimgArr().getTheWholeShit()));
                            mainFrame.getScreen().repaint();

                            laserPosList = g.shootTroops();
                            g.removeTroops();
                            g.moveTroops();
                            mainFrame.getScreen().getLaser().setPositons(laserPosList);
                            mainFrame.getScreen().getLaser().setLasers();
                            mainFrame.getScreen().drawLaser();

                            if (g.getGoalCounter() > 20) {
                                if (!gameWon) {
                                    if (handler.getList().isEmpty() || !handler.listFull()
                                            || (handler.getTimeAtEndOfList() > finishTime)) {
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
                                    setStartMenuListener();
                                    setQuitButtonListener();
                                }
                            }
                        }

                        if (restartPressed) {
                            System.out.println("restartar");

                            timer.cancel();
                            gameDone = true;
                            timer.cancel();
                            isPaused = false;
                        }
                        timerTicker = false;
                    }
                });

            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (!isPaused) {
                mainFrame.getButtonPanel().setTimer(getElapsed());
                getGameTime();
            }

        }
    }

    private void scheduleTimeRate() {
        timer = new Timer();
        TimerTask tasker = new TimerTask() {
            @Override
            public void run() {
                timerTicker = true;
            }
        };

        timer.scheduleAtFixedRate(tasker,0 , 100);
    }

    private void setTeleportButton(){
        mainFrame.getButtonPanel().addSetTeleportListener(e -> {
            if (!isPaused) {
                g.teleport();
            }
        });
    }

    private void setStartMenuListener() {
        popupShowHighscores.addActionListener(e -> {
            if (mainFrame != null){
                mainFrame.dispose();
            }
            if (start != null) {
                start.dispose();
            }
            if (timer != null) {
                timer.cancel();
            }
            start = new StartMenuFrame();
            popupShowHighscores.dispose();
            setHighscoreListener();
            setMap1Listener();
            setMap2Listener();
            setStartmenuQuitButtonListener();
        }, "play");
    }

    private void setSwitchListener(){
        mainFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int mouseX = (e.getX()/55)-4;
                int mouseY = (e.getY()/55)-1;
                ArrayList <Position> allSwitches = g.getSwitchPos();

                for (Position p:allSwitches) {

                    if (mouseX == p.getX() && mouseY == p.getY()){
                        g.changeSwitch(p);

                    }
                }
            }
        });

    }

    private void setStartmenuQuitButtonListener() {
        start.addActionListener(e -> System.exit(0), "quit");
    }

    private void startTimer(){
        startTime = System.currentTimeMillis();
    }

    private void stopTimer(){
        elapsed = elapsed + System.currentTimeMillis() - startTime;
    }

    private long getElapsed(){

            return ((elapsed + System.currentTimeMillis() - startTime)/1000);
    }

    private void getGameTime(){

        finishTime = (int)getElapsed();
    }


    private void setMap1Listener() {
        start.addActionListener(e -> {
            if (newHighscore != null) {
                newHighscore.dispose();
            }
            if (popupShowHighscores != null) {
                popupShowHighscores.dispose();
            }
            start.dispose();
            g = new Game(xmlName);
            g.setLevel("Level 1");
            initMainframeAndSetListeners();
            setRestartListener();
            setPauseListener();
            mainFrame.getGameMenu().setRestartNewGameText("Restart");
            g.resetGame();
            gameWon = false;
            handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
        }, "map1");
    }

    private void setMap2Listener() {
        start.addActionListener(e -> {
            if (newHighscore != null) {
                newHighscore.dispose();
            }
            if (popupShowHighscores != null) {
                popupShowHighscores.dispose();
            }
            start.dispose();
            g = new Game(xmlName);
            g.setLevel("Level 2");
            initMainframeAndSetListeners();
            setRestartListener();
            setPauseListener();
            mainFrame.getGameMenu().setRestartNewGameText("Restart");
            g.resetGame();
            gameWon = false;
            handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
        }, "map2");
    }

    private void setHighscoreListener() {
        start.addActionListener(e -> {
            popupShowHighscores = new PopupShowHighscores("Highscore");
            popupShowHighscores.setColumns();
            popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
            popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
            start.dispose();
            setStartMenuListener();
            setQuitButtonListener();
        }, "highscore");
    }

    private void setSubmitButtonListener() {
        newHighscore.addActionListener(e -> {
            handler.checkAndInsertHighscore(new HighscoreInfo(newHighscore.getTextfieldInfo(), finishTime));
            newHighscore.dispose();
            db.saveHighscores(handler.getList(), g.getCurrentLevelname());
            popupShowHighscores.dispose();
            popupShowHighscores = new PopupShowHighscores("halloj");
            popupShowHighscores.setColumns();
            popupShowHighscores.showHighscores(db.getHighscores("Level 1"), "map1");
            popupShowHighscores.showHighscores(db.getHighscores("Level 2"), "map2");
            setStartMenuListener();
            setQuitButtonListener();
        });
    }

    private void setQuitButtonListener() {
        popupShowHighscores.addActionListener(e -> System.exit(0), "quit");
    }

    private void setRegularTroopListener(){
        mainFrame.getButtonPanel().addActionListener(e -> {
            if(!isPaused) {
                g.sendRegularTroop();
            }

        }, "Regular");
    }

    private void setTankTroopListener() {
        mainFrame.getButtonPanel().addActionListener(e -> {
            if(!isPaused) {
                g.sendTankTroop();
            }
        }, "Tank");
    }

    private void setTeleportTroopListener(){
        mainFrame.getButtonPanel().addActionListener(e -> {
            if(!isPaused) {
                g.sendTeleporterTroop();
            }

        }, "Teleport");
    }

    private void setMenuQuitListener() {
        mainFrame.getGameMenu().setQuitListener(e -> {
            int choice = JOptionPane.showConfirmDialog(mainFrame,
                    "Are you sure you want to exit?", "Confirm exit",
                    JOptionPane.YES_NO_OPTION);

            if(choice == JOptionPane.YES_OPTION) {
                if(popupShowHighscores != null) {
                    popupShowHighscores.dispose();
                }
                stopTimer();
                timer.cancel();
                gameDone = true;
                mainFrame.dispose();
                start = new StartMenuFrame();
                setHighscoreListener();
                setMap1Listener();
                setMap2Listener();
                setStartmenuQuitButtonListener();
            }
        });
    }

    private void setAboutListener() {
        mainFrame.getGameMenu().setAboutListener(e -> JOptionPane.showMessageDialog(null,
                "Made by:\n" +
                "Simon Lundkvist, Sebastian Arledal, Dennis Karlman, David Eriksson","About",
                JOptionPane.INFORMATION_MESSAGE));

    }

    private void setHelpListener() {
        mainFrame.getGameMenu().setHelpListener(e -> JOptionPane.showMessageDialog(null,
                "The goal is to get 20 troops to reach the goal alive as fast as possible.\n" +
                        "You can send troops by using the buttons on the bottom of the screen.\n" +
                        "Sending a troop costs credits, the cost is displayed on the associated buttons.\n" +
                        "You can view your available credits on the bottom of the screen.\n" +
                        "Every troop that reaches the goal alive will grant you credits."));
    }

    private void setRestartListener() {
        mainFrame.getGameMenu().setRestartListener(e -> {
            if (!isPaused) {
                if (newHighscore != null) {
                    newHighscore.dispose();
                }
                if (popupShowHighscores != null) {
                    popupShowHighscores.dispose();
                }
                restartPressed = true;
                int choice = JOptionPane.showConfirmDialog(mainFrame,
                        "Restart game?", "Confirm restart",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    stopTimer();
                    timer.cancel();
                    gameDone = true;
                    mainFrame.dispose();
                    g = new Game(xmlName);
                    g.setLevel(currentGame);
                    initMainframeAndSetListeners();
                    setRestartListener();
                    setPauseListener();
                    mainFrame.getGameMenu().setRestartNewGameText("Restart");
                    gameWon = false;
                    g.resetGame();
                    handler = new HighscoreHandler(db.getHighscores(g.getCurrentLevelname()));
                }
            }
        });
    }

    private void initMainframeAndSetListeners() {
        mainFrame = new MainFrame(g.getUnderlay(), g.getOverlay());
        gameDone = false;
        initGame();
        setTeleportButton();
        setRegularTroopListener();
        setTankTroopListener();
        setTeleportTroopListener();
        setMenuQuitListener();
        setAboutListener();
        setHelpListener();
    }
    private void setPauseListener(){
        mainFrame.getGameMenu().setPauseListener(e -> {
            if (paused == 0) {
                isPaused = true;
                stopTimer();
                mainFrame.getGameMenu().setPauseText("Resume");
                paused = 1;
            } else {
                isPaused = false;
                startTimer();
                mainFrame.getGameMenu().setPauseText("Pause");
                paused = 0;
            }
        });
    }
}

