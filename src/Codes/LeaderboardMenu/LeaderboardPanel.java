package Codes.LeaderboardMenu;

import Codes.Screens.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author rizky
 */
public class LeaderboardPanel extends JPanel implements ActionListener {
    private JButton backButton;
    private Graphics2D g2;
    private Image background;
    public LeaderboardPanel(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.backButton = new JButton();
        this.configureButton();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        background =new ImageIcon(getClass().getResource("/Resources/")).getImage();
    
        
    }
    
    private void configureButton()
    {
            ImageIcon im = new ImageIcon(this.getClass().getResource("/Resources/"));
            backButton = new JButton(im);
            backButton.addActionListener(this);
            backButton.setBounds(635, 535 , 250, 50);
            this.add(backButton);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj ==  backButton) {
            new MainFrame();
        }
    }


}
    

