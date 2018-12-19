package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.BOOSTER;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Booster extends Tile {

    public Booster(Position p) {
        super(p);
        graphic = "src/Resources/booster.png";
    }
    @Override
    public void landOn(Troop t) {

        //t.setSpeed(20);
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
    public String graphicChange() {
        return null;
    }
}
