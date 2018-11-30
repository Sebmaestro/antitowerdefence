package sourceCode.model.Tile;

import sourceCode.model.Unit;

public interface Tile extends Unit {

    boolean isWalkable = false;
    boolean canBuildTower = false;


    //Methods
    boolean canWalk();
    String getTileType();
    String graphicChange();
    boolean canBuildTower();
}
