package sourceCode.model;

import static sourceCode.model.TyleType.*;

public class Path implements StaticTile {

    private Position p;

    public Path(Position p) {
        this.p = p;

    }

    @Override
    public boolean isLandOn() {
        return true;
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
    public String getTileType() {
        return "path";
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
