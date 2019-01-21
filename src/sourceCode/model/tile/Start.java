package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Start tile for troops to start on
 */
public class Start extends Tile {

    /**
     * Constructor: Creates new start tile and sets graphic
     * @param p - position
     */
    public Start(Position p) {
        super(p);
        graphic = "src/resources/start.png";
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
     * Empty landon method because it doesnt affect troop
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {}
}
