package sourceCode.model.tile;
import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.QUICKSAND;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Quicksand extends Tile {

    public Quicksand(Position p) {
        super(p);
        graphic = "src/Resources/quicksand.png";
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public void landOn(Troop t) {

        t.setCurrentSpeed(t.getSlowSpeed());
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
