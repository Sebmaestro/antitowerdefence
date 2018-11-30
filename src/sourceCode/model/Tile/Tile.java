package sourceCode.model.Tile;

import sourceCode.model.Unit;

public abstract class Tile implements Unit, LandOn {

    boolean isWalkable;
    boolean canBuildTower;


    //Methods
    public abstract boolean canWalk();
    abstract String getTileType();
    abstract String graphicChange();
    public abstract boolean canBuildTower();
}
