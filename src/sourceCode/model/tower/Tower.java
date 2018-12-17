package sourceCode.model.tower;
import sourceCode.model.Position;
import sourceCode.model.troop.Troop;
import sourceCode.view.Screen;
import sourceCode.model.troop.Troop;

import sourceCode.model.Unit;

import java.awt.*;
import java.util.ArrayList;

public abstract class Tower extends Rectangle implements Unit {

    public String Graphic;
    protected int damage;
    protected int towerID;
    protected double range;
    protected double attackPeriod;
    protected Troop target;
    protected Position p;
    protected ArrayList<Troop> toAttack;

    public Tower(Position p) {
        this.p = p;
        toAttack = new ArrayList<>();
    }

    public void draw(Graphics g){
       // g.drawImage(Screen.tileset_tower[getTowerID()],x,y,width,height, null);

    }

    public void addToAttack(Troop t){
        toAttack.add(t);
    }

    public ArrayList<Troop> getToAttack(){
        return toAttack;
    }

    public void clearAttackList(){
        toAttack.clear();
    }

    public int getTowerID(){return towerID;}

    public void attack(Troop t) {
        t.receiveDamage(damage);
    }

    public int getAttackDamage(){
        return damage;
    }

    public boolean canReachTroop(Troop t) {
        if(p.getPosToEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouthEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouth().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToSouthWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorthWest().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorth().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        }
        else if(p.getPosToNorthEast().equals(t.getPosition())){
            this.target = t;
            attack(target);
            return true;
        } else {
            return false;
        }

    }

}



