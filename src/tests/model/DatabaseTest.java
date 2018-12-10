package tests.model;

import org.junit.Test;
import sourceCode.model.database.Database;

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
        db.insertData(10, "Dennis", "Map1", 60);
    }

    @Test
    public void shouldBeAbleToRetrieveData() {
        Database db = new Database();

        ResultSet r = db.getData();

        while(true){
            try {
                if (!r.next()) break;
                System.out.println(r.getString(1));
                System.out.println(r.getString(2));
                System.out.println(r.getString(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
