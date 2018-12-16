package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.GRASS;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Grass extends Tile {

    public Grass(Position p) {
        super(p);
        graphic = "src/resources/grass.png";
        groundId = 0;
    }

    @Override
    public boolean canWalk() {
        return false;
    }


    @Override
    public String graphicChange() {
        return null;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }


    @Override
    public void landOn(Troop t) {}
}
