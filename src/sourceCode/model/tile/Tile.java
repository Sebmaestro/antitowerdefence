package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.Unit;

/**
 * Author: Sebastian Arledal / Simon Lundkvist / Dennis Karlman
 */
public abstract class Tile implements Unit, LandOn {
    Direction dir;
    protected Position p;
    protected String graphic;
    Position exitPosition;
    Direction directionAtExit;

    public Tile(Position p) {
        this.p = p;
        exitPosition = p;
    }

    public abstract boolean canWalk();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }

    Direction getDirectionAtExit(){

        return directionAtExit;
    }

    public void setDirectionAtExit(Direction dir){
        directionAtExit = dir;
    }

    public void setExitTPosition(Position p) {
        exitPosition = p;
    }
}
