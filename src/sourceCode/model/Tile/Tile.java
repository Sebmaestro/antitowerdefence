package sourceCode.model.Tile;

import sourceCode.model.Position;
import sourceCode.model.Unit;

public abstract class Tile implements Unit, LandOn {

    protected Position p;
    protected String graphic;

    boolean isWalkable;
    boolean canBuildTower;


    //Methods
    public abstract boolean canWalk();
    abstract String graphicChange();
    public abstract boolean canBuildTower();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }
}
