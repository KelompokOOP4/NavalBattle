package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits implements ActionListener {
    private JFrame frame;
    private JLabel myLabel;
    private JButton back;
    private ImageIcon bgIcon;

    public Credits() {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/credits.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800, 450);

        frame = new JFrame("About");
        frame.add(myLabel);
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/Resources/back.jpg"));
        back = new JButton(backImage);
        back.setBounds(20,20 , 80, 30);
        back.addActionListener(this);
        myLabel.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj== back) {
            new MainFrame();
            frame.setVisible(false);
            frame.dispose();
        }
    }
}