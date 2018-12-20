package tests.model;

import org.junit.Test;
import sourceCode.model.Position;
import sourceCode.model.tile.*;


import static org.junit.Assert.*;

/**
 * Author: Sebastian Arledal
 */
public class TileTest {
    @Test
    public void shouldBeAbleToCreateNewTile() {
        Tile tile = new Path(new Position(1,1));
        assertNotNull(tile);
    }

    @Test
    public void shouldGetCorrectPosition() {
        Tile tile = new Goal(new Position(5, 5));
        Position p = new Position(5, 5);
        assertEquals(p, tile.getPosition());
    }

    @Test
    public void shouldBeWalkable() {
        //Regularpath is walkable
        Tile tile = new Path(new Position(1,1));
        assertTrue(tile.canWalk());
    }

    @Test
    public void shouldNotBeWalkable() {
        //Grass is not walkable
        Tile tile = new Grass(new Position(1, 1));
        assertFalse(tile.canWalk());
    }

    @Test
    public void shouldBeFalseIfGraphicStringIsIncorrect() {
        Tile tile = new Booster(new Position(1, 1));
        assertNotEquals("path", tile.getGraphic());
    }
}
