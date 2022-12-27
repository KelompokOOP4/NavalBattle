package Codes.Screens.Screen2;

import javax.swing.*;

public class Screen2Frame extends JFrame{
    private  Screen2Panel mainPanel;
    private ImageIcon bgIcon;
    private JLabel myLabel;

    public Screen2Frame()
    {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/picsay.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        this.add(myLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320, 127, 800, 450);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel = new Screen2Panel(this);
        this.getContentPane().add(mainPanel);

    }
}
