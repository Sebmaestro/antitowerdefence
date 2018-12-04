package sourceCode.model.Troop;

import sourceCode.model.Position;

public class TeleporterTroop extends Troop{

    public TeleporterTroop(Position p) {
        super(p);
        hp = 40;
        speed = 10;
        cost = 700;
    }
}
