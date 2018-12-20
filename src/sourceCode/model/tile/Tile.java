package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.Unit;

public abstract class Tile implements Unit, LandOn {
    Direction dir;
    protected Position p;
    protected String graphic;

    public Tile(Position p) {
        this.p = p;
    }

    public abstract boolean canWalk();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }
}
