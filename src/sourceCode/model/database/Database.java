package sourceCode.model.database;

import java.sql.*;

public class Database {

    private String username = "v135h18g7";
    private String password = "9mY6HZRCjRo0Fa2k";
    private String database = "jdbc:mysql://mysql.cs.umu.se/";

    private Connection con;
    private ResultSet rs;
    private Statement s;

    /*
    private String player;
    private int score;
    private int FinishTime;
    private String map;
    */

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
            Class.forName("com.mysql.jdbc.Driver");
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

    public void insertData(String PlayerName, double FinishTime, String Map) {
        String sql = "INSERT INTO highscore(PlayerName, FinishTime, Map) VALUES" + "('"+PlayerName+"', "+FinishTime+", '"+Map+"');";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        String sql = "SELECT PlayerName, FinishTime, Map FROM highscore";

        try {
            rs = s.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
