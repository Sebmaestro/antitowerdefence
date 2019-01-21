package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import static sourceCode.model.troop.Direction.EAST;

/**
 * Author: Dennis Karlman / David Eriksson
 * 2019-01-21
 *
 * Teleporter tile to teleport troops
 */
public class Teleport extends Tile {

    /**
     * Constructor: Creates new teleport and sets graphic
     * @param p - position
     */
    public Teleport(Position p) {
        super(p);
        graphic = "src/Resources/teleporter1.png";
        directionAtExit = EAST;
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
     * Set troop position to teleport exit
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {

        t.setPosition(exitPosition);

        t.setDirection(getDirectionAtExit());
    }
}
