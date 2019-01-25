package sourceCode.model;

/**
 * Created by denni
 * 2019-01-25
 *
 * Class to hold positions of lasers
 */

public class LaserPositions {
    private Position TowerPosition, TroopPosition;

    /**
     * Constructor for LaserPositions
     * @param startPosition - Start position of the laser
     * @param endPosition - End position of the laser
     */
    public LaserPositions(Position startPosition, Position endPosition){
        TowerPosition = startPosition;
        TroopPosition = endPosition;
    }

    /**
     * Gets the tower positions
     * @return TowerPosition - all tower positions
     */
    public Position getTowerPosition(){
        return TowerPosition;
    }

    /**
     * Gets the troop positions
     * @return TroopPosition - all the troops positions
     */
    public Position getTroopPosition(){
        return TroopPosition;
    }
}
