package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Path tile that troops walk on
 */
public class Path extends Tile {

    /**
     * Constructor: Creates new path and sets graphic
     * @param p - position
     */
    public Path(Position p) {
        super(p);
        graphic = "src/resources/path.png";
    }

    /**
     * Boolean to set if troop can walk or not on tile
     * @return boolean - true or false
     */
    @Override
    public boolean canWalk() {
        return true;
    }

    /**
     * Sets troop speed to original speed
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {
        t.setCurrentSpeed(t.getOrdinarySpeed());
    }
}
