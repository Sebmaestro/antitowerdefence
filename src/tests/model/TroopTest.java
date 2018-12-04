package tests.model;

import org.junit.*;
import sourceCode.model.Position;
import sourceCode.model.Troop.Direction;
import sourceCode.model.Troop.RegularTroop;
import sourceCode.model.Troop.Troop;

import static org.junit.Assert.*;
import static sourceCode.model.Troop.Direction.*;

public class TroopTest {

    public TroopTest() {

    }

    @Test
    public void shouldBeAbleToCreateTroop() {
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertNotNull(regTroop);
    }

    @Test
    public void shouldHaveFullHP(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertEquals(regTroop.getHp(), 100);
    }

    @Test
    public void shouldBeAbleToTakeDamage(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        regTroop.receiveDamage(70);
        assertEquals(regTroop.getHp(), 30);
    }

    @Test
    public void shouldBeAbleToDie(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        regTroop.receiveDamage(100);
        assertFalse(regTroop.isAlive());
    }

    @Test public void shouldHaveSpeed(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertEquals(regTroop.getSpeed(), 10);
    }

    @Test public void shouldBeAbleToChangeSpeed(){
        Troop regTroop = new RegularTroop(new Position(1,1), NORTH);
        regTroop.setSpeed(3);
        assertEquals(regTroop.getSpeed(), 3);
    }

    @Test
    public void shouldHaveCorrectDirection() {
        Troop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertEquals(NORTH, regTroop.getDirection());
    }

    @Test
    public void shouldNotHaveCorrectDirectionIfDirectionIsSetWrong() {
        Troop regTroop = new RegularTroop(new Position(1,1), EAST);
        assertNotEquals(WEST, regTroop.getDirection());
    }

    @Test
    public void directionShouldBeSetCorrectly() {
        Troop regTroop = new RegularTroop(new Position(1,1), EAST);
        regTroop.setDirection(WEST);
        assertEquals(WEST, regTroop.getDirection());
    }
}
