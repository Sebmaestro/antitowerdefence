package tests.model;

import org.junit.*;
import sourceCode.model.Position;
import sourceCode.model.Troop.RegularTroop;

import static org.junit.Assert.*;

public class TroopTest {

    public TroopTest() {

    }

    @Test
    public void shouldBeAbleToCreateTroop() {
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        assertNotNull(regTroop);
    }

    @Test
    public void shouldHaveFullHP(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        assertEquals(regTroop.getHp(), 100);
    }

    @Test
    public void shouldBeAbleToTakeDamage(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        regTroop.receiveDamage(70);
        assertEquals(regTroop.getHp(), 30);
    }

    @Test
    public void shouldBeAbleToDie(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        regTroop.receiveDamage(100);
        assertFalse(regTroop.isAlive());
    }

    @Test public void shouldHaveSpeed(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        assertEquals(regTroop.getSpeed(), 10);
    }

    @Test public void shouldBeAbleToChangeSpeed(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1));
        regTroop.setSpeed(3);
        assertEquals(regTroop.getSpeed(), 3);
    }
}
