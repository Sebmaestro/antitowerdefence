package sourceCode.model.xmlparser;

import sourceCode.model.Position;
import sourceCode.model.tile.Tile;
import java.util.ArrayList;

/**
 * Created by denni on 2018-12-17.
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


    void setLevelName(String str){
        levelName = str;
    }
    public String getlevelName(){
        return levelName;
    }

    void addLevels(Tile[][] tiles) {
        mapTiles = tiles;
    }

    public Tile[][] getMapTiles(){
        return mapTiles;
    }

    void addstartPos(Position start){
        this.startPos = start;
    }

    public Position getStartPos(){
        return startPos;
    }

    void addgoalPos(Position goal){
        this.goalPos = goal;
    }

    public Position getGoalPos(){
        return goalPos;
    }

    void addPathPositions(ArrayList<Position> pathPos){
        pathPositions = pathPos;
    }

    public ArrayList<Position> getPathPositions(){
        return pathPositions;
    }

    void addGrassPositions(ArrayList<Position> grassPos){
        grassPositions = grassPos;
    }

    void addTowerZonePositions(ArrayList<Position> towerZonePos){
        towerZonePositions = towerZonePos;
    }

    public ArrayList<Position> getTowerZonePositions(){
        return towerZonePositions;
    }

    void addBoosterPositions(ArrayList<Position> boosterPos){
        boosterPositions = boosterPos;
    }

    public ArrayList<Position> getBoosterPositions(){
        return boosterPositions;
    }

    void addQuicksandPositions(ArrayList<Position> quickSandPos){
        quicksandPositions = quickSandPos;
    }

    public ArrayList<Position> getQuicksandPositions(){
        return quicksandPositions;
    }

    void addSwitchUpPositions(ArrayList<Position> switchUpPos){
        switchUpPositions = switchUpPos;
    }

    public ArrayList<Position> getSwitchUpPositions(){
        return switchUpPositions;
    }

    void addSwitchDownPositions(ArrayList<Position> switchDownPos){
        switchDownPositions = switchDownPos;
    }

    public ArrayList<Position> getSwitchDownPositions(){
        return switchDownPositions;
    }

    void addAllSwitchPositions(ArrayList<Position> allSwitchPos){
        allSwitchPositions = allSwitchPos;
    }

    public ArrayList<Position> getAllSwitchPositions(){
        return allSwitchPositions;
    }
}
