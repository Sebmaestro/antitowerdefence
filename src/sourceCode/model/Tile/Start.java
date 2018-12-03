package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.START;

public class Start extends Tile {

    public Start(Position p) {
        this.p = p;
        graphic = "start";
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
        return START;
    }
}
