package sourceCode.model.Troop;

import sourceCode.model.Position;
import sourceCode.model.Tile.TyleType;

public class RegularTroop extends Troop {

    public RegularTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 100;
        speed = 10;
        troopID = 0;
    }

    @Override
    public TyleType clickOn() {
        return null;
    }
}
