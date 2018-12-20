package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

//import static sourceCode.model.tile.TyleType.GRASS;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Grass extends Tile {

    public Grass(Position p) {
        super(p);
        graphic = "src/resources/grass.png";
    }

    @Override
    public boolean canWalk() {
        return false;
    }

    @Override
    public void landOn(Troop t) {}
}
