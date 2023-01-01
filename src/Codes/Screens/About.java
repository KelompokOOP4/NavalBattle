package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {
    private JFrame frame;
    private JLabel myLabel;
    private JButton next;
    private JButton back;
    private ImageIcon bgIcon;

    public About() {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/deskripsi.png"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800, 450);

        frame = new JFrame("About");
        frame.add(myLabel);
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/Resources/back.jpg"));
        ImageIcon nextImage = new ImageIcon(this.getClass().getResource("/Resources/next.jpg"));
        next = new JButton(nextImage);
        next.setBounds(690,380 , 80, 30);
        next.addActionListener(this);
        myLabel.add(next);
        back = new JButton(backImage);
        back.setBounds(20,20 , 80, 30);
        back.addActionListener(this);
        myLabel.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj== next) {
            new HowToPlay();
            frame.setVisible(false);
            frame.dispose();
        } else if(obj== back) {
            new MainFrame();
            frame.setVisible(false);
            frame.dispose();
        }
    }
}