package Codes.LeaderboardMenu;

import java.awt.Image;
import javax.swing.*;

public class LeaderboardFrame extends JFrame {
    private LeaderboardPanel  leaderboardPanel;

    public LeaderboardFrame(){
        this.setTitle("Naval Battle");
        this.setSize(916,638);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.leaderboardPanel  = new LeaderboardPanel (this);
        this.getContentPane().add(leaderboardPanel );
        this.setVisible(true);
        
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/")).getImage();
        this.setIconImage(icon);
    }
}
