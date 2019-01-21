package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Quicksand tile to slow down troops
 */
public class Quicksand extends Tile {

    /**
     * Controller: Creates new quicksand tile and sets graphic
     * @param p - position
     */
    public Quicksand(Position p) {
        super(p);
        graphic = "src/Resources/quicksand.png";
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
     * Slows down troop speed
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {

        t.setCurrentSpeed(t.getSlowSpeed());
    }
}
