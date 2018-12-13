package sourceCode.model.tile;

import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.GOAL;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Goal extends Tile {

    public Goal(Position p) {
        super(p);
        graphic = "goal";
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
    public TyleType landOn() {
        return GOAL;
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
