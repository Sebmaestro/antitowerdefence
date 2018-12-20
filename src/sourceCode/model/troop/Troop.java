package sourceCode.model.troop;

import sourceCode.model.Position;
import sourceCode.model.tile.Tile;
import sourceCode.model.Unit;

/**
 * Author: Dennis karlman
 */
public abstract class Troop implements Unit{


    protected String graphic;
    private Position currentPosition;
    private Position teleportEntry;
    private Position east, south, west, north;
    private int numberOfTeleportTiles;

    int troopID;
    int hp;
    int currentSpeed;
    private int untilMove;
    protected boolean alive;
    private boolean hasReachedGoal = false;
    private Direction direction;
    int ordinarySpeed, fastSpeed, slowSpeed;

    Troop(Position p, Direction direction) {
        this.currentPosition = p;
        this.direction = direction;
        this.untilMove = 0;
        this.numberOfTeleportTiles = 0;
    }


    public Position getPosition() {
        return currentPosition;
    }


    public int getFastSpeed(){
        return fastSpeed;
    }

    public int getSlowSpeed(){
        return slowSpeed;
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(int speed){
        this.currentSpeed = speed;
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
     * @return -
     */
    public boolean isGoalReached() {
        return hasReachedGoal;
    }

    public boolean isAlive() {
        return hp <= 0;
    }

    public int getUntilMove(){
        return untilMove;
    }

    public void incrementUntilMove(){
        untilMove++;
    }

    public void clearUntilMove(){
        untilMove = 0;
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

    public int getOrdinarySpeed() {
        return ordinarySpeed;
    }

    public String getGraphic() {
        return graphic;
    }

    public void incrementNumberOfTeleportTiles(){
        numberOfTeleportTiles++;
    }
    public int getNumberOfTeleportTiles(){
        return numberOfTeleportTiles;
    }

    public void setTeleportEntry(Position p){
        this.teleportEntry = p;
    }

    public Position getTeleportEntry(){
        return teleportEntry;
    }

    private void checkIfGoal(Tile[][] tileMap){

        if(tileMap[east.getY()][east.getX()].getGraphic().equals("src/resources/goal.png")){
            setPosition(east);
            setGoalReached();
        }
        else if(tileMap[south.getY()][south.getX()].getGraphic().equals("src/resources/goal.png")){
            setPosition(south);
            setGoalReached();
        }
        else if(tileMap[west.getY()][west.getX()].getGraphic().equals("src/resources/goal.png")){
            setPosition(west);
            setGoalReached();
        }
        else if(tileMap[north.getY()][north.getX()].getGraphic().equals("src/resources/goal.png")){
            setPosition(north);
            setGoalReached();
        }

    }


    public void move(Tile[][] tileMap){

        if(isGoalReached()){
            return;
        }

        east = currentPosition.getPosToEast();
        south = currentPosition.getPosToSouth();
        west = currentPosition.getPosToWest();
        north = currentPosition.getPosToNorth();



        if(direction == Direction.EAST){

            if (!tileMap[currentPosition.getY()][currentPosition.getX()].getGraphic().equals("src/resources/start.png")) {
                    checkIfGoal(tileMap);
            }


            if(!isGoalReached()) {
                if (tileMap[east.getY()][east.getX()].canWalk()) {
                    setPosition(east);
                } else if (tileMap[south.getY()][south.getX()].canWalk()) {
                    setPosition(south);
                    setDirection(Direction.SOUTH);
                } else if (tileMap[north.getY()][north.getX()].canWalk()) {
                    setPosition(north);
                    setDirection(Direction.NORTH);
                } else if (tileMap[west.getY()][west.getX()].canWalk()) {
                    setPosition(west);
                    setDirection(Direction.WEST);
                }
            }

        }


        if(direction == Direction.SOUTH){

            if (!tileMap[currentPosition.getY()][currentPosition.getX()].getGraphic().equals("src/resources/start.png")) {
                checkIfGoal(tileMap);
            }


            if(!isGoalReached()) {

                if (tileMap[south.getY()][south.getX()].canWalk()) {
                    setPosition(south);
                } else if (tileMap[west.getY()][west.getX()].canWalk()) {
                    setPosition(west);
                    setDirection(Direction.WEST);
                } else if (tileMap[east.getY()][east.getX()].canWalk()) {
                    setPosition(east);
                    setDirection(Direction.EAST);
                } else if (tileMap[north.getY()][north.getX()].canWalk()) {
                    setPosition(north);
                    setDirection(Direction.NORTH);
                }
            }

        }

        if(direction == Direction.WEST){

            if (!tileMap[currentPosition.getY()][currentPosition.getX()].getGraphic().equals("src/resources/start.png")) {
                checkIfGoal(tileMap);
            }


            if(!isGoalReached()) {

                if (tileMap[west.getY()][west.getX()].canWalk()) {
                    setPosition(west);
                } else if (tileMap[south.getY()][south.getX()].canWalk()) {
                    setPosition(south);
                    setDirection(Direction.SOUTH);
                } else if (tileMap[north.getY()][north.getX()].canWalk()) {
                    setPosition(north);
                    setDirection(Direction.NORTH);
                } else if (tileMap[east.getY()][east.getX()].canWalk()) {
                    setPosition(east);
                    setDirection(Direction.EAST);
                }
            }

        }

        if(direction == Direction.NORTH){

            if (!tileMap[currentPosition.getY()][currentPosition.getX()].getGraphic().equals("src/resources/start.png")) {
                checkIfGoal(tileMap);
            }


            if(!isGoalReached()) {
                if (tileMap[north.getY()][north.getX()].canWalk()) {
                    setPosition(north);
                } else if (tileMap[east.getY()][east.getX()].canWalk()) {
                    setPosition(east);
                    setDirection(Direction.EAST);
                } else if (tileMap[west.getY()][west.getX()].canWalk()) {
                    setPosition(west);
                    setDirection(Direction.WEST);
                } else if (tileMap[south.getY()][south.getX()].canWalk()) {
                    setPosition(south);
                    setDirection(Direction.SOUTH);
                }
            }

        }

    }
}
