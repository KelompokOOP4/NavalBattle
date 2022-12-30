package Codes.Screens.mainBoard;

import Codes.Screens.mainBoard.MainPanel;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private  MainPanel mainPanel;
    private ImageIcon bgIcon;
    private JLabel myLabel;


    public MainFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320, 127, 800, 450);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new MainPanel(this);
        this.getContentPane().add(mainPanel);
    }
}
