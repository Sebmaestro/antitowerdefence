package sourceCode.model.tower;

import sourceCode.model.Position;

/**
 * Created by Dennis
 * 2019-01-21
 */
public class RegularTower extends Tower{

    /**
     * Constructor: Will initialize a RegularTower
     */
    public RegularTower (Position p){
        super (p);
        damage = 1;
        range = 1;
        attackPeriod = 1;
    }
}
