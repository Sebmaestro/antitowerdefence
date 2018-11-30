package tests.model;

import org.junit.Test;
import sourceCode.model.*;

import static org.junit.Assert.*;
import static sourceCode.model.TyleType.PATH;

public class PathTileTest {



    @Test
    public void shouldBeAbleToCreateNewPathTile() {
        Tile path = new Path(new Position(1,1));
        assertNotNull(path);
    }

    @Test
    public void shouldBeWalkable() {
        Tile path = new Path(new Position(1,1));
        assertTrue(path.canWalk());
    }

    @Test
    public void shouldNotBeAbleToBuildTower() {
        StaticTile path = new Path(new Position(1,1));
        //Only StaticTile has this method for obvious reasons
        assertFalse(path.canBuildTower());
    }

   @Test
   public void tileShouldHaveLandon() {
        Tile path = new Path(new Position(1,1));
        assertTrue(path.isLandOn());
    }

    @Test
    public void typeShouldBePath() {
        Tile path = new Path(new Position(1,1));
        assertEquals(PATH, path.landOn());
    }
}
