package sourceCode.model.xmlparser;

import sourceCode.model.Position;
import sourceCode.model.tile.Tile;

import java.util.ArrayList;

/**
 * Created by denni on 2018-12-17.
 */
public class Levels {
    private Tile[][] mapTiles;
    public String levelName;
    private Position startPos, startPosCopy;
    private Position goalPos, goalPosCopy;
    private ArrayList<Position> pathPositions = new ArrayList<>();
    private ArrayList<Position> grassPositions = new ArrayList<>();
    private ArrayList<Position> towerZonePositions = new ArrayList<>();
    private ArrayList<Position> boosterPositions = new ArrayList<>();
    private ArrayList<Position> quicksandPositions = new ArrayList<>();
    private ArrayList<Position> switchUpPositions = new ArrayList<>();
    private ArrayList<Position> switchDownPositions = new ArrayList<>();
    private ArrayList<Position> allSwitchPositions = new ArrayList<>();




    public Levels(){
    }



    public void setLevelName(String str){
        levelName = str;
    }
    public String getlevelName(){
        return levelName;
    }

    public void addLevels(Tile[][] tiles) {
        mapTiles = tiles;
    }

    public Tile[][] getMapTiles(){
        return mapTiles;
    }

    public void addstartPos(Position start){
        this.startPos = start;
    }

    public Position getStartPos(){
        return startPos;
    }

    public void addgoalPos(Position goal){
        this.goalPos = goal;
    }

    public Position getGoalPos(){
        return goalPos;
    }

    public void addPathPositions(ArrayList<Position> pathPos){
        pathPositions = pathPos;
    }

    public ArrayList<Position> getPathPositions(){
        return pathPositions;
    }

    public void addGrassPositions(ArrayList<Position> grassPos){
        grassPositions = grassPos;
    }

    public ArrayList<Position> getGrassPositions(){
        return grassPositions;
    }


    public void addTowerZonePositions(ArrayList<Position> towerZonePos){
        towerZonePositions = towerZonePos;
    }

    public ArrayList<Position> getTowerZonePositions(){
        return towerZonePositions;
    }

    public void addBoosterPositions(ArrayList<Position> boosterPos){
        boosterPositions = boosterPos;
    }

    public ArrayList<Position> getBoosterPositions(){
        return boosterPositions;
    }

    public void addQuicksandPositions(ArrayList<Position> quickSandPos){
        quicksandPositions = quickSandPos;
    }

    public ArrayList<Position> getQuicksandPositions(){
        return quicksandPositions;
    }

    public void addSwitchUpPositions(ArrayList<Position> switchUpPos){
        switchUpPositions = switchUpPos;
    }

    public ArrayList<Position> getSwitchUpPositions(){
        return switchUpPositions;
    }

    public void addSwitchDownPositions(ArrayList<Position> switchDownPos){
        switchDownPositions = switchDownPos;
    }

    public ArrayList<Position> getSwitchDownPositions(){
        return switchDownPositions;
    }

    public void addAllSwitchPositions(ArrayList<Position> allSwitchPos){
        allSwitchPositions = allSwitchPos;
    }

    public ArrayList<Position> getAllSwitchPositions(){
        return allSwitchPositions;
    }


}
