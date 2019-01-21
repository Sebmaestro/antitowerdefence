package sourceCode.model;

import java.util.Objects;

/**
 * Author: Simon Lundkvist/Sebastian Arledal
 * 2019-01-21
 *
 * Position class to hold positions
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructs a position
     * @param x - position x
     * @param y - position y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x position
     * @return x - x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get y position
     * @return y - y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Returns position to south of current position
     * @return Position
     */
    public Position getPosToSouth() {
        return new Position(x, y+1);
    }

    /**
     * Returns position to north of current position
     * @return Position
     */
    public Position getPosToNorth() {
        return new Position(x, y-1);
    }

    /**
     * Returns position to west of current position
     * @return Position
     */
    public Position getPosToWest() {
        return new Position(x-1, y);
    }

    /**
     * Returns position to east of current position
     * @return Position
     */
    public Position getPosToEast() {
        return new Position(x+1, y);
    }

    /**
     * Returns position to northwest
     * @return position
     */
    public Position getPosToNorthWest() { return new Position(x-1, y+1); }

    /**
     * Returns position to northeast
     * @return position
     */
    public Position getPosToNorthEast() { return new Position(x+1, y+1); }

    /**
     * Returns position to southeast
     * @return position
     */
    public Position getPosToSouthEast() { return new Position(x+1,y-1); }

    /**
     * Returns position to southwest
     * @return position
     */
    public Position getPosToSouthWest() { return new Position(x-1, y-1);}

    /**
     * Checks if obj is instance of position and equals a certain position
     * @param obj - obj
     * @return boolean - true or false
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Position) &&
                this.getX() == ((Position) obj).getX() &&
                this.getY() == ((Position) obj).getY();
    }

    /**
     * Returns hashcode for given position
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}

