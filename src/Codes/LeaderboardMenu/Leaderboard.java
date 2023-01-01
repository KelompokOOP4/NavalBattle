package Codes.LeaderboardMenu;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author rizky
 */

public class Leaderboard {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;
    
    public Leaderboard(){
        url = "jdbc:mysql://localhost/navalbattle";
        uname = "root";
        pass = "";
        setConnectionAndStatement();
    }
    
    public void setConnectionAndStatement(){
        try {
            con = DriverManager.getConnection(url, uname, pass);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList <Leaderboard> getLeaderboard(){
        ArrayList<Leaderboard> leaderboard = new ArrayList<Leaderboard>();
        Leaderboard l = null;
        
        try{
            query = "SELECT * FROM leaderboard ORDER BY score DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                l = new Leaderboard(
                rs.getString("name"),
                rs.getInt("score"));
            }
            leaderboard.add(l);
            if(leaderboard == null){
                System.out.println("Data tidak ditemukan");
                System.exit(0);
            }
        } catch(SQLException ex){
            System.err.print("Error getting the data: "+ ex.getMessage());
            System.exit(1);
        }
        return leaderboard;
    }
    
    
    public void save (Leaderboard leaderboard){
        try {
            query = "INSERT INTO historysingleplayer (name, score) VALUES ('%s', '%d')";
            query = String.format(query, 
                    score.getName(),
                    score.getScore(),
            stmt.executeUpdate(query);
            System.out.println("Congratulation for your score!");
        }catch (SQLException ex) {
            System.err.print("Error inserting score " + ex.getMessage());
            System.exit(1);
        }
    }
}
