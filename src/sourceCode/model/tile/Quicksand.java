package sourceCode.model.tile;
import sourceCode.model.Position;

import static sourceCode.model.tile.TyleType.QUICKSAND;

public class Quicksand extends Tile {

    public Quicksand(Position p) {
        super(p);
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
    public String graphicChange() {
        return null;
    }
}
