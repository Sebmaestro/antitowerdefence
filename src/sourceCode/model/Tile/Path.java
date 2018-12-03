package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.*;

public class Path extends Tile {

    public Path(Position p) {
        this.p = p;
        graphic = "path";
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
        //Ej färdig
        return null;
    }
}
