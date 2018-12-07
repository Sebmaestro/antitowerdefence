package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;
import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void shouldBeAbleToCreateDatabase() {
        Database db = new Database();
        assertNotNull(db);
    }

/*
    @Test
    public void shouldBeAbleToQueryToDatabase() {
        Database db = new Database();
        db.runQuery("hej");
    }
*/
}
