package sourceCode.model.logic;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import sourceCode.model.*;
import sourceCode.model.Model;
import sourceCode.model.credit.Credit;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
import sourceCode.view.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game {
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
    private Database db = new Database();
    private HighscoreHandler handler;
    private StartMenuFrame start;

    int gameWon = 0;
    Credit money = new Credit();

    public Game(){

        //Startar en ny startmeny
        //start = new StartMenuFrame();

        //Inläsning av leveln
        levelP = new LevelParser();
        tiles = readLevel("src/Resources/testlevel.xml");

        //Får alla positioner som vi behöver från kartan
        pathPosition = levelP.getPathPositions();
        towerPosition = levelP.getTowerZonePositions();
        quicksandPositions = levelP.getQuicksandPositions();
        boosterPositions = levelP.getBoosterPositions();
        switchUpPositions = levelP.getSwitchUpPositions();
        switchDownPositions = levelP.getSwitchDownPositions();
        startPos = levelP.getStartPos();
        goalPos = levelP.getGoalPos();

        //Skapar BufferedImageArrays från kartan, både underLay och overLay
        imgArr = new ImageArray(tiles);
        imgArr.setTowerPics(towerPosition);
        overlayimgArr = new OverlayImageArray(tiles.length);
        overlayimgArr.addPaths(pathPosition, quicksandPositions, boosterPositions,
                switchDownPositions, switchUpPositions, startPos, goalPos);

        //Kopierar dessa bilder för inskickning till mainFrame
        underlay = copyOff(imgArr.getTheWholeShit());
        overlay = copyOff(overlayimgArr.getTheWholeShit());

        //Skapar en mainFrame med BufferedImageArrays
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

    public BufferedImage[][] getUnderlay() {
        return underlay;
    }

    public BufferedImage[][] getOverlay() {
        return overlay;
    }

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

    public Tile[][] readLevel(String str){
        tiles = levelP.xmlparser(str);
        return tiles;
    }

    /*


    public MainFrame getFrame() {
        return mainFrame;
    }
    */

    public void gameLoop() {
        double time = System.nanoTime();

        while(true) {
            try {
                SwingUtilities.invokeAndWait(() -> {

                    mainFrame.getButtonPanel().setMoneyField(money.getCredits());
                    overlayimgArr.updateImage();
                    mainFrame.getScreen().updateOverlay(copyOff(overlayimgArr.getTheWholeShit()));
                    mainFrame.getScreen().repaint();

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

    public void removeTroops(){
        Iterator<Troop> iter = regularTroops.iterator();
        synchronized (troopListLock) {
            while(iter.hasNext()){
                Troop reg = iter.next();

                if(reg.isGoalReached() || !reg.isAlive()){
                    iter.remove();
                    if(reg.isGoalReached()) {
                        money.getGoalCredits();

                        if(goalCounter<1) {
                            goalCounter++;
                            mainFrame.getButtonPanel().setGoalCounter(goalCounter);
                        } else if (gameWon == 0){
                            //Game is done
                            gameWon = 1;
                            popupFrame = new PopupFrame("Map2");
                            newHighscore = new PopupHighscoreFrame();
                            Database db = new Database();
                            handler = new HighscoreHandler(db.getHighscores("Map2"));
                            popupFrame.setColumns();


                            //handler.checkAndInsertHighscore(new HighscoreInfo("Thebiggest", 45));
                            //handler.checkAndInsertHighscore(new HighscoreInfo("xgod", 10));
                            //popupFrame.showHighscores(handler.getList());
                            db.saveHighscores(handler.getList(), "Map2");
                        }

                        goalCounter++;
                        // mainFrame.getButtonPanel().setGoalCounter(goalCounter);
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


    public void shootTroops(){

        synchronized (towerListLock) {
            if(towers.size() > 0) {
                for (Tower tower : towers) {
                    if(regularTroops.size() > 0) {
                        if (tower.canReachTroop(regularTroops.get(0))) {
                            mainFrame.getScreen().getLaser().setLaserPosition(
                                    tower.getPosition(), regularTroops.get(0).getPosition());
                            mainFrame.getScreen().drawLaser();
                            tower.attack(regularTroops.get(0));
                            LaserPositions laserpos = new LaserPositions(tower.getPosition(),regularTroops.get(0).getPosition());
                            laserPositionList.add(laserpos);
                        }
                    }
                    if(regularTroops.size() > 1) {
                        if(!tower.canReachTroop(regularTroops.get(0))) {
                            if (tower.canReachTroop(regularTroops.get(1))) {
                                mainFrame.getScreen().getLaser().setLaserPosition(
                                        tower.getPosition(), regularTroops.get(1).getPosition());
                                mainFrame.getScreen().drawLaser();
                                tower.attack(regularTroops.get(1));
                                LaserPositions laserpos = new LaserPositions(tower.getPosition(), regularTroops.get(1).getPosition());
                                laserPositionList.add(laserpos);
                            }
                        }
                    }

                    if(regularTroops.size() > 2) {
                        if((!tower.canReachTroop(regularTroops.get(0)) && !tower.canReachTroop(regularTroops.get(1)))) {
                            if (tower.canReachTroop(regularTroops.get(2))) {
                                mainFrame.getScreen().getLaser().setLaserPosition(
                                        tower.getPosition(), regularTroops.get(2).getPosition());
                                mainFrame.getScreen().drawLaser();
                                tower.attack(regularTroops.get(2));
                                LaserPositions laserpos = new LaserPositions(tower.getPosition(), regularTroops.get(2).getPosition());
                                laserPositionList.add(laserpos);
                            }
                        }
                    }


                }
                mainFrame.getScreen().getLaser().setPositons(laserPositionList);
                mainFrame.getScreen().getLaser().setLasers();
            }
        }
        laserPositionList.clear();
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