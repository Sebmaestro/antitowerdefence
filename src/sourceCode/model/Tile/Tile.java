package sourceCode.model.Tile;

import sourceCode.model.Position;
import sourceCode.model.Troop.Direction;
import sourceCode.model.Unit;

import static sourceCode.model.Troop.Direction.*;

public abstract class Tile implements Unit, LandOn {

    protected Direction dir;
    protected Position p;
    protected String graphic;

    boolean isWalkable;
    boolean canBuildTower;

    public Tile(Position p) {
        this.p = p;
    }


    //Methods
    public abstract boolean canWalk();
    public abstract String graphicChange();
    public abstract boolean canBuildTower();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }

    //For pathwswitch only
    public void clickOn() {
        //opposite direction of startvalue
        if (dir == NORTH) {
            dir = SOUTH;
            graphic = "pathswitch south";
        } else
            dir = NORTH;
            graphic = "pathswitch north";
    }
}
