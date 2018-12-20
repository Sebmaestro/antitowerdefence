package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
/**
 * Author: Sebastian Arledal c17sal
 */
public class Start extends Tile {

    public Start(Position p) {
        super(p);
        graphic = "src/resources/start.png";
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public void landOn(Troop t) {}
}
