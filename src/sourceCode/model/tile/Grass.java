package sourceCode.model.tile;

import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.GRASS;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Grass extends Tile {

    public Grass(Position p) {
        super(p);
        graphic = "grass";
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
    public TyleType landOn() {
        return GRASS;
    }
}
