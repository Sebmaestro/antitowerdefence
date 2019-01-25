package sourceCode.model.tower;

import sourceCode.model.Position;

/**
 * Created by Dennis
 * 2019-01-21
 */
public class RegularTower extends Tower{

    /**
     * Constructor: creates a new RegularTower
     * @param p Position to create the tower at.
     */
    public RegularTower (Position p){
        super (p);
        damage = 1;
        range = 1;
        attackPeriod = 1;
    }
}
