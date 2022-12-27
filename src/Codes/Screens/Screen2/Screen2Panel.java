package Codes.Screens.Screen2;


import Codes.Screens.Screen3.Screen3Frame;
import Codes.Screens.mainBoard.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen2Panel extends JPanel implements ActionListener{
    private JButton levels[];
    private String levelNames[];
    private JButton back[];
    private Screen2Frame parentWindow;

    public Screen2Panel (Screen2Frame x) {

        this.setLayout(null);
        this.levels = new JButton[3];
        this.levelNames = new String[]{"LEVEL 1", "LEVEL 2", " LEVEL 3"};
        this.parentWindow = x;
        this.configureLevelButtons();

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/Resources/back.jpg"));
        ImageIcon ldr = new ImageIcon(this.getClass().getResource("/Resources/ExampleButton1.jpg"));
        this.setLayout(null);
        this.back = new JButton[2];
        back[0] = new JButton(backImage);
        back[1] = new JButton(ldr);
        back[0].setBounds(20, 20 , 50, 50);
        back[1].setBounds(20, 105 , 50, 50);
        this.parentWindow = x;
        this.configureLevel();
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == levels[0]) {
            new Screen3Frame();
            parentWindow.setVisible(false);
            parentWindow.dispose();

        } else if (obj == levels[1]) {
            parentWindow.setVisible(false);
            parentWindow.dispose();

        } else if (obj == levels[2]) {
            parentWindow.setVisible(false);
            parentWindow.dispose();

        }else if (obj == back[0]) {
            new MainFrame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }

    private void configureLevel ()
    {
        for (int k = 0; k < back.length; k++) {

            back[k].addActionListener(this);
            back[k].setBackground(new Color(230, 230, 250));
            this.add(back[k]);
        }
    }
    private void configureLevelButtons ()
    {
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new JButton(levelNames[i]);
            levels[i].addActionListener(this);
            levels[i].setBounds(380, 200 + i * 50, 80, 30);
            this.add(levels[i]);
        }
    }
}
