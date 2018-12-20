package sourceCode.model.tower;

import sourceCode.model.Position;

/**
 * Created by denni on 2018-12-03.
 */
public class RegularTower extends Tower{

    public RegularTower (Position p){
        super (p);
        damage = 3;
        range = 1;
        attackPeriod = 1;
    }
}
