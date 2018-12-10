package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;
import sourceCode.model.database.HighscoreInfo;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void shouldBeAbleToCreateDatabase() {
        Database db = new Database();
        assertNotNull(db);
    }

    @Test
    public void shouldBeAbleToInsertToDatabase() {
        Database db = new Database();
        //db.insertData(10, "Dennis", "Map1", 60);
    }

    @Test
    public void shouldBeAbleToRetrieveData() {
        Database db = new Database();
        ArrayList list = new ArrayList();
        db.saveHighscores(list);
        list = db.getHighscores();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void shouldBeAbleTo() {
        Database db = new Database();

        ArrayList list = db.getHighscores();
        list.add(new HighscoreInfo("sebbe", "map5", 300000));
        db.saveHighscores(list);

    }
}
