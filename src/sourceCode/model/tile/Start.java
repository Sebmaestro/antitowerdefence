package sourceCode.model.tile;

import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.START;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Start extends Tile {

    public Start(Position p) {
        super(p);
        graphic = "src/resources/start.png";
        groundId = 3;
    }

    @Override
    public boolean canWalk() {
        return true;
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
        return START;
    }
}
