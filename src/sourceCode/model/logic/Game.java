package sourceCode.model.logic;

import sourceCode.model.*;
import sourceCode.model.credit.Credit;
import sourceCode.model.tile.*;
import sourceCode.model.tower.RegularTower;
import sourceCode.model.tower.Tower;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.TankTroop;
import sourceCode.model.troop.TeleporterTroop;
import sourceCode.model.troop.Troop;
import sourceCode.model.xmlparser.LevelParser;
import sourceCode.model.xmlparser.Levels;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import static sourceCode.model.troop.Direction.EAST;

/**
 * Dennis Karlman / Simon Lundkvist / Sebastian Arledal / David Eriksson
 */
public class Game {
    private Tile[][] tiles;
    private OverlayImageArray overlayimgArr;
    private ArrayList<Position> allSwitchPositions;
    private Position startPos;
    private ArrayList<Troop> troopList;
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
        LevelParser levelP2 = new LevelParser();
        LevelParser.xmlparser(s);
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
                allSwitchPositions = l.getAllSwitchPositions();

                startPos = l.getStartPos();
                Position goalPos = l.getGoalPos();

                ImageArray imgArr = new ImageArray(l.getMapTiles());
                imgArr.setTowerPics(towerPosition);
                overlayimgArr = new OverlayImageArray(l.getMapTiles().length);
                overlayimgArr.addPaths(pathPosition, quicksandPositions, boosterPositions,
                        switchDownPositions, switchUpPositions, startPos, goalPos);


                underlay = copyOff(imgArr.getTheWholeShit());
                overlay = copyOff(overlayimgArr.getTheWholeShit());


                troopList = new ArrayList<>();
                towers = new ArrayList<>();
                laserPositionList = new ArrayList<>();

                setUpTowers(towerPosition);

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

    public void teleport (){

        synchronized (troopListLock) {
            if (troopList.size() > 0) {
                for(Troop troop: troopList){
                    if(troop.getGraphic().equals("Teleporter") && (troop.getNumberOfTeleportTiles()==0)){

                        tiles[troop.getPosition().getY()][troop.getPosition().getX()] = new Teleport(
                                troop.getPosition());
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()]
                                .setDirectionAtExit(troop.getDirection());
                        overlayimgArr.addTeleportPic(troop.getPosition());

                        troop.setTeleportEntry(troop.getPosition());
                        troop.incrementNumberOfTeleportTiles();
                    }
                    else if(troop.getGraphic().equals("Teleporter") && (troop.getNumberOfTeleportTiles()==1)){

                        tiles[troop.getPosition().getY()][troop.getPosition().getX()] = new Teleport(
                                troop.getPosition());
                        tiles[troop.getPosition().getY()][troop.getPosition().getX()].setDirectionAtExit(troop.getDirection());
                        overlayimgArr.addTeleportPic(troop.getPosition());

                        tiles[troop.getTeleportEntry().getY()][troop.getTeleportEntry().getX()]
                                .setExitTPosition(troop.getPosition());


                        troop.incrementNumberOfTeleportTiles();
                    }
                }
            }
        }
    }

    public void sendRegularTroop() {

        if (money.getCredits() >= 100) {
            Troop reg = new RegularTroop(startPos, EAST);
            troopList.add(reg);
            money.buyNewTroop(reg);
        }
    }

    public void sendTankTroop() {
        if (money.getCredits() >= 300) {
            Troop tank = new TankTroop(startPos, EAST);
            troopList.add(tank);
            money.buyNewTroop(tank);
        }
    }

    public void sendTeleporterTroop() {

        boolean teleporterFound = false;

        for (Troop troop: troopList){
            if(troop.getGraphic().equals("Teleporter")){
                teleporterFound = true;
            }
        }

        if (money.getCredits() >= 700 && !teleporterFound) {
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
    }


    public String getCurrentLevelname() {
        return currentLevelname;
    }


    public void removeTroops(){
        Iterator<Troop> iter = troopList.iterator();
        synchronized (troopListLock) {
            while(iter.hasNext()){
                Troop troop = iter.next();

                if(troop.getGraphic().equals("Teleporter") && (troop.getNumberOfTeleportTiles() == 1) &&
                        (troop.isAlive())){
                    tiles[troop.getPosition().getY()][troop.getPosition().getX()] = new Teleport(
                            troop.getPosition());
                    tiles[troop.getPosition().getY()][troop.getPosition().getX()].setDirectionAtExit(troop.getDirection());
                    overlayimgArr.addTeleportPic(troop.getPosition());

                    tiles[troop.getTeleportEntry().getY()][troop.getTeleportEntry().getX()]
                            .setExitTPosition(troop.getPosition());

                    troop.incrementNumberOfTeleportTiles();
                }

                if(troop.isGoalReached() || troop.isAlive() || troop.getNumberOfTeleportTiles()==2){
                    iter.remove();
                    if(troop.isGoalReached()) {
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
                    } else if (troop.getGraphic().equals("Tank") && (troop.getUntilMove() == troop.getCurrentSpeed())) {
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
            /*
            for(int j=0; j<original.length; j++){
                copy[i][j] = original[i][j];
            }
            */
            System.arraycopy(original[i], 0, copy[i], 0, original.length);
        }
        return copy;
    }


    private void setUpTowers(ArrayList<Position> towerPosition){
        for(Position p: towerPosition){
            towers.add(new RegularTower(p));
        }
    }
}
