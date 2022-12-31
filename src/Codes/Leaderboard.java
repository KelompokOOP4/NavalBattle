package Codes;

/**
 *
 * @author rizky
 */

import java.sql.*;
import java.util.*;

/*public class Leaderboard {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;
    
    public Leaderboard() {
    url = "jdbc:mysql://localhost/leaderboard";
    uname = "root";
    pass = "";
    setConnectionAndStatement();
    }

    private void setConnectionAndStatement(){
       try{
           con = DriverManager.getConnection(url, uname, pass);
           stmt = con.createStatement();
       } catch (SQLException ex){
           System.err.print(ex.getMessage());
           System.exit(1);
       }
    }
    
    private static class Score {
        public Score() {
        }
    }
        
    public void save(Score score) {
        try{
            query = "INSERT INTO leaderboard VALUES ('%s', %d)";
            query = String.format(query, score.getName(), score.getScore());
            stmt.executeUpdate(query);
            System.out.println("Congratulation for your score!");
        } catch (SQLException ex){
            System.err.print("Error inserting score: "+ex.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList<Leaderboard> getAll() {
        ArrayList<Leaderboard> allLeaderboard = new ArrayList<>();
        try {
            query = "SELECT * FROM leaderboard ORDER BY score DESC";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                allLeaderboard.add(new Leaderboard(rs.getString(1), rs.getInt(2));
            }
        } catch(SQLException ex){
            System.err.print("Error getting the score: "+ex.getMessage());
            System.exit(1);
        }
        return allLeaderboard;
    }
}*/
