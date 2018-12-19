package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.Unit;
import sourceCode.view.Screen;

import java.awt.*;

import static sourceCode.model.troop.Direction.*;


public abstract class Tile extends Rectangle implements Unit, LandOn {


    Direction dir;
    protected Position p;
    protected String graphic;
    protected int groundId;
    protected Position startp, exitPosition;
    protected Direction directionAtStart, directionAtExit;

    boolean isWalkable;
    boolean canBuildTower;



    public Tile(Position p) {
        setBounds(235 + p.getX()*55,p.getY()*55,55,55);
        this.p = p;
        exitPosition = p;
    }


    //Methods
    public int getGroundId() {
        return groundId;
    }
    public void setGroundId(int id) { groundId = id; }
    public abstract boolean canWalk();
    public abstract String graphicChange();
    public abstract boolean canBuildTower();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }

    public Position getStart(){ return startp;}

    public Direction getDirectionAtExit(){

        return directionAtExit;
    }
    public Direction getDirectionAtStart(){
        return directionAtStart;
    }

    public void setDirectionAtExit(Direction dir){
        directionAtExit = dir;
    }

    public void setExitTPosition(Position p) {
        exitPosition = p;
    }

    public void setDirectionAtStart(Direction dir){
        directionAtStart = dir;
    }

    /*
    public void clickOn() {
        opposite direction of startvalue
        if (dir == NORTH) {
            dir = SOUTH;
            graphic = "pathswitch south";
        } else
            dir = NORTH;
            graphic = "pathswitch north";

    }
    */

}
