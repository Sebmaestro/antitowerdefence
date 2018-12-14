package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.PATHSWITCH;
import static sourceCode.model.troop.Direction.*;

/**
 * Author: Sebastian Arledal c17sal
 */
public class PathSwitch extends Tile {

    public PathSwitch(Position p) {
        super(p);
        graphic = "src/Resources/switch-down.png";
        dir = SOUTH;
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
        t.setDirection(getDirection());
    }

    public void setDirection() {
        if (dir == NORTH) {
            dir = SOUTH;
            graphic = "src/Resources/switch-down.png";
        } else
            dir = NORTH;
        graphic = "src/Resources/switch-up.png";
    }

    public Direction getDirection() {
        return dir;
    }
}
