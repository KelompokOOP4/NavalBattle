package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen2Frame implements ActionListener {
    private JFrame frame;
    private JButton levels[];
    private ImageIcon bgIcon;
    private String levelNames[];
    private JButton backLDR[];
    private JLabel myLabel;
    public Screen2Frame() {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/levelscreen.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        frame = new JFrame("Menu Utama");
        frame.add(myLabel);
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon ldrImage = new ImageIcon(this.getClass().getResource("/Resources/leaderboard.jpg"));
        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/Resources/back.jpg"));
        ImageIcon easyImage = new ImageIcon(this.getClass().getResource("/Resources/easy.jpg"));
        ImageIcon mediumImage = new ImageIcon(this.getClass().getResource("/Resources/medium.jpg"));
        ImageIcon hardImage = new ImageIcon(this.getClass().getResource("/Resources/hard.jpg"));
        backLDR = new JButton[2];
        backLDR[0] = new JButton(backImage);
        backLDR[1] = new JButton(ldrImage);
        backLDR[0].setBounds(20, 20 , 80, 30);
        backLDR[1].setBounds(20, 105 , 80, 30);
        this.configureBackLdrButtons();

        this.levels = new JButton[3];
        levels[0] = new JButton(easyImage);
        levels[1] = new JButton(mediumImage);
        levels[2] = new JButton(hardImage);
        levels[1].setEnabled(false);
        levels[2].setEnabled(false);
        this.configureLevelButtons();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        if (obj == levels[0]) {
            new Screen3Frame();
            frame.setVisible(false);
            frame.dispose();

        } else if (obj == backLDR[0]) {
            new MainFrame();
            frame.setVisible(false);
            frame.dispose();


        }

    }
    private void configureBackLdrButtons () {
        for (int i = 0; i < 2; i++) {
            backLDR[i].addActionListener(this);
            myLabel.add(backLDR[i]);
        }
    }

    private void configureLevelButtons ()
    {
        for (int i = 0; i < levels.length; i++) {
            levels[i].addActionListener(this);
            levels[i].setBounds(380, 200 + i * 50, 80, 30);
            myLabel.add(levels[i]);
        }
    }
}
