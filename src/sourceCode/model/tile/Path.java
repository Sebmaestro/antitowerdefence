package sourceCode.model.tile;

import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.*;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Path extends Tile {

    public Path(Position p) {
        super(p);
        graphic = "src/resources/path.png";
        groundId = 1;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public TyleType landOn() {
        return PATH;
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public String graphicChange() {
        //Ej färdig
        return null;
    }
}
