package sourceCode.model.Troop;

import sourceCode.model.Position;

public class RegularTroop extends Troop{

    public RegularTroop(Position p) {
        super(p);
        hp = 100;
        speed = 10;
        cost = 100;
    }


}
