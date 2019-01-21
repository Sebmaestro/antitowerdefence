package sourceCode.model.tile;

import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 * 2019-01-21
 *
 * Interface LandOn that all tiles implements
 */
public interface LandOn {

    /**
     * Method that all tiles use to decide what to do
     * with troop when landed on
     * @param t - troop
     */
    void landOn(Troop t);
}
