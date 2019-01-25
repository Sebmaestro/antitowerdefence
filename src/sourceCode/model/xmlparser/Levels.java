package sourceCode.model.xmlparser;

import sourceCode.model.Position;
import sourceCode.model.tile.Tile;
import java.util.ArrayList;

/**
 * Created by Dennis Karlman
 * 2019-25-01
 *
 * A class that holds the levels
 */
public class Levels {
    private Tile[][] mapTiles;
    private String levelName;
    private Position startPos;
    private Position goalPos;
    private ArrayList<Position> pathPositions = new ArrayList<>();
    private ArrayList<Position> grassPositions = new ArrayList<>();
    private ArrayList<Position> towerZonePositions = new ArrayList<>();
    private ArrayList<Position> boosterPositions = new ArrayList<>();
    private ArrayList<Position> quicksandPositions = new ArrayList<>();
    private ArrayList<Position> switchUpPositions = new ArrayList<>();
    private ArrayList<Position> switchDownPositions = new ArrayList<>();
    private ArrayList<Position> allSwitchPositions = new ArrayList<>();

    /**
     * Sets the level name
     * @param str - The level name
     */
    void setLevelName(String str){
        levelName = str;
    }

    /**
     * Gets the level name
     * @return levelName - name of level
     */
    public String getlevelName(){
        return levelName;
    }

    /**
     * Adds the tiles to level
     * @param tiles - the tiles that construct the level
     */
    void addLevels(Tile[][] tiles) {
        mapTiles = tiles;
    }

    /**
     * Gets the tiles of level
     * @return mapTiles - Tiles
     */
    public Tile[][] getMapTiles(){
        return mapTiles;
    }

    /**
     * Adds start position
     * @param start - position
     */
    void addstartPos(Position start){
        this.startPos = start;
    }

    /**
     * Gets start position
     * @return startPos - start position
     */
    public Position getStartPos(){
        return startPos;
    }

    /**
     * Adds goal position
     * @param goal - goal position
     */
    void addgoalPos(Position goal){
        this.goalPos = goal;
    }

    /**
     * Gets goal position
     * @return goalPos - Goal position
     */
    public Position getGoalPos(){
        return goalPos;
    }

    /**
     * Adds positions of path
     * @param pathPos - position of path
     */
    void addPathPositions(ArrayList<Position> pathPos){
        pathPositions = pathPos;
    }

    /**
     * Gets the path positions
     * @return pathPosition - an ArrayList with path positions
     */
    public ArrayList<Position> getPathPositions(){
        return pathPositions;
    }

    /**
     * Adds positions of grass
     * @param grassPos - positions of grass
     */
    void addGrassPositions(ArrayList<Position> grassPos){
        grassPositions = grassPos;
    }

    /**
     * Adds Tower Zone Positions
     * @param towerZonePos - an ArrayList of tower zone positions
     */
    void addTowerZonePositions(ArrayList<Position> towerZonePos){
        towerZonePositions = towerZonePos;
    }

    /**
     * Gets the Tower Zone Positions
     * @return towerZonePositions - positions of Tower Zones
     */
    public ArrayList<Position> getTowerZonePositions(){
        return towerZonePositions;
    }

    /**
     * Adds Booster positions
     * @param boosterPos - ArrayList of Booster positions
     */
    void addBoosterPositions(ArrayList<Position> boosterPos){
        boosterPositions = boosterPos;
    }

    /**
     * Gets Booster positions
     * @return boosterPositions - ArrayList o booster positions
     */
    public ArrayList<Position> getBoosterPositions(){
        return boosterPositions;
    }

    /**
     * Adds Quicksand positions
     * @param quickSandPos - An ArrayList of quicksand positions
     */
    void addQuicksandPositions(ArrayList<Position> quickSandPos){
        quicksandPositions = quickSandPos;
    }

    /**
     * Gets the Quicksand Positions
     * @return quicksandPositions - ArrayList of Quicksand positions
     */
    public ArrayList<Position> getQuicksandPositions(){
        return quicksandPositions;
    }

    /**
     * Adds SwitchUp postions
     * @param switchUpPos - ArrayList of SwitchUp positions
     */
    void addSwitchUpPositions(ArrayList<Position> switchUpPos){
        switchUpPositions = switchUpPos;
    }

    /**
     * Gets SwitchUp positions
     * @return switchUpPositions - ArrayList of SwitchUp positions
     */
    public ArrayList<Position> getSwitchUpPositions(){
        return switchUpPositions;
    }

    /**
     * Adds SwitchDown positions
     * @param switchDownPos - ArrayList of SwitchDown positions
     */
    void addSwitchDownPositions(ArrayList<Position> switchDownPos){
        switchDownPositions = switchDownPos;
    }

    /**
     * Get SwitchDown positions
     * @return - switchDownPositions - ArrayList of SwitchDown positions
     */
    public ArrayList<Position> getSwitchDownPositions(){
        return switchDownPositions;
    }

    /**
     * Adds all Switch positions
     * @param allSwitchPos - ArrayList of all Switch positions
     */
    void addAllSwitchPositions(ArrayList<Position> allSwitchPos){
        allSwitchPositions = allSwitchPos;
    }

    /**
     * Gets all Switch positions
     * @return allSwitchPositions - ArrayList of all Switch Positions
     */
    public ArrayList<Position> getAllSwitchPositions(){
        return allSwitchPositions;
    }
}
