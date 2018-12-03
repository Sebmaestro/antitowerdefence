package tests.model;

import sourceCode.model.Position;

import org.junit.Test;
import static org.junit.Assert.*;


public class PositionTest {

    @Test
    public void shouldCreatePosition() {
        new Position(1,2);
    }

    @Test
    public void shouldReturnCorrectX() {
        Position pos = new Position(1,2);
        assertEquals(1, pos.getX());
    }

    @Test
    public void shouldReturnCorrectY() {
        Position pos = new Position(1,2);
        assertEquals(2, pos.getY());
    }

    @Test
    public void shouldBeEqual() {
        Position pos1 = new Position(5,15);
        Position pos2 = new Position(5,15);
        assertTrue(pos1.equals(pos2));
    }

    @Test
    public void shouldNotBeEqual() {
        Position pos1 = new Position(5,15);
        Position pos2 = new Position(5,20);
        assertFalse(pos1.equals(pos2));
    }

    @Test
    public void getPosToWestTest() {
        Position pos = new Position(5,10);
        Position posToW = new Position(4,10);
        assertTrue(posToW.equals(pos.getPosToWest()));

    }

    @Test
    public void getPosToNorthTest() {
        Position pos = new Position(5,10);
        Position posToN = new Position(5,11);
        assertTrue(posToN.equals(pos.getPosToNorth()));
    }

    @Test
    public void getPosToEastTest() {
        Position pos = new Position(5,10);
        Position posToE = new Position(6,10);
        assertTrue(posToE.equals(pos.getPosToEast()));
    }

    @Test
    public void getPosToSouthTest() {
        Position pos = new Position(5,10);
        Position posToS = new Position(5,9);
        assertTrue(posToS.equals(pos.getPosToSouth()));
    }

    @Test
    public void getPosToNorthWestTest() {
        Position pos = new Position(5,10);
        Position posToNw = new Position(4,11);
        assertTrue(posToNw.equals(pos.getPosToNorthWest()));
    }

    @Test
    public void getPosToNorthEastTest() {
        Position pos = new Position(5,10);
        Position posToNe = new Position(6,11);
        assertTrue(posToNe.equals(pos.getPosToNorthEast()));
    }

    @Test
    public void getPosToSouthEastTest() {
        Position pos = new Position(5,10);
        Position posToSe = new Position(6,9);
        assertTrue(posToSe.equals(pos.getPosToSouthEast()));
    }

    @Test
    public void getPosToSouthWestTest() {
        Position pos = new Position(5,10);
        Position posToSw = new Position(4,9);
        assertTrue(posToSw.equals(pos.getPosToSouthWest()));
    }

}
