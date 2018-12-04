package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.TOWERZONE;

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
    String graphicChange() {
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
