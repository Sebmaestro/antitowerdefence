package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.TELEPORTEXIT;

public class TeleportExit extends Tile {

    public TeleportExit(Position p) {
        super(p);
        graphic = "teleportexit";
    }

    @Override
    public boolean canWalk() {
        return true;
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
        return TELEPORTEXIT;
    }
}
