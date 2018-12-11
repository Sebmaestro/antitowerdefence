package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreInfo;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void shouldBeAbleToCreateDatabase() {
        Database db = new Database();
        assertNotNull(db);
    }

    @Test
    public void shouldBeAbleToInsertToDatabase() {
        //Kanske inte behövs (ej färdig)
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        l.add(new HighscoreInfo("Person", "Map", 30));
    }

    @Test
    public void shouldBeAbleToGetTime() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        HighscoreInfo info = new HighscoreInfo("Person1", "Map1", 60);
        l.add(info);
        db.saveHighscores(l);
        assertEquals(60, db.getHighscores().get(0).getFinishTime());
    }

    @Test
    public void shouldBeAbleToGetPlayer() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1", "Map1", 40));
        db.saveHighscores(l);
        assertEquals("Person1", db.getHighscores().get(0).getPlayer());
    }

    @Test
    public void shouldBeAbleToGetMap() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1", "Map1", 60));
        db.saveHighscores(l);
        assertEquals("Map1", db.getHighscores().get(0).getMap());
    }

}
