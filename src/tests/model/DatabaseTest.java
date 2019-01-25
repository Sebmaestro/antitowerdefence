package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void shouldBeAbleToCreateDatabase() {
        Database db = null;
        try {
            db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assertNotNull(db);
    }

    @Test
    public void shouldBeAbleToInsertToDatabase() {
        //Kanske inte behövs (ej färdig)
        try {
            Database db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        l.add(new HighscoreInfo("Person", 30));
    }

    @Test
    public void shouldBeAbleToGetTime() {
        Database db = null;
        try {
            db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        HighscoreInfo info = new HighscoreInfo("Person1", 60);
        l.add(info);
        try {
            db.saveHighscores(l, "Map1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            assertEquals(60, db.getHighscores(
                    "Map1").get(0).getFinishTime());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void shouldBeAbleToGetPlayer() {
        Database db = null;
        try {
            db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1",40));
        try {
            db.saveHighscores(l, "Map2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            assertEquals("Person1",
                    db.getHighscores("Map2").get(0).getPlayer());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void shouldBeAbleToTakeNewHighscoreAndUpdateTable() {
        Database db = null;
        try {
            db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        HighscoreHandler h = null;
        try {
            h = new HighscoreHandler(db.getHighscores("Level 2"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < 15; i++) {
            if (h.addHighscoreToList(new HighscoreInfo
                    ("Sebbe", 1))) {
                break;
            }
        }
        h.checkAndInsertHighscore(new HighscoreInfo("Beast", 23));
        h.checkAndInsertHighscore(new HighscoreInfo("lalala", 1));
        try {
            db.saveHighscores(h.getList(), "Map2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            List<HighscoreInfo> hslist = db.getHighscores("Map2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //assertEquals(hslist.get(5).getFinishTime(), 70);
    }

    @Test
    public void clearDatabase() {
        Database db = null;
        try {
            db = new Database();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            db.saveHighscores(new ArrayList<>(), "Level 2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            db.saveHighscores(new ArrayList<>(), "Level 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            assertEquals(db.getHighscores("Level 2").size(), 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
