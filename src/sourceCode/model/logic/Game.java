package sourceCode.model.logic;

import java.util.*;
import sourceCode.model.*;
import sourceCode.model.credit.Credit;
import sourceCode.model.tile.Tile;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser2;
import sourceCode.model.xmlparser.Levels;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static sourceCode.model.troop.Direction.EAST;

public class Game {
    private Tile[][] tiles;
    private OverlayImageArray overlayimgArr;
    private Position startPos;
    private ArrayList<Troop> regularTroops;
    private ArrayList<Tower> towers;
    private ArrayList<LaserPositions> laserPositionList;
    private int goalCounter = 0;
    private BufferedImage[][] underlay, overlay;
    private final Object troopListLock = new Object();
    private final Object towerListLock = new Object();
    private ArrayList<Levels> levelsArrayList;
    private String currentLevelname;

    private Credit money = new Credit();

    public Game(String s){

        levelsArrayList = new ArrayList<>();

        //Inläsning av leveln
        LevelParser2 levelP2 = new LevelParser2();
        LevelParser2.xmlparser(s);

        levelsArrayList = levelP2.getLevelsArrayList();
    }

    public BufferedImage[][] getUnderlay() {
        return underlay;
    }

    public BufferedImage[][] getOverlay() {
        return overlay;
    }


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

                ArrayList<Position> pathPosition = l.getPathPositions();
                ArrayList<Position> towerPosition = l.getTowerZonePositions();
                ArrayList<Position> quicksandPositions = l.getQuicksandPositions();
                ArrayList<Position> boosterPositions = l.getBoosterPositions();
                ArrayList<Position> switchUpPositions = l.getSwitchUpPositions();
                ArrayList<Position> switchDownPositions = l.getSwitchDownPositions();
                startPos = l.getStartPos();
                Position goalPos = l.getGoalPos();


                //Skapar BufferedImageArrays från kartan, både underLay och overLay
                ImageArray imgArr = new ImageArray(l.getMapTiles());
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

    public OverlayImageArray getOverlayimgArr() {
        return overlayimgArr;
    }

    public void sendTroop() {

        if (money.getCredits() >= 100) {
            Troop reg = new RegularTroop(startPos, EAST);
            regularTroops.add(reg);
            money.buyNewTroop(reg);
        }
    }

    public int getGoalCounter() {
        return goalCounter;
    }

    public void resetGame() {
        goalCounter = 0;
        money.setCredits(500);
        //laserPositionList.clear();
        //regularTroops.clear();
        //towers.clear();
        //resetTimer
    }


    public String getCurrentLevelname() {
        return currentLevelname;
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
                        goalCounter++;


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
