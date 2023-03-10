package tests.model;

import org.junit.*;
import sourceCode.model.Position;
import sourceCode.model.troop.RegularTroop;
import sourceCode.model.troop.Troop;

import static org.junit.Assert.*;
import static sourceCode.model.troop.Direction.*;

/**
 * Author: Sebastian Arledal
 */
public class TroopTest {

    public TroopTest() {

    }

    @Test
    public void shouldBeAbleToCreateTroop() {
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertNotNull(regTroop);
    }

    @Test
    public void shouldBeAbleToDie(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        regTroop.receiveDamage(100);
        assertFalse(regTroop.isAlive());
    }

    @Test public void shouldHaveSpeed(){
        RegularTroop regTroop = new RegularTroop(new Position(1,1), NORTH);
        assertEquals(regTroop.getOrdinarySpeed(), 2);
    }

    @Test public void shouldBeAbleToChangeSpeed(){
        Troop regTroop = new RegularTroop(new Position(1,1), NORTH);
        regTroop.setCurrentSpeed(3);
        assertEquals(regTroop.getCurrentSpeed(), 3);
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

    @Test
    public void shouldBeInGoalWhenReachedGoal() {
        Troop regTroop = new RegularTroop(new Position(1,1), EAST);
        regTroop.setGoalReached();
        assertTrue(regTroop.isGoalReached());
    }
}