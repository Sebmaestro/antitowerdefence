package sourceCode.model.tile;

import sourceCode.model.Position;
import sourceCode.model.troop.Direction;
import sourceCode.model.Unit;
import sourceCode.view.Screen;

import java.awt.*;

import static sourceCode.model.troop.Direction.*;


public abstract class Tile extends Rectangle implements Unit, LandOn {


    Direction dir;
    protected Position p;
    protected String graphic;
    protected int groundId;
    protected Position startp;

    boolean isWalkable;
    boolean canBuildTower;



    public Tile(Position p) {
        setBounds(235 + p.getX()*55,p.getY()*55,55,55);
        this.p = p;
    }

    public void draw(Graphics g){
        g.drawImage(Screen.tileset_ground[getGroundId()],x,y,width,height, null);

    }
    //Methods
    public int getGroundId() {
        return groundId;
    }
    public void setGroundId(int id) { groundId = id; }
    public abstract boolean canWalk();
    public abstract String graphicChange();
    public abstract boolean canBuildTower();

    public Position getPosition() {
        return p;
    }

    public String getGraphic() {
        return graphic;
    }

    public Position getStart(){ return startp;}

    /*
    public void clickOn() {
        opposite direction of startvalue
        if (dir == NORTH) {
            dir = SOUTH;
            graphic = "pathswitch south";
        } else
            dir = NORTH;
            graphic = "pathswitch north";

    }
    */

}
