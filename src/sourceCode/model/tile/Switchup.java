package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.troop.Troop;
import static sourceCode.model.troop.Direction.NORTH;

/**
 * Created by denni on 2018-12-17.
 */
public class Switchup extends Tile{

    public Switchup(Position p){
        super(p);
        graphic = "src/Resources/switch-up.png";
        dir = NORTH;
    }

    @Override
    public boolean canWalk() {
        return true;
    }


    @Override
    public void landOn(Troop t) {

        t.setDirection(NORTH);
    }

    public Direction getDirection() {
        return dir;
    }
}


