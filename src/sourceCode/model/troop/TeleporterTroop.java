package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal c17sal
 */
public class TeleporterTroop extends Troop {

    public TeleporterTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 40;
        ordinarySpeed = 4;
        currentSpeed = ordinarySpeed;
        fastSpeed = ordinarySpeed/2;
        slowSpeed = ordinarySpeed*3;
        troopID = 1;
        graphic = "Teleporter";
    }
}
