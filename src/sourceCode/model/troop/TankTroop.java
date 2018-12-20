package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.TyleType;

public class TankTroop extends Troop {

    public TankTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 300;
        ordinarySpeed = 6;
        currentSpeed = ordinarySpeed;
        fastSpeed = ordinarySpeed/2;
        slowSpeed = ordinarySpeed*3;
        //troopID = 0;
        graphic = "Tank";
    }

    /*
    @Override
    public TyleType clickOn() {
        return null;
    }
    */
}