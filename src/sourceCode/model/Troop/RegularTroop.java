package sourceCode.model.Troop;

import sourceCode.model.Position;

public class RegularTroop extends Troop{

    public RegularTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 100;
        speed = 10;
        cost = 100;
    }
}
