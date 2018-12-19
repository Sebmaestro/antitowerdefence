package sourceCode.model.logic;

import sourceCode.model.*;
import sourceCode.model.credit.Credit;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.tile.*;
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
    private Tile[][] tiles;
    //private LevelParser levelP;
    private LevelParser2 levelP2;
    private ImageArray imgArr;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> pathPosition, towerPosition, quicksandPositions,
            boosterPositions, switchUpPositions, switchDownPositions, allSwitchPositions;
    private Position startPos, goalPos;
    private ArrayList<Troop> troopList;
    private ArrayList<Tower> towers;
    private ArrayList<LaserPositions> laserPositionList;
    private int goalCounter = 0, regularMove = 0, teleporterMove = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();
    private ArrayList<Levels> levelsArrayList;
    private String currentLevelname;
    private boolean troopInTheList = false, teleporterInTheList = false;



    private Credit money = new Credit();

    public Game(String s){

        levelsArrayList = new ArrayList<>();

        //Inläsning av leveln
        //levelP = new LevelParser();
        levelP2 = new LevelParser2();
        levelP2.xmlparser(s);
        //tiles = readLevel("src/Resources/levels.xml");


        levelsArrayList = levelP2.getLevelsArrayList();
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
                troopList = new ArrayList<>();
                towers = new ArrayList<>();
                laserPositionList = new ArrayList<>();

                //Sätter tornen på rätt plats
                setUpTowers(towerPosition);

                //Lägger till trupper på sätt plats i overlayImage
                overlayimgArr.addRegularTroopList(troopList);
            }
        }
    }

    public OverlayImageArray getOverlayimgArr() {
        return overlayimgArr;
    }

    public void changeSwitch(Position p){
        if (tiles[p.getY()][p.getX()].getGraphic().equals("src/Resources/switch-down.png")){
            tiles[p.getY()][p.getX()] = new Switchup(p);
            overlayimgArr.changeSwitchDownToUp(p);
        }
        else if(tiles[p.getY()][p.getX()].getGraphic().equals("src/Resources/switch-up.png")){
            tiles[p.getY()][p.getX()] = new Switchdown(p);
            overlayimgArr.changeSwitchUpToDown(p);
        }
    }

    public void sendRegularTroop() {

        if (money.getCredits() >= 100) {
            Troop reg = new RegularTroop(startPos, EAST);
            troopList.add(reg);
            money.buyNewTroop(reg);
        }
    }

    public void sendTeleporterTroop() {

        if (money.getCredits() >= 700) {
            Troop tel = new TeleporterTroop(startPos, EAST);
            troopList.add(tel);
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
        //troopList.clear();
        //towers.clear();
        //resetTimer
    }


    public String getCurrentLevelname() {
        return currentLevelname;
    }




    public void removeTroops(){
        Iterator<Troop> iter = troopList.iterator();
        synchronized (troopListLock) {
            while(iter.hasNext()){
                Troop reg = iter.next();

                if(reg.isGoalReached() || !reg.isAlive()){
                    iter.remove();
                    if(reg.isGoalReached()) {
                        money.getGoalCredits();
                        goalCounter++;


                    }
                }
            }
        }
    }

    public void moveTroops(){
        synchronized (troopListLock) {
            if(troopList.size() > 0) {
                for (Troop troop : troopList) {

                    if(troop.getGraphic().equals("Regular") && (troop.getUntilMove() == troop.getCurrentSpeed())){
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()].landOn(troop);
                        troop.move(tiles);
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()].landOn(troop);
                        troop.clearUntilMove();
                    }
                    else if(troop.getGraphic().equals("Teleporter") && (troop.getUntilMove() == troop.getCurrentSpeed())){
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()].landOn(troop);
                        troop.move(tiles);
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()].landOn(troop);
                        troop.clearUntilMove();
                    }
                    troop.incrementUntilMove();
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
                    for (Troop t : troopList) {
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
                        t.clearToAttackList();
                    }
                }
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
