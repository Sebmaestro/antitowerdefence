package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.Troop;
import static sourceCode.model.troop.Direction.NORTH;

/**
 * Created by denni on 2018-12-17.
 * 2019-01-21
 *
 * Downpath for switch tile
 */
public class Switchup extends Tile{

    /**
     * Constructor: Creates new switchup tile and sets graphic
     * @param p - position
     */
    public Switchup(Position p){
        super(p);
        graphic = "/switch-up.png";
        dir = NORTH;
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
     * Sets direction of troop when walked on
     * @param t - troop
     */
    @Override
    public void landOn(Troop t) {

        t.setDirection(NORTH);
    }

    /**
     * Gets direction for troop
     * @return dir - direction
     */
    public Direction getDirection() {
        return dir;
    }
}


