package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.TyleType;
import sourceCode.model.Unit;
import sourceCode.view.Screen;

import java.awt.*;


public abstract class Troop extends Rectangle implements Unit{


    protected String graphic;
    private Position currentPosition;
    protected Position nextPosition;
    protected int troopID;
    int hp;
    int speed;
    protected boolean alive;
    private boolean hasReachedGoal = false;
    private Direction direction;

    Troop(Position p, Direction direction) {
        this.currentPosition = p;
        this.direction = direction;
    }

    public void draw(Graphics g){
        g.drawImage(Screen.tileset_troop[getTroopID()],x,y,width,height, null);

    }

    public Position getPosition() {
        return currentPosition;
    }

    public void setPosition(Position p){
        currentPosition = p;
    }

    /**
     * Set the goal boolean to true meaning that the troop has reached the goal
     */
    public void setGoalReached() {
        hasReachedGoal = true;
    }

    /**
     * Returns the boolean that tells us if goal is reached or not
     * @return
     */
    public boolean isGoalReached() {
        return hasReachedGoal;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void receiveDamage(int damage) {
        hp = hp - damage;
    }

    public void initHp() {
        //Sätts förmodligen i subklassens konstruktor
    }

    public int getHp() {
        return hp;
    }

    public int getTroopID(){return troopID;}

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getGraphic() {
        return graphic;
    }

    //For Teleporter troop only
    public abstract TyleType clickOn();

}
