package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Towerzone extends Tile {

    public Towerzone(Position p) {
        super(p);
        graphic = "src/resources/towerzone.png";
    }

    @Override
    public boolean canWalk() {
        return false;
    }

    @Override
    public void landOn(Troop t) {}
}
