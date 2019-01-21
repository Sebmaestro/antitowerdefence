package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal
 */
public class TankTroop extends Troop {

    /**
     * Constructor: Will initialize the TankTroop
     * @param p - the Position of the troop to start on
     * @param direction - The Direction the troop should
     *                  have from start
     */
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
