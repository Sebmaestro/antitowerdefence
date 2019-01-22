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

    /**
     * Constructor: Will initialize the Troop
     * @param p - the Position of the troop to start on
     * @param direction - The Direction the troop should
     *                  have from start
     */
    Troop(Position p, Direction direction) {
        this.currentPosition = p;
        this.direction = direction;
        this.untilMove = 0;
        this.numberOfTeleportTiles = 0;
    }


    /**
     * Gets the positions of the Troop
     * @return currentPosition - a position
     */
    public Position getPosition() {
        return currentPosition;
    }

    /**
     * gets the fast speed of the troop
     * @return fastSpeed - an int
     */
    public int getFastSpeed(){
        return fastSpeed;
    }

    /**
     * gets the slow speed of the troop
     * @return slowspeed - an int
     */
    public int getSlowSpeed(){
        return slowSpeed;
    }

    /**
     * gets the current speed of the troop
     * @return currentSpeed - an int
     */
    public int getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * sets the currentSpeed
     * @param speed - the speed
     */
    public void setCurrentSpeed(int speed){
        this.currentSpeed = speed;
    }

    /**
     * sets the position of the Troop
     * @param p - the position
     */
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
     * @return hasReachedGoal
     */
    public boolean isGoalReached() {
        return hasReachedGoal;
    }

    /**
     * returns true if the Troops hp is 0 or below that
     * @return
     */
    public boolean isAlive() {
        return hp <= 0;
    }

    /**
     * Gets untilMove - an int that decides the rate of which the troops move
     * @return untilMove - an int
     */
    public int getUntilMove(){
        return untilMove;
    }

    /**
     * Increments untilMove
     */
    public void incrementUntilMove(){
        untilMove++;
    }

    /**
     * Sets untilMove to zero
     */
    public void clearUntilMove(){
        untilMove = 0;
    }

    /**
     * Sets the Troops direction
     * @param direction - the Direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Gets the direction of the Troop
     * @return direction - A Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Deals damage to the Troop
     * @param damage - an int that reflects the damage to be dealt
     */
    public void receiveDamage(int damage) {
        hp = hp - damage;
    }

    /**
     * gets the ordinaryspeed of the Troop
     * @return ordinarySpeed - an int
     */
    public int getOrdinarySpeed() {
        return ordinarySpeed;
    }

    /**
     * gets the String that contains the desciption that connects this
     * object to the correct image.
     * @return graphic - A String
     */
    public String getGraphic() {
        return graphic;
    }

    /**
     * Since each teleporter only can lay down two teleporterTiles, this
     * increments if the teleporter lays down one of those.
     */
    public void incrementNumberOfTeleportTiles(){
        numberOfTeleportTiles++;
    }

    /**
     * gets the number of TeleportTiles that exists within the game
     * @return
     */
    public int getNumberOfTeleportTiles(){
        return numberOfTeleportTiles;
    }

    /**
     * Sets the position of the first teleportTile
     * @param p - the position for the first teleportTile
     */
    public void setTeleportEntry(Position p){
        this.teleportEntry = p;
    }

    /**
     * returns the position for the first teleportTile
     * @return teleportEntry - a Position
     */
    public Position getTeleportEntry(){
        return teleportEntry;
    }

    /**
     * checks if the goal is near the current position of the Troop
     * @param tileMap - all the level's tiles
     */
    private void checkIfGoal(Tile[][] tileMap){

        if(tileMap[east.getY()][east.getX()].getGraphic().equals("/goal.png")){
            setPosition(east);
            setGoalReached();
        }
        else if(tileMap[south.getY()][south.getX()].getGraphic().equals("/goal.png")){
            setPosition(south);
            setGoalReached();
        }
        else if(tileMap[west.getY()][west.getX()].getGraphic().equals("/goal.png")){
            setPosition(west);
            setGoalReached();
        }
        else if(tileMap[north.getY()][north.getX()].getGraphic().equals("/goal.png")){
            setPosition(north);
            setGoalReached();
        }

    }

    /**
     * The algorithm for the Troops movement. The troop always checks if
     * there's a goal nearby before it walks.
     * @param tileMap - all the level's tiles.
     */
    public void move(Tile[][] tileMap){

        if(isGoalReached()){
            return;
        }

        east = currentPosition.getPosToEast();
        south = currentPosition.getPosToSouth();
        west = currentPosition.getPosToWest();
        north = currentPosition.getPosToNorth();



        if(direction == Direction.EAST){

            if (!tileMap[currentPosition.getY()][currentPosition.getX()].getGraphic().equals("/start.png")) {
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
