package tests.model;

import org.junit.Test;
import sourceCode.model.Position;
import sourceCode.model.Tile.*;

import static org.junit.Assert.*;
import static sourceCode.model.Tile.TyleType.GOAL;

public class TileTest {
    @Test
    public void shouldBeAbleToCreateNewTile() {
        Tile tile = new RegularPath(new Position(1,1));
        assertNotNull(tile);
    }

    @Test
    public void shouldBeWalkable() {
        //Regularpath is walkable
        Tile tile = new RegularPath(new Position(1,1));
        assertTrue(tile.canWalk());
    }

    @Test
    public void shouldNotBeWalkable() {
        //Grass is not walkable
        Tile tile = new Grass(new Position(1, 1));
        assertFalse(tile.canWalk());
    }

    @Test
    public void shouldBeAbleToBuildTower() {
        Tile tile = new Grass(new Position(1, 1));
        assertTrue(tile.canBuildTower());
    }

    @Test
    public void shouldNotBeAbleToBuildTower() {
        Tile tile = new RegularPath(new Position(1,1));
        assertFalse(tile.canBuildTower());
    }

    @Test
    public void shouldBeAbleToGetGraphicString() {
        Tile tile = new Booster(new Position(1, 1));
        assertEquals("booster", tile.getGraphic());
    }

    @Test
    public void shouldBeCorrectLandOn() {
        Tile tile = new Goal(new Position(1, 1));
        assertEquals(GOAL, tile.landOn());
    }
}
