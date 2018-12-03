package sourceCode.model.Tile;
import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.QUICKSAND;

public class Quicksand extends Tile {

    public Quicksand(Position p) {
        this.p = p;
        graphic = "quicksand";
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
        return QUICKSAND;
    }

    @Override
    String graphicChange() {
        return null;
    }
}