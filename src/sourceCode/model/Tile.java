package sourceCode.model;

public interface Tile extends Unit {

    public boolean isWalkable = false;
    public boolean canBuildTower = false;


    //Methods
    public boolean canWalk();
    public String getTileType();
    public String graphicChange();
    public boolean canBuildTower();
}
