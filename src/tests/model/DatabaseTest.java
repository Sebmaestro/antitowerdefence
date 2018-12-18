package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreHandler;
import sourceCode.model.database.HighscoreInfo;

import javax.xml.crypto.Data;
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
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        l.add(new HighscoreInfo("Person", 30));
    }

    @Test
    public void shouldBeAbleToGetTime() {
        Database db = new Database();
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        HighscoreInfo info = new HighscoreInfo("Person1", 60);
        l.add(info);
        db.saveHighscores(l, "Map1");
        assertEquals(60, db.getHighscores(
                "Map1").get(0).getFinishTime());
    }

    @Test
    public void shouldBeAbleToGetPlayer() {
        Database db = new Database();
        ArrayList<HighscoreInfo> l = new ArrayList<>();
        l.add(new HighscoreInfo("Person1",40));
        db.saveHighscores(l, "Map2");
        assertEquals("Person1",
                db.getHighscores("Map2").get(0).getPlayer());
    }

    @Test
    public void shouldBeAbleToTakeNewHighscoreAndUpdateTable() {
        Database db = new Database();
        HighscoreHandler h = new HighscoreHandler(db.getHighscores("Level 2"));
        for (int i = 0; i < 15; i++) {
            if (h.addHighscoreToList(new HighscoreInfo
                    ("Sebbe", 1))) {
                break;
            }
        }
        h.checkAndInsertHighscore(new HighscoreInfo("Beast", 23));
        h.checkAndInsertHighscore(new HighscoreInfo("lalala", 1));
        db.saveHighscores(h.getList(), "Map2");
        List<HighscoreInfo> hslist = db.getHighscores("Map2");
        //assertEquals(hslist.get(5).getFinishTime(), 70);
    }

    @Test
    public void clearDatabase() {
        Database db = new Database();
        db.saveHighscores(new ArrayList<>(), "Level 2");
        db.saveHighscores(new ArrayList<>(), "Level 1");

        assertEquals(db.getHighscores("Level 2").size(), 0);
    }
}
