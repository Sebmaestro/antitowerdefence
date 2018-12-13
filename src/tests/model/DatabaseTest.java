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
        l.add(new HighscoreInfo("Person", 30));
    }

    @Test
    public void shouldBeAbleToGetTime() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        HighscoreInfo info = new HighscoreInfo("Person1", 60);
        l.add(info);
        db.saveHighscores(l, "Map1");
        assertEquals(60, db.getHighscores("Map1").get(0).getFinishTime());
    }

    @Test
    public void shouldBeAbleToGetPlayer() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1",40));
        db.saveHighscores(l, "Map2");
        assertEquals("Person1", db.getHighscores("Map2").get(0).getPlayer());
    }

    @Test
    public void shouldBeAbleToAddTwoRows() {
        Database db = new Database();
        ArrayList l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1",40));
        l.add(new HighscoreInfo("Person2",30));
        l.add(new HighscoreInfo("Person3",45));
        db.saveHighscores(l, "Map1");
        db.saveHighscores(l, "Map2");
    }
}
