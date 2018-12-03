package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.GRASS;

public class Grass extends Tile {

    public Grass(Position p) {
        this.p = p;
        graphic = "grass";
    }

    @Override
    public boolean canWalk() {
        return false;
    }


    @Override
    public String graphicChange() {
        return null;
    }

    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public TyleType landOn() {
        return GRASS;
    }
}
