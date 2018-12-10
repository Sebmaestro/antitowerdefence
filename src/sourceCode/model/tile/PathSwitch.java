package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;

import static sourceCode.model.tile.TyleType.PATHSWITCH;
import static sourceCode.model.troop.Direction.*;

public class PathSwitch extends Tile {

    public PathSwitch(Position p) {
        super(p);
        graphic = "pathswitch";
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
    public TyleType landOn() {
        return PATHSWITCH;
    }

    public Direction getDirection() {
        return dir;
    }
}
