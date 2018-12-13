package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.TyleType;
import sourceCode.model.Unit;

/**
 * Author: Sebastian Arledal c17sal
 */
public abstract class Troop implements Unit {

    protected String graphic;
    private Position currentPosition;
    protected Position nextPosition;
    int hp;
    int speed;
    protected boolean alive;
    private boolean hasReachedGoal = false;
    private Direction direction;

    Troop(Position p, Direction direction) {
        this.currentPosition = p;
        this.direction = direction;
    }

    public Position getPosition() {
        return currentPosition;
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
