package tests.model;

import sourceCode.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathTileTest {

    @Test
    public void shouldBeAbleToCreateNewPathTile() {
        Tile path = new Tile();
        assertNotNull(path);
    }

    @Test
    public void shouldBeWalkable() {
        Tile path = new Tile();
        assertTrue(path.canWalk());
    }

    @Test
    public void shouldNotBeAbleToBuildTower() {
        Tile path = new Tile();
        assertFalse(path.canBuildTower());
    }

   @Test
   public void tileShouldHaveLandon() {
        Tile path = new Tile();
        assertTrue(path.isLandon());
    }
}
