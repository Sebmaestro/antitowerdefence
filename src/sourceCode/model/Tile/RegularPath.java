package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.*;

public class RegularPath extends Tile {

    private Position p;

    public RegularPath(Position p) {
        this.p = p;
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