package sourceCode.model.Troop;

import sourceCode.model.Position;

public class TeleporterTroop extends Troop{

    public TeleporterTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 40;
        speed = 10;
        cost = 700;
    }
}
