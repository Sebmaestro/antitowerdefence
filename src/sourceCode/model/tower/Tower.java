package sourceCode.model.tower;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import sourceCode.model.Unit;
import java.util.ArrayList;

public abstract class Tower implements Unit {

    int damage;
    double range;
    double attackPeriod;
    protected Position p;
    private ArrayList<Troop> toAttack;

    public Tower(Position p) {
        this.p = p;
        toAttack = new ArrayList<>();
    }

    public Position getPosition() {
        return p;
    }

    public void addToAttackList(Troop t) {
        toAttack.add(t);
    }

    public ArrayList<Troop> getToAttackList() {
        return toAttack;
    }

    public void clearToAttackList() {
        toAttack.clear();
    }

    public void attack(Troop t) {
        t.receiveDamage(damage);
    }

    public boolean canReachTroop(Troop t) {
        Troop target;
        if(p.getPosToEast().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouthEast().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouth().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouthWest().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToWest().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorthWest().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorth().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorthEast().equals(t.getPosition())){
            target = t;
            attack(target);
            return true;
        } else {
            return false;
        }
    }
}



