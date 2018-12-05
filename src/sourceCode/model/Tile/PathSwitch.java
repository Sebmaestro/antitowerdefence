package sourceCode.model.Tile;

import sourceCode.model.Position;
import sourceCode.model.Troop.Direction;

import static sourceCode.model.Tile.TyleType.PATHSWITCH;
import static sourceCode.model.Troop.Direction.*;

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
