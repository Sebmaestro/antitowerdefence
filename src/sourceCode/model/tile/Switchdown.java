package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.Troop;
import static sourceCode.model.troop.Direction.SOUTH;

/**
 * Created by denni on 2018-12-17.
 */
public class Switchdown extends Tile{

    public Switchdown(Position p) {
        super(p);
        graphic = "src/Resources/switch-down.png";
        dir = SOUTH;
    }

    @Override
    public boolean canWalk() {
        return true;
    }


    @Override
    public void landOn(Troop t) {

        t.setDirection(SOUTH);
    }

    public Direction getDirection() {
        return dir;
    }
}

