package sourceCode.model.Tile;

public class Booster extends Tile {
    @Override
    public TyleType landOn() {
        return null;
    }

    @Override
    public boolean canWalk() {
        return false;
    }

    @Override
    public String getTileType() {
        return null;
    }

    @Override
    public String graphicChange() {
        return null;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }
}
