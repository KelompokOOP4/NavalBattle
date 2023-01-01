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
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/Background.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        frame = new JFrame("Menu Utama");
        frame.add(myLabel);;
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        backLDR = new JButton[2];
        backLDR[0] = new JButton("exit");
        backLDR[1] = new JButton("LEADERBOARD");
        backLDR[0].setBounds(20, 20 , 50, 50);
        backLDR[1].setBounds(20, 105 , 50, 50);
        this.configureBackLdrButtons();

        this.levels = new JButton[3];
        this.levelNames = new String[]{"LEVEL 1", "LEVEL 2", " LEVEL 3"};
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
            levels[i] = new JButton(levelNames[i]);
            levels[i].addActionListener(this);
            levels[i].setBounds(380, 200 + i * 50, 80, 30);
            myLabel.add(levels[i]);
        }
    }
}
