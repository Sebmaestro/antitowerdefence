package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.BOOSTER;

public class Booster extends Tile {

    private Position p;

    public Booster(Position p) {
        this.p = p;
        graphic = "booster";
    }
    @Override
    public TyleType landOn() {
        return BOOSTER;
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public String getTileType() {
        return "booster";
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    Position getPosition() {
        return p;
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
