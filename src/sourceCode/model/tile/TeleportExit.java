package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.TELEPORTEXIT;

/**
 * Author: Sebastian Arledal c17sal
 *
 * Kanske inte behövs
 */
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
    public void landOn(Troop t) {}
}
