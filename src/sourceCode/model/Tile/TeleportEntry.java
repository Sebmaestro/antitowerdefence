package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.TELEPORTENTRY;

public class TeleportEntry extends Tile {

    public TeleportEntry(Position p) {
        super(p);
        graphic = "teleportentry";
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
        return TELEPORTENTRY;
    }
}
