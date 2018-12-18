package sourceCode.model.logic;

import sourceCode.model.*;
import sourceCode.model.credit.Credit;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.TeleporterTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser2;
import sourceCode.model.xmlparser.Levels;
import sourceCode.view.PopupNewHighscoreSetter;
import sourceCode.view.PopupShowHighscores;
import sourceCode.view.StartMenuFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static sourceCode.model.troop.Direction.EAST;

//mport sourceCode.model.xmlparser.LevelParser;

public class Game {
    //private Frame frame;
    private Model model;
    private Tile[][] tiles;
    //private LevelParser levelP;
    private LevelParser2 levelP2;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition, towerPosition, quicksandPositions,
            boosterPositions, switchUpPositions, switchDownPositions, allSwitchPositions;
    private Position startPos, goalPos;
    private ArrayList<Troop> regularTroops;
    private ArrayList<Tower> towers;
    private ArrayList<LaserPositions> laserPositionList;
    private int goalCounter = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();
    private PopupShowHighscores popupShowHighscores;
    private PopupNewHighscoreSetter newHighscore;
    private Database db = new Database();
    private HighscoreHandler handler;
    private StartMenuFrame start;
    private ArrayList<Levels> levelsArrayList;
    private String currentLevelname;


    int gameWon = 0;
    private Credit money = new Credit();

    public Game(){

        levelsArrayList = new ArrayList<>();
        //Startar en ny startmeny
        //start = new StartMenuFrame();

        //Inläsning av leveln
        //levelP = new LevelParser();
        levelP2 = new LevelParser2();
        levelP2.xmlparser("src/Resources/levels.xml");
        //tiles = readLevel("src/Resources/levels.xml");


        levelsArrayList = levelP2.getLevelsArrayList();




        //Får alla positioner som vi behöver från kartan
    }

    public BufferedImage[][] getUnderlay() {
        return underlay;
    }

    public BufferedImage[][] getOverlay() {
        return overlay;
    }

    public ArrayList <Position> getSwitchPos(){ return allSwitchPositions; }

    public int getMoney() {
        return money.getCredits();
    }

    public ArrayList<Levels> getLevelsArrayList() {
        return levelsArrayList;
    }

    public void setLevel(String levelName) {
        for (Levels l:levelsArrayList) {
            if (l.getlevelName().equals(levelName)) {
                currentLevelname = levelName;

                tiles = l.getMapTiles();

                pathPosition = l.getPathPositions();
                towerPosition = l.getTowerZonePositions();
                quicksandPositions = l.getQuicksandPositions();
                boosterPositions = l.getBoosterPositions();
                switchUpPositions = l.getSwitchUpPositions();
                switchDownPositions = l.getSwitchDownPositions();
                allSwitchPositions = l.getAllSwitchPositions();

                startPos = l.getStartPos();
                goalPos = l.getGoalPos();


                //Skapar BufferedImageArrays från kartan, både underLay och overLay
                imgArr = new ImageArray(l.getMapTiles());
                imgArr.setTowerPics(towerPosition);
                overlayimgArr = new OverlayImageArray(l.getMapTiles().length);
                overlayimgArr.addPaths(pathPosition, quicksandPositions, boosterPositions,
                        switchDownPositions, switchUpPositions, startPos, goalPos);

                //Kopierar dessa bilder för inskickning till frame
                underlay = copyOff(imgArr.getTheWholeShit());
                overlay = copyOff(overlayimgArr.getTheWholeShit());

                //Skapar en frame med BufferedImageArrays
                //setTheFrame(underlay, overlay);

                //Skapar listor för torn, trupper och lasers
                regularTroops = new ArrayList<>();
                towers = new ArrayList<>();
                laserPositionList = new ArrayList<>();

                //Sätter tornen på rätt plats
                setUpTowers(towerPosition);

                //Lägger till trupper på sätt plats i overlayImage
                overlayimgArr.addRegularTroopList(regularTroops);
            }
        }
    }

    /*
    public void init(){
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
    */

    public OverlayImageArray getOverlayimgArr() {
        return overlayimgArr;
    }

    public void sendRegularTroop() {

        if (money.getCredits() >= 100) {
            Troop reg = new RegularTroop(startPos, EAST);
            regularTroops.add(reg);
            money.buyNewTroop(reg);
        }
    }

    public void sendTeleporterTroop() {

        if (money.getCredits() >= 700) {
            Troop tel = new TeleporterTroop(startPos, EAST);
            regularTroops.add(tel);
            money.buyNewTroop(tel);
        }
    }

    public int getGoalCounter() {
        return goalCounter;
    }

    public void resetGame() {
        goalCounter = 0;
        money.setCredits(5000);
        //laserPositionList.clear();
        //regularTroops.clear();
        //towers.clear();
        //resetTimer
    }


    public String getCurrentLevelname() {
        return currentLevelname;
    }


    /*
    public Frame setTheFrame(BufferedImage[][] underlay, BufferedImage[][] overlay){
        frame = new Frame();
        frame.addScreen();
        frame.addButtonPanel();
        frame.getScreen().setImages(underlay, overlay);
        setRegularTroopListener();
        frame.getScreen().createGameScreen();

        return frame;
    }
    */

    /*
    public void gameLoop() {
        double time = System.nanoTime();

        while(true) {
            try {
                SwingUtilities.invokeAndWait(() -> {

                    //frame.getButtonPanel().setMoneyField(money.getCredits());
                    overlayimgArr.updateImage();
                    //frame.getScreen().updateOverlay(copyOff(overlayimgArr.getTheWholeShit()));
                    //frame.getScreen().repaint();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    shootTroops();
                    removeTroops();
                    moveTroops();
                });
            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    */

    public void removeTroops(){
        Iterator<Troop> iter = regularTroops.iterator();
        synchronized (troopListLock) {
            while(iter.hasNext()){
                Troop reg = iter.next();

                if(reg.isGoalReached() || !reg.isAlive()){
                    iter.remove();
                    if(reg.isGoalReached()) {
                        money.getGoalCredits();
                        goalCounter++;

                        /*
                        if(goalCounter<1) {
                            goalCounter++;
                            //frame.getButtonPanel().setGoalCounter(goalCounter);
                        } else if (gameWon == 0){
                            //Game is done
                            gameWon = 1;
                            popupShowHighscores = new PopupShowHighscores("Map2");
                            newHighscore = new PopupNewHighscoreSetter();
                            Database db = new Database();
                            handler = new HighscoreHandler(db.getHighscores("Map2"));
                            //setSubmitButtonListener();
                            //setQuitButtonListener();
                            popupShowHighscores.setColumns();
                        */

                            //handler.checkAndInsertHighscore(new HighscoreInfo("Thebiggest", 45));
                            //handler.checkAndInsertHighscore(new HighscoreInfo("xgod", 10));
                            //popupShowHighscores.showHighscores(handler.getList());
                            //db.saveHighscores(handler.getList(), "Map2");
                        //}

                        //goalCounter++;
                        // frame.getButtonPanel().setGoalCounter(goalCounter);
                    }
                }
            }
        }
    }

    public void moveTroops(){
        synchronized (troopListLock) {
            if(regularTroops.size() > 0) {
                for (Troop reg : regularTroops) {
                    reg.move(tiles);

                    System.out.println(reg.getHp());

                }
            }
        }
    }


    public ArrayList<LaserPositions> shootTroops() {
        synchronized (towerListLock) {
            laserPositionList.clear();
            if(towers.size() > 0) {
                for (Tower tower : towers) {
                    int i = 0;
                    for (Troop t : regularTroops) {
                        if (tower.canReachTroop(t)) {
                            if (i == 0) {
                                i++;
                                tower.addToAttackList(t);
                                LaserPositions laserpos = new LaserPositions(tower.getPosition(), t.getPosition());
                                laserPositionList.add(laserpos);
                            }
                        }
                    }
                }
                for(Tower t: towers){
                    if(t.getToAttackList().size() >0) {
                        //frame.getScreen().getLaser().setLaserPosition(t.getPosition(),
                         //       t.getToAttack().get(0).getPosition());
                        //frame.getScreen().drawLaser();
                        t.clearToAttackList();
                    }
                }

                //frame.getScreen().getLaser().setPositons(laserPositionList);
                //frame.getScreen().getLaser().setLasers();
            }
        }
        return laserPositionList;
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


    /*
    public void setPlayagainListener() {
        popupShowHighscores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Kör igen
            }
        }, "play");
    }

    public void setMap1Listener() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Välj xml för första mappen och starta spelet
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
                //Visa highscore
            }
        }, "highscore");
    }

    public void setSubmitButtonListener() {
        newHighscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.checkAndInsertHighscore(new HighscoreInfo(newHighscore.getTextfieldInfo(), 5));
                popupShowHighscores.clear();
                popupShowHighscores.setColumns();
                popupShowHighscores.showHighscores(handler.getList());
                db.saveHighscores(handler.getList(), "Map2");
                newHighscore.dispose();
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
    */


    public void setUpTowers(ArrayList<Position> towerPosition){
        for(Position p: towerPosition){
            towers.add(new RegularTower(p));
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
