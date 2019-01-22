package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import static sourceCode.model.tile.TyleType.BOOSTER;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Booster tile to increase speed of troops
 */
public class Booster extends Tile {

    /**
     * Constructor: Creates new goal and sets graphic
     * @param p - Position
     */
    public Booster(Position p) {
        super(p);
        graphic = "/booster.png";
    }

    /**
     * Increase troop speed
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {

        t.setCurrentSpeed(t.getFastSpeed());
    }

    /**
     * Boolean to set if troop can walk or not on tile
     * @return boolean - true or false
     */
    @Override
    public boolean canWalk() {
        return true;
    }

}
