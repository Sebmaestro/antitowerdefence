package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Towerzone where towers can stand
 */
public class Towerzone extends Tile {

    /**
     * Constructor: Creates new towerzone tile
     * @param p - position
     */
    public Towerzone(Position p) {
        super(p);
        graphic = "src/resources/towerzone.png";
    }

    /**
     * Boolean to set if troop can walk or not on tile
     * @return boolean - true or false
     */
    @Override
    public boolean canWalk() {
        return false;
    }

    /**
     * Empty landon because troops doesnt walk here
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {}
}
