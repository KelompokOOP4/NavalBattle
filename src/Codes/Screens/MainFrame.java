package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    private JFrame frame;
    private ImageIcon bgIcon;
    private JLabel myLabel;
    private JButton buttonsMenu[];
    private String buttonNames[];
    public MainFrame() {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/Background.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        frame = new JFrame("Menu Utama");
        frame.add(myLabel);
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        buttonsMenu = new JButton[4];
        buttonNames = new String[]{"START", "ABOUT", "CREDITS"};
        buttonsMenu[3] = new JButton("EXIT");
        buttonsMenu[3].setBounds(350, 330 , 80, 30);
        buttonsMenu[3].addActionListener(this);
        this.configureMenuButtons();
        myLabel.add(buttonsMenu[3]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        if (obj == buttonsMenu[0]) {
            new Screen2Frame();
            frame.setVisible(false);
            frame.dispose();

        } else if (obj == buttonsMenu[3]) {
            System.exit(1);

        }

    }

    private void configureMenuButtons () {
        for (int i = 0; i < 3; i++) {
            buttonsMenu[i] = new JButton(buttonNames[i]);
            buttonsMenu[i].addActionListener(this);
            buttonsMenu[i].setBounds(200 + i * 150, 250, 80, 30);
            myLabel.add(buttonsMenu[i]);
        }
    }
}
