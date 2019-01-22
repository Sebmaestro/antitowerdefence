package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.GOAL;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Goal tile class
 */
public class Goal extends Tile {

    /**
     * Constructor: Creates goal and sets graphic
     * @param p - position
     */
    public Goal(Position p) {
        super(p);
        graphic = "/goal.png";
    }

    /**
     * Checks if the troop can walk on tile or not
     * @return boolean - true or false
     */
    @Override
    public boolean canWalk() {
        return true;
    }

    /**
     * Sets goal reached for the troop
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {
        t.setGoalReached();
    }

}
