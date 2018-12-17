package sourceCode.model.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sebastian Arledal c17sal
 * 2018-12-13
 *
 * Class to initialize database and save/get info to/from database
 */
public class Database {

    private Connection con;
    private ResultSet rs;
    private Statement s;

    /**
     * Constructor: Will initialize the database
     */
    public Database() {
        getDriver();
        connectToDatabase();
    }

    /**
     * Connects to the database
     */
    private void connectToDatabase() {
        try {
            String username = "v135h18g7";
            String password = "9mY6HZRCjRo0Fa2k";
            String database = "jdbc:mysql://mysql.cs.umu.se/";
            this.con = DriverManager.getConnection(database, username, password);
            s = con.createStatement();
            s.executeUpdate("USE v135h18g7");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the driver
     */
    private void getDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves the current highscores into the database
     *
     * @param highscores - Object holding the score info
     * @param table - What database table to save info to
     */
    public void saveHighscores(List<HighscoreInfo> highscores, String table) {
        String sqlDelete;
        String sqlInsert;
        switch (table) {
            case "Map1":
                sqlDelete = "DELETE FROM Map1";
                sqlInsert = "INSERT INTO Map1(HighscoreId, " +
                        "PlayerName, FinishTime) VALUES(?, ?, ?)";
                break;
            case "Map2":
                sqlDelete = "DELETE FROM Map2";
                sqlInsert = "INSERT INTO Map2(HighscoreId, " +
                        "PlayerName, FinishTime) VALUES(?, ?, ?)";
                break;
            default:
                sqlDelete = "DELETE FROM Map3";
                sqlInsert = "INSERT INTO Map3(HighscoreId, " +
                        "PlayerName, FinishTime) VALUES(?, ?, ?)";
                break;
        }

        try {
            con.setAutoCommit(false);
            con.createStatement().execute(sqlDelete);
            for (int i = 0; i < highscores.size(); i++) {
                PreparedStatement p = con.prepareStatement(sqlInsert);
                p.setInt(1, i+1);
                p.setString(2, highscores.get(i).getPlayer());
                //p.setString(3, highscores.get(i).getMap());
                p.setInt(3, highscores.get(i).getFinishTime());
                p.executeUpdate();
            }
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the info stored in database
     *
     * @param table - What database table to get info from
     * @return highscores - The list containing the database info
     */
    public List<HighscoreInfo> getHighscores(String table) {
        String sql = null;

        switch (table) {
            case "Map1":
                sql = "SELECT PlayerName, FinishTime FROM Map1";
                break;
            case "Map2":
                sql = "SELECT PlayerName, FinishTime FROM Map2";
                break;
            default:
                sql = "SELECT PlayerName, FinishTime FROM Map3";
                break;
        }
        List<HighscoreInfo> highscores = new ArrayList<HighscoreInfo>();
        try {
            rs = s.executeQuery(sql);
            while(rs.next()) {
                highscores.add(new HighscoreInfo(rs.getString(1),
                        rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highscores;
    }
}
