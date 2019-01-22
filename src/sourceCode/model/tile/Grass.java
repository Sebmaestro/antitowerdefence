package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

//import static sourceCode.model.tile.TyleType.GRASS;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Grass tile
 */
public class Grass extends Tile {

    /**
     * Constructor: Creates new grass tile and set graphic
     * @param p - position
     */
    public Grass(Position p) {
        super(p);
        graphic = "/grass.png";
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
     * Empty method for this tile because troops dont walk on it
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {}
}
