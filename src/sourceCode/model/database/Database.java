package sourceCode.model.database;

import javax.xml.transform.Result;
import java.sql.*;

public class Database {

    private String username = "v135h18g7";
    private String password = "9mY6HZRCjRo0Fa2k";
    private String database = "jdbc:mysql://mysql.cs.umu.se/";

    private Connection con;
    private ResultSet rs;
    private Statement s;

    public Database() {
        getDriver();
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            this.con = DriverManager.getConnection(database, username, password);
            s = con.createStatement();
            s.executeUpdate("USE v135h18g7");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void createDatabaseTable() {
        try {
            s.execute("CREATE TABLE IF NOT EXISTS highscore" +
                    "( HighScoreId int not null" +
                    "  PlayerName varchar(80) not null," +
                    "  Map varchar(80) not null," +
                    "  FinishTime int not null,"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(int HighscoreId, String PlayerName, String Map, int FinishTime) {
        /*
        String sql = "INSERT INTO highscore(HighscoreId, PlayerName, Map, FinishTime) " +
                "VALUES" + "("HighscoreId"+ , " + '"+PlayerName+"', '"+level+"', "+finish+")";
                */


        //String sql = "INSERT INTO highscore(HighscoreId, PlayerName, Map, FinishTime) " +
        //             "VALUES(" +HighscoreId + ", '" + PlayerName + "', '" + Map + "', " + FinishTime + ")";

        String sql = "INSERT INTO highscore(HighscoreId, PlayerName, Map, FinishTime) VALUES(?, ?, ?, ?)";

        try {
            con.setAutoCommit(false);
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, HighscoreId);
            p.setString(2, PlayerName);
            p.setString(3, Map);
            p.setInt(4, FinishTime);
            p.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData() {
        String sql = "SELECT PlayerName, FinishTime, Map FROM highscore";

        try {
            rs = s.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
