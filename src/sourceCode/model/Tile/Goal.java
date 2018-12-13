package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.GOAL;

public class Goal extends Tile {

    public Goal(Position p) {
        super(p);
        graphic = "src/resources/goal.png";
        groundId = 4;
    }

    @Override
    public boolean canWalk() {
        return true;
    }


    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public TyleType landOn() {
        return GOAL;
    }

    @Override
    public String graphicChange() {
        return null;
    }
}
