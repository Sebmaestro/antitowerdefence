package sourceCode.model.tile;

import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.TOWERZONE;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Towerzone extends Tile {

    public Towerzone(Position p) {
        super(p);
        graphic = "path";
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
        return true;
    }

    @Override
    public TyleType landOn() {
        return TOWERZONE;
    }
}
