package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal
 */
public class TankTroop extends Troop {

    public TankTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 300;
        ordinarySpeed = 6;
        currentSpeed = ordinarySpeed;
        fastSpeed = ordinarySpeed/2;
        slowSpeed = ordinarySpeed*3;
        graphic = "Tank";
    }
}
