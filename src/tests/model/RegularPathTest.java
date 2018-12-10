/*
package tests.model;

import org.junit.Test;
import sourceCode.model.*;
import sourceCode.model.tile.Path;
import sourceCode.model.tile.tile;

import static org.junit.Assert.*;
import static sourceCode.model.tile.TyleType.PATH;

public class RegularPathTest {

    @Test
    public void shouldBeAbleToCreateNewPathTile() {
        tile path = new Path(new Position(1,1));
        assertNotNull(path);
    }

    @Test
    public void shouldBeWalkable() {
        tile path = new Path(new Position(1,1));
        assertTrue(path.canWalk());
    }

    @Test
    public void shouldNotBeAbleToBuildTower() {
        tile path = new Path(new Position(1,1));
        assertFalse(path.canBuildTower());
    }

    @Test
    public void typeShouldBePath() {
        tile path = new Path(new Position(1,1));
        //Cant use tile because it does not have this
        //method as it is only used for the path
        assertEquals(PATH, path.landOn());
    }
}
*/