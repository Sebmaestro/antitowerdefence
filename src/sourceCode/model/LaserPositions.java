package sourceCode.model;

/**
 * Created by denni on 2018-12-16.
 */
public class LaserPositions {
    private Position TowerPosition, TroopPosition;

    public LaserPositions(Position startPosition, Position endPosition){
        TowerPosition = startPosition;
        TroopPosition = endPosition;
    }

    public Position getTowerPosition(){
        return TowerPosition;
    }

    public Position getTroopPosition(){
        return TroopPosition;
    }
}
