package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.BOOSTER;

public class Booster extends Tile {

    public Booster(Position p) {
        super(p);
        graphic = "src/Resources/booster.png";
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
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
