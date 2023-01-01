package LeaderboardMenu;

import java.awt.Image;
import javax.swing.*;

public class LeaderboardFrame extends JFrame {
    private LeaderboardPanel  leaderboardPanel ; // the atribute

    public LeaderboardFrame(){
        this.setTitle("Independence Shooter"); //Title for the frame
        this.setSize(916,638); // set the size for the frame (match to the size of BG)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the abbility to close the program
        this.setLocationRelativeTo(null);
        this.setResizable(false); // the unabbility to resize the frame
        this.leaderboardPanel  = new LeaderboardPanel (this);
        this.getContentPane().add(leaderboardPanel ); // adding the MainPanel to the frame
        this.setVisible(true); // show the frame
        
        Image icon = new ImageIcon(this.getClass().getResource("/image/GameAsset/LogoGame.png")).getImage();
        this.setIconImage(icon);
    }
}
