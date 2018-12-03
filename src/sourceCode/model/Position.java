package sourceCode.model;

import java.util.Objects;

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
     * Returns x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Returns position to south of current position
     * @return Position
     */
    public Position getPosToSouth() {
        return new Position(x, y-1);
    }

    /**
     * Returns position to north of current position
     * @return Position
     */
    public Position getPosToNorth() {
        return new Position(x, y+1);
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

    public Position getPosToNorthWest() { return new Position(x-1, y+1); }

    public Position getPosToNorthEast() { return new Position(x+1, y+1); }

    public Position getPosToSouthEast() { return new Position(x+1,y-1); }

    public Position getPosToSouthWest() { return new Position(x-1, y-1);}
    /**
     * Returns true if
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Position) &&
                this.getX() == ((Position)obj).getX() &&
                this.getY() == ((Position)obj).getY())
        {
            return true;
        }
        return false;
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

