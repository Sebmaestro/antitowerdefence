package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal c17sal
 */
public class RegularTroop extends Troop {

    public RegularTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 100;
        ordinarySpeed = 2;
        currentSpeed = ordinarySpeed;
        fastSpeed = ordinarySpeed/2;
        slowSpeed = ordinarySpeed*3;
        troopID = 0;
        graphic = "Regular";
    }
}
