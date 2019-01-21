package sourceCode.model.troop;

import sourceCode.model.Position;

/**
 * Author: Sebastian Arledal c17sal  Dennis Karlman id15dkn
 */
public class TeleporterTroop extends Troop {

    /**
     * Constructor: Will initialize the TeleporterTroop
     * @param p - the Position of the troop to start on
     * @param direction - The Direction the troop should
     *                  have from start
     */
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
