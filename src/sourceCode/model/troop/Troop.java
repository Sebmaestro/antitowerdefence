package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.Tile;
import sourceCode.model.tile.TyleType;
import sourceCode.model.Unit;
import sourceCode.view.Screen;

import java.awt.*;


public abstract class Troop extends Rectangle implements Unit{


    protected String graphic;
    private Position currentPosition;
    private Position nextPosition;
    public Position east, south, west, north;


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

    public void move(Tile[][] tileMap){

        east = currentPosition.getPosToEast();
        south = currentPosition.getPosToSouth();
        west = currentPosition.getPosToWest();
        north = currentPosition.getPosToNorth();

        if(direction == Direction.EAST){
            System.out.println("öster");

            if(tileMap[east.getY()][east.getX()].canWalk()){
                setPosition(east);
            }
            else if(tileMap[south.getY()][south.getX()].canWalk()){
                setPosition(south);
                setDirection(Direction.SOUTH);
            }
            else if(tileMap[west.getY()][west.getX()].canWalk()){
                setPosition(west);
                setDirection(Direction.WEST);
            }
            else if(tileMap[north.getY()][north.getX()].canWalk()){
                setPosition(north);
                setDirection(Direction.NORTH);
            }
        }


        if(direction == Direction.SOUTH){
            System.out.println("söder");

            if(tileMap[south.getY()][south.getX()].canWalk()){
                setPosition(south);
                if(tileMap[south.getY()][south.getX()].getGraphic().equals("src/resources/goal.png")){
                    setGoalReached();
                }
            }
            else if(tileMap[west.getY()][west.getX()].canWalk()){
                setPosition(west);
                setDirection(Direction.WEST);
            }
            else if(tileMap[east.getY()][east.getX()].canWalk()){
                setPosition(east);
                setDirection(Direction.EAST);
            }
            else if(tileMap[north.getY()][north.getX()].canWalk()){
                setPosition(north);
                setDirection(Direction.NORTH);
            }

        }

        if(direction == Direction.WEST){
            System.out.println("väst");

            if(tileMap[west.getY()][west.getX()].canWalk()){
                setPosition(west);
            }
            else if(tileMap[north.getY()][north.getX()].canWalk()){
                setPosition(north);
                setDirection(Direction.NORTH);
            }
            else if(tileMap[east.getY()][east.getX()].canWalk()){
                setPosition(east);
                setDirection(Direction.EAST);
            }
            else if(tileMap[south.getY()][south.getX()].canWalk()){
                setPosition(south);
                setDirection(Direction.SOUTH);
            }
        }

        if(direction == Direction.NORTH){
            System.out.println("norr");

            if(tileMap[north.getY()][north.getX()].canWalk()){
                setPosition(north);
            }
            else if(tileMap[east.getY()][east.getX()].canWalk()){
                setPosition(east);
                setDirection(Direction.EAST);
            }
            else if(tileMap[south.getY()][south.getX()].canWalk()){
                setPosition(south);
                setDirection(Direction.SOUTH);
            }
            else if(tileMap[west.getY()][west.getX()].canWalk()){
                setPosition(west);
                setDirection(Direction.WEST);
            }
        }

    }

}
