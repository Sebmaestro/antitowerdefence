package sourceCode.model.Tile;

import sourceCode.model.Position;
import sourceCode.model.Unit;

public abstract class Tile implements Unit, LandOn {

    String graphic;
    boolean isWalkable;
    boolean canBuildTower;


    //Methods
    public abstract boolean canWalk();
    abstract String getTileType();
    abstract String graphicChange();
    public abstract boolean canBuildTower();

    abstract Position getPosition();

    public String getGraphic() {
        return graphic;
    }
}
