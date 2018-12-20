package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import static sourceCode.model.troop.Direction.EAST;

/**
 * Author: Dennis Karlman / David Eriksson
 */
public class Teleport extends Tile {

    public Teleport(Position p) {
        super(p);
        graphic = "src/Resources/teleporter1.png";
        directionAtExit = EAST;
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public void landOn(Troop t) {

        t.setPosition(exitPosition);

        t.setDirection(getDirectionAtExit());
    }
}
