package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.Unit;

/**
 * Author: Sebastian Arledal / Simon Lundkvist / Dennis Karlman
 * 2019-01-21
 *
 * Abstract class tile that troops walk on. All tile types extends this class
 */
public abstract class Tile implements Unit, LandOn {
    Direction dir;
    protected Position p;
    protected String graphic;
    Position exitPosition;
    Direction directionAtExit;

    /**
     * Constructor: Creates new tile
     * @param p - position
     */
    public Tile(Position p) {
        this.p = p;
        exitPosition = p;
    }

    /**
     * Boolean to set if troop can walk or not on tile
     * @return boolean - true or false
     */
    public abstract boolean canWalk();

    /**
     * Gets position
     * @return p - position
     */
    public Position getPosition() {
        return p;
    }

    /**
     * Gets graphic of tile
     * @return graphic - the graphic string
     */
    public String getGraphic() {
        return graphic;
    }

    /**
     * Gets direction when exited from teleport
     * @return directionAtExit - direction
     */
    Direction getDirectionAtExit(){

        return directionAtExit;
    }

    /**
     * Sets direction when troop exits from teleport
     * @param dir - direction
     */
    public void setDirectionAtExit(Direction dir){
        directionAtExit = dir;
    }

    /**
     * Sets position when troop exits from teleport
     * @param p - position
     */
    public void setExitTPosition(Position p) {
        exitPosition = p;
    }
}
