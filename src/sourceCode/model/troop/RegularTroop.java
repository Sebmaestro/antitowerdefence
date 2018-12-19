package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.TyleType;

/**
 * Author: Sebastian Arledal c17sal
 */
public class RegularTroop extends Troop {

    public RegularTroop(Position p, Direction direction) {
        super(p, direction);
        hp = 100;
        speed = 4;
        troopID = 0;
        graphic = "Regular";
    }

    @Override
    public TyleType clickOn() {
        return null;
    }

    //public Troop getTroop() {
      //  return RegularTroop.this;
    //}
}
