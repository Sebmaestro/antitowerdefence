package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.TELEPORTENTRY;
import static sourceCode.model.troop.Direction.EAST;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Teleport1 extends Tile {

    public Teleport1(Position p) {
        super(p);
        graphic = "src/Resources/teleporter1.png";
        directionAtExit = EAST;
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

        t.setDirection(getDirectionAtExit());
    }
}
