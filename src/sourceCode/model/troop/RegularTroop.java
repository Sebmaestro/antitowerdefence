package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal c17sal | Dennis Karlman id15dkn
 */
public class RegularTroop extends Troop {

    /**
     * Constructor: Will initialize the RegularTroop
     * @param p - the Position of the troop to start on
     * @param direction - The Direction the troop should
     *                  have from start
     */
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
