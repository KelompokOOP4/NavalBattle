package Codes.Screens.Screen3;

import javax.swing.*;

public class Screen3Frame extends JFrame{
    private  Screen3Panel mainPanel3;
    private ImageIcon bgIcon;
    private JLabel myLabel;

    public Screen3Frame()
    {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/loadingscreen.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        this.add(myLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(320, 127, 800, 450);
        this.setResizable(false);
        this.setVisible(true);
        this.mainPanel3 = new Screen3Panel(this);
        this.getContentPane().add(mainPanel3);

    }
}
