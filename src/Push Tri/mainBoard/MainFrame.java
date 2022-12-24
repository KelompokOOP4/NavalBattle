package mainBoard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private  MainPanel mainPanel;
    private ImageIcon bgIcon;
    private JLabel myLabel;


    public MainFrame()
    {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/startscreen.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        this.add(myLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setBounds(320, 127, 800, 450);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
    }
}
