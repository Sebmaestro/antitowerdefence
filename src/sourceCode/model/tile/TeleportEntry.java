package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.TELEPORTENTRY;

/**
 * Author: Sebastian Arledal c17sal
 */
public class TeleportEntry extends Tile {

    private Position exitPosition;

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
    public void landOn(Troop t) {
        t.setPosition(exitPosition);
    }

    public void setExitTpPosition(Position p) {
        exitPosition = p;
    }
}
