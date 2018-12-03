package tests.model;
import static org.junit.Assert.*;

import org.junit.*;

public class TowerTest {
    public TowerTest() {

    }

    @Test
    public void shouldBeAbleToCreateTower() {
        RegularTower rt = new RegularTower();

        assertNotNull(rt);

    }

    @Test
    public void shouldBeAbleToShootWhenInRange() {

    }

    @Test
    public void shouldNotBeAbleToShootWhenOutOfRange() {

    }
}
