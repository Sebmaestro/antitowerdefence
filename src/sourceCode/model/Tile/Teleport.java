package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.TELEPORT;

public class Teleport extends Tile {


    public Teleport(Position p) {
        super(p);
        graphic = "teleport";
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    String graphicChange() {
        return null;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public TyleType landOn() {
        return TELEPORT;
    }
}
