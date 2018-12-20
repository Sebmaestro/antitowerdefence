package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;

import static sourceCode.model.tile.TyleType.GOAL;

/**
 * Author: Sebastian Arledal c17sal
 */
public class Goal extends Tile {

    public Goal(Position p) {
        super(p);
        graphic = "src/resources/goal.png";
    }

    @Override
    public boolean canWalk() {
        return true;
    }


    @Override
    public void landOn(Troop t) {
        t.setGoalReached();
    }

}
