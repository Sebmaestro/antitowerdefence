/*
package tests.model;


import static org.junit.Assert.*;
import static sourceCode.model.troop.Direction.*;

import org.junit.*;
import sourceCode.model.Position;
import sourceCode.model.tower.*;
import sourceCode.model.troop.*;

public class TowerTest {

    @Test
    public void shouldBeAbleToCreateTower() {
        Tower rt = new RegularTower(new Position(1, 1));
        assertNotNull(rt);
    }

    @Test
    public void shouldBeAbleToShootWhenInRange() {
        Tower rt = new RegularTower(new Position(1, 1));
        RegularTroop regTroop = new RegularTroop(new Position(2,2), EAST);
        assertTrue(rt.canReachTroop(regTroop));
    }

    @Test
    public void shouldNotBeAbleToShootWhenOutOfRange() {
        RegularTower rt = new RegularTower(new Position(1, 1));
        RegularTroop regTroop = new RegularTroop(new Position(10, 10), WEST);
        assertFalse(rt.canReachTroop(regTroop));
    }

    @Test
    public void towerShouldDamageTroopWhenShooting() {
        Tower rt = new RegularTower(new Position(1, 1));
        RegularTroop regTroop = new RegularTroop(new Position(2,2), EAST);
        rt.attack(regTroop);
        assertEquals(99, regTroop.getHp());
    }
}
*/