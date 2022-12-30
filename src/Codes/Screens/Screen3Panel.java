package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen3Panel extends JPanel implements ActionListener{
    private JRadioButton char1[];
    private String levelNames[];
    private JRadioButton char2[];
    private JButton multiplayer[];
    private String multiNames[];
    private JButton back;
    private JButton start;
    private Screen3Frame parentWindow;


    public Screen3Panel (Screen3Frame x) {

        this.setLayout(null);
        this.char1 = new JRadioButton[4];
        this.levelNames = new String[]{"CR 1", "CR 2", " CR 3", "CR 4"};
        this.parentWindow = x;
        this.configureLevelButtons();
        char1[3].setEnabled(false);

        this.setLayout(null);
        this.char2 = new JRadioButton[4];
        this.parentWindow = x;
        this.configureChar2Buttons();

        this.multiplayer = new JButton[2];
        this.multiNames = new String[]{ "single","Multiplayer"};
        this.parentWindow = x;
        this.configureMultiButtons();

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/Resources/back.jpg"));
        this.setLayout(null);
        this.back = new JButton();
        back = new JButton("Back",backImage);
        back.setBounds(20, 20 , 50, 50);
        back.addActionListener(this);
        this.add(back);
        this.parentWindow = x;


        this.setLayout(null);
        this.start = new JButton();
        start = new JButton("START");
        start.setBounds(710, 20 , 60, 30);
        this.parentWindow = x;
        start.addActionListener(this);
        this.add(start);
        start.setEnabled(false);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
       if (obj == multiplayer[1]){
           start.setEnabled(false);
           multiplayer[1].setEnabled(false);
           multiplayer[0].setEnabled(true);
           for (int a = 0; a < char1.length; a++) {
               char1[a].setEnabled(true);
               char2[a].setEnabled(true);
               char1[a].setSelected(false);
           }
       } else if (obj == multiplayer[0]){
           start.setEnabled(false);
           multiplayer[0].setEnabled(false);
           multiplayer[1].setEnabled(true);
           for (int b = 0; b < char1.length; b++) {
               char1[b].setEnabled(true);
               char2[b].setEnabled(false);
               char2[b].setSelected(false);
           }
       }
       if (obj == multiplayer[0] && char1[0].isSelected() ||  char1[1].isSelected() ||  char1[2].isSelected() ||  char1[3].isSelected() ||  char1[0].isSelected() ){
           start.setEnabled(true);
       } else if (obj == multiplayer[1]  && char1[0].isSelected() ||  char1[1].isSelected() ||  char1[2].isSelected() ||  char1[3].isSelected() ||  char1[0].isSelected() && char2[0].isSelected() ||  char2[1].isSelected() ||  char2[2].isSelected() ||  char2[3].isSelected() ||  char2[0].isSelected()){
           start.setEnabled(true);
       }

        if (obj==back){
            new Screen2Frame();
            parentWindow.setVisible(false);
            parentWindow.dispose();
        }
    }
    private void configureLevelButtons () {
            for (int i = 0; i < char1.length; i++) {
                char1[i] = new JRadioButton(levelNames[i]);
                char1[i].addActionListener(this);
                char1[i].setBounds(150 + i * 150, 180, 80, 30);
                this.add(char1[i]);
                char1[i].setEnabled(false);
            }

        }
    private void configureMultiButtons () {
        for (int k = 0; k < multiplayer.length; k++) {
            multiplayer[k] = new JButton(multiNames[k]);
            multiplayer[k].addActionListener(this);
            multiplayer[k].setBounds(300 + k * 150, 20, 80, 30);
            this.add(multiplayer[k]);
        }
    }
    private void configureChar2Buttons () {
        for (int j = 0; j < char2.length; j++) {
            char2[j] = new JRadioButton(levelNames[j]);
            char2[j].addActionListener(this);
            char2[j].setBounds(150 + j * 150, 350, 80, 30);
            this.add(char2[j]);
            char2[j].setEnabled(false);
        }
    }
    }
