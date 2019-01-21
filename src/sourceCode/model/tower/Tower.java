package sourceCode.model.tower;

import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import sourceCode.model.Unit;
import java.util.ArrayList;

/**
 * Author: Dennis karlman
 * 2019-01-21
 */
public abstract class Tower implements Unit {

    int damage;
    double range;
    double attackPeriod;
    protected Position p;
    private ArrayList<Troop> toAttack;

    /**
     * Constructor: Will initialize the Game
     * @param p - Position of the tower
     */
    Tower(Position p) {
        this.p = p;
        toAttack = new ArrayList<>();
    }

    /**
     * Position of the tower
     * @return p - a Position
     */
    public Position getPosition() {
        return p;
    }

    /**
     * Adds a troop to an list which the tower attacks
     * @param t - Troop to attack
     */
    public void addToAttackList(Troop t) {
        toAttack.add(t);
    }

    /**
     * Gets the List with Troops to attack
     * @return toAttack - an ArrayList<Troop>
     */
    public ArrayList<Troop> getToAttackList() {
        return toAttack;
    }

    /**
     * Clears the list with Troops to attack
     */
    public void clearToAttackList() {
        toAttack.clear();
    }

    /**
     * Deals damage to a troop
     * @param t - the Troop to deal damage to
     */
    private void attack(Troop t) {
        t.receiveDamage(damage);
    }

    /**
     * Checks if a tower can reach a troop. If the tower can reach it,
     * it calls on the method attack()
     * @param t - Troop to attack
     * @return true if it can reach the Troop, else false
     */
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



