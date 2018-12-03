package tests.model;


import org.junit.Test;
import sourceCode.model.Position;
import sourceCode.model.Tile.Goal;
import sourceCode.model.Tile.Tile;

import static org.junit.Assert.*;
import static sourceCode.model.Tile.TyleType.PATH;

public class GoalTest {

    @Test
    public void shouldCreateGoal() {
        Goal g = new Goal(new Position(1,1));
        assertNotNull(g);
    }

    @Test
    public void shouldBeWalkable() {
        Goal g = new Goal(new Position(1,1));
        assertTrue(g.canWalk());
    }

    @Test
    public void shouldNotBeBuildable() {
        Goal g = new Goal(new Position(1,1));
        assertFalse(g.canBuildTower());
    }

    @Test
    public void typeShouldBeGoal() {
        Goal g = new Goal(new Position(1,1));
        assertEquals(PATH, g.landOn());
    }

    @Test
    public void shouldBeCorrectGraphicString() {
        Tile g = new Goal(new Position(1,1));
        assertEquals("goal", g.getGraphic());
    }

}
