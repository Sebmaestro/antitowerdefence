package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Path extends Tile {

    public Path(Position p) {
        super(p);
        graphic = "src/resources/path.png";
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public void landOn(Troop t) {
        t.setCurrentSpeed(t.getOrdinarySpeed());
    }
}
