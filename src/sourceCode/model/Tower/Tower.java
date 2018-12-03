package sourceCode.model.Tower;

import sourceCode.model.Position;
import sourceCode.model.Troop.Troop;
import sourceCode.model.Unit;

public abstract class Tower implements Unit {
    public String Graphic;
    protected int damage;
    protected double range;
    protected double attackPeriod;
    protected Troop target;
    protected Position towerPosition;



    public void attack(Troop t){
        t.recieveDamage(damage);

    }

    public int getAttackDamage(){
        return damage;
    }
    public boolean canReachTroop(Troop t){

        if(towerPosition.getPosToEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToSouthEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToSouth().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToSouthWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToNorthWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToNorth().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(towerPosition.getPosToNorthEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else{
            return false;
        }

    }

}



