package tests.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PathTileTest {

    @Test
    public void shouldBeAbleToCreateNewPathTile() {
        Path path = new Path();
        assertNotNull(path);
    }

    @Test
    public void shouldBeWalkable() {
        Path path = new Path();
        assertTrue(path.canWalk());
    }

    @Test
    public void shouldNotBeAbleToBuildTower() {
        Path path = new Path();
        assertFalse(path.canBuildTower);
    }
    /*
   @Test
   public void shouldBeAbleToUseLandOn {

    }
    */



}
