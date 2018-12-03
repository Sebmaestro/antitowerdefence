package sourceCode.model.Tile;

import sourceCode.model.Position;

import static sourceCode.model.Tile.TyleType.GOAL;

public class Goal extends Tile {

    private Position p;

    public Goal(Position p) {
        this.p = p;
        graphic = "goal";
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public String getTileType() {
        return "goal";
    }


    @Override
    public boolean canBuildTower() {
        return false;
    }

    @Override
    public Position getPosition() {
        return p;
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
