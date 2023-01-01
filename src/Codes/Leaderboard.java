package Codes;

/**
 *
 * @author rizky
 */

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
public class Leaderboard extends JFrame{
=======
/*public class Leaderboard {
>>>>>>> 772a4ba742dd8009134687f9bb6a2671e943a43b
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;
    private String name;
    private int score;
    
    public Leaderboard(String name, int score){
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
    
    public void save(Score score) {
        try{
            query = "INSERT INTO leaderboard VALUES ('%s', %d)";
            query = String.format(query, score.getName(), score.getScore());
            stmt.executeUpdate(query);
            System.out.println("Congratulation for ypur score!");
        } catch (SQLException ex){
            System.err.print("Error inserting score: "+ex.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList<Leaderboard> getLeaderboard(){
        ArrayList<Leaderboard> leaderboard = new ArrayList<Leaderboard>();
        Leaderboard l = null;
        try{
            query = "SELECT * FROM leaderboard ORDER BY score DESC";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                l = new Leaderboard(rs.getString("name"), rs.getInt("score"));             
            }
            leaderboard.add(l);
        } catch (SQLException ex){
             System.err.print("Error getting the data: "+ex.getMessage());
             System.exit(1);
        }
        return leaderboard;
    }
<<<<<<< HEAD
    
    public static void print(){
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableMode();
        Object[] columnsName = new Object[2];
        columnsName [0] = "name";
        columnsName [1] = "score";
        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[2];
        for(int i = 0; i <= getLeaderboard().size(10); i++){
            rowData[0] = getLeaderboard().get(i).getName();
            rowData [1] = getLeaderboard().get(i).getScore();
            model.addRow(rowData);
        }
        table.setModel(model);
        System.out.println(getLeaderboard().size(10));
        print window = new print();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);
        window.setContentPane(panel);
    }
}
=======
}*/
>>>>>>> 772a4ba742dd8009134687f9bb6a2671e943a43b
