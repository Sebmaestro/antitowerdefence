package tests.model;

import org.junit.*;
import static org.junit.Assert.*;

public class TroopTest {
    public TroopTest() {

    }

    @Test
    public void shouldBeAbleToCreateTroop() {
        RegularTroop regTroop = new RegularTroop();
        assertNotNull(regTroop);
    }

    @Test
    public void shouldHaveFullHP(){
        RegularTroop regTroop = new RegularTroop();
        assertEquals(regTroop.getHP(), 100);
    }

    @Test
    public void shouldBeAbleToTakeDamage(){
        RegularTroop regTroop = new RegularTroop();
        regTroop.recieveDamage(70);
        assertEquals(regTroop.getHP(), 30);
    }

    @Test
    public void shouldBeAbleToDie(){
        RegularTroop regTroop = new RegularTroop();
        regTroop.recieveDamage(100);
        assertFalse(regTroop.isAlive());
    }

    @Test public void shouldHaveSpeed(){
        RegularTroop regTroop = new RegularTroop();
        assertEquals(regTroop.getSpeed(), 10);
    }

    @Test public void shouldBeAbleToChangeSpeed(){
        RegularTroop regTroop = new RegularTroop();
        regTroop.setSpeed(3);
        assertEquals(regTroop.getSpeed(), 3);
    }
}

