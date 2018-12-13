/**
 * Author: Sebastian Arledal c17sal
 */

package sourceCode.model.database;

import java.sql.*;
import java.util.ArrayList;

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

    //TABLE ÄR VILKEN MAP DET ÄR
    public void saveHighscores(ArrayList<HighscoreInfo> highscores, String table) {
        String sqlDelete = null;
        String sqlInsert = null;
        if (table.equals("Map1")){
            sqlDelete = "DELETE FROM Map1";
            sqlInsert = "INSERT INTO Map1(HighscoreId, " +
                    "PlayerName, FinishTime) VALUES(?, ?, ?)";
        } else {
            sqlDelete = "DELETE FROM Map2";
            sqlInsert = "INSERT INTO Map2(HighscoreId, " +
            "PlayerName, FinishTime) VALUES(?, ?, ?)";
        }
        try {
            con.setAutoCommit(false);
            con.createStatement().execute(sqlDelete);
            for (int i = 0; i < highscores.size(); i++) {
                PreparedStatement p = con.prepareStatement(sqlInsert);
                p.setInt(1, i);
                p.setString(2, highscores.get(i).getPlayer());
                //p.setString(3, highscores.get(i).getMap());
                p.setInt(3, highscores.get(i).getFinishTime());
                p.executeUpdate();
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HighscoreInfo> getHighscores(String table) {
        String sql = null;

        if (table.equals("Map1")) {
            sql = "SELECT PlayerName, FinishTime FROM Map1";
        } else {
            sql = "SELECT PlayerName, FinishTime FROM Map2";
        }
        ArrayList<HighscoreInfo> highscores = new ArrayList<HighscoreInfo>();
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
