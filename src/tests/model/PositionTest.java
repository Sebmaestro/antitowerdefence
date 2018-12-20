package tests.model;

import sourceCode.model.Position;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Author: Simon Lundkvist
 */
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
        assertEquals(pos1, pos2);
    }

    @Test
    public void shouldNotBeEqual() {
        Position pos1 = new Position(5,15);
        Position pos2 = new Position(5,20);
        assertNotEquals(pos1, pos2);
    }

    @Test
    public void getPosToWestTest() {
        Position pos = new Position(5,10);
        Position posToW = new Position(4,10);
        assertEquals(posToW, pos.getPosToWest());

    }

    @Test
    public void getPosToEastTest() {
        Position pos = new Position(5,10);
        Position posToE = new Position(6,10);
        assertEquals(posToE, pos.getPosToEast());
    }

    @Test
    public void getPosToNorthWestTest() {
        Position pos = new Position(5,10);
        Position posToNw = new Position(4,11);
        assertEquals(posToNw, pos.getPosToNorthWest());
    }

    @Test
    public void getPosToNorthEastTest() {
        Position pos = new Position(5,10);
        Position posToNe = new Position(6,11);
        assertEquals(posToNe, pos.getPosToNorthEast());
    }

    @Test
    public void getPosToSouthEastTest() {
        Position pos = new Position(5,10);
        Position posToSe = new Position(6,9);
        assertEquals(posToSe, pos.getPosToSouthEast());
    }

    @Test
    public void getPosToSouthWestTest() {
        Position pos = new Position(5,10);
        Position posToSw = new Position(4,9);
        assertEquals(posToSw, pos.getPosToSouthWest());
    }

}