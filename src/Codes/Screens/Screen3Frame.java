package Codes.Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen3Frame implements ActionListener {
    private JFrame frame;
    private JButton levels[];
    private JRadioButton char1[];
    private String charNames[];
    private JRadioButton char2[];
    private JButton multiplayer[];
    private String multiNames[];
    private JButton back;
    private JButton start;
    private ImageIcon bgIcon;
    private JLabel myLabel;
    public Screen3Frame() {
        bgIcon = new ImageIcon(this.getClass().getResource("/Resources/Background.jpg"));
        myLabel = new JLabel(bgIcon);
        myLabel.setSize(800,450);

        frame = new JFrame("Menu Utama");
        frame.add(myLabel);;
        frame.setBounds(320, 127, 800, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        multiplayer = new JButton[2];
        this.multiNames = new String[]{ "single","Multiplayer"};
        this.configureMultiButtons();

        char1 = new JRadioButton[4];
        this.charNames = new String[]{"CR 1", "CR 2", " CR 3", "CR 4"};
        this.configureChar1Buttons();
        char1[3].setEnabled(false);

        this.char2 = new JRadioButton[4];
        this.charNames = new String[]{"CR 1", "CR 2", " CR 3", "CR 4"};
        this.configureChar2Buttons();

        back = new JButton();
        back = new JButton("Back");
        back.setBounds(20, 20 , 50, 50);
        back.addActionListener(this);
        myLabel.add(back);

        start = new JButton();
        start = new JButton("START");
        start.setBounds(710, 20 , 60, 30);
        start.addActionListener(this);
        myLabel.add(start);
        start.setEnabled(false);
    }

    @Override
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
        if (obj==char1[0]){
            char1[1].setSelected(false);
            char1[2].setSelected(false);
            char1[3].setSelected(false);
        } else if (obj==char1[1]){
            char1[0].setSelected(false);
            char1[2].setSelected(false);
            char1[3].setSelected(false);
        } else if (obj==char1[2]){
            char1[1].setSelected(false);
            char1[0].setSelected(false);
            char1[3].setSelected(false);
        }else if (obj==char1[3]){
            char1[1].setSelected(false);
            char1[2].setSelected(false);
            char1[0].setSelected(false);
        }

        if (obj==char2[0]){
            char2[1].setSelected(false);
            char2[2].setSelected(false);
            char2[3].setSelected(false);
        } else if (obj==char2[1]){
            char2[0].setSelected(false);
            char2[2].setSelected(false);
            char2[3].setSelected(false);
        } else if (obj==char2[2]){
            char2[1].setSelected(false);
            char2[0].setSelected(false);
            char2[3].setSelected(false);
        }else if (obj==char2[3]){
            char2[1].setSelected(false);
            char2[2].setSelected(false);
            char2[0].setSelected(false);
        }


        if (obj == multiplayer[0] && char1[0].isSelected() ||  char1[1].isSelected() ||  char1[2].isSelected() ||  char1[3].isSelected() ||  char1[0].isSelected() ){
            start.setEnabled(true);
        } else if (obj == multiplayer[1]  && char1[0].isSelected() ||  char1[1].isSelected() ||  char1[2].isSelected() ||  char1[3].isSelected() ||  char1[0].isSelected() && char2[0].isSelected() ||  char2[1].isSelected() ||  char2[2].isSelected() ||  char2[3].isSelected() ||  char2[0].isSelected()){
            start.setEnabled(true);
        }

        if (obj==back){
            new Screen2Frame();
            frame.setVisible(false);
            frame.dispose();
        }
    }

    private void configureMultiButtons () {
        for (int k = 0; k < multiplayer.length; k++) {
            multiplayer[k] = new JButton(multiNames[k]);
            multiplayer[k].addActionListener(this);
            multiplayer[k].setBounds(300 + k * 150, 20, 80, 30);
            myLabel.add(multiplayer[k]);
        }
    }

    private void configureChar1Buttons () {
        for (int i = 0; i < char1.length; i++) {
            char1[i] = new JRadioButton(charNames[i]);
            char1[i].addActionListener(this);
            char1[i].setBounds(150 + i * 150, 180, 80, 30);
            myLabel.add(char1[i]);
            char1[i].setEnabled(false);
        }

    }

    private void configureChar2Buttons () {
        for (int j = 0; j < char2.length; j++) {
            char2[j] = new JRadioButton(charNames[j]);
            char2[j].addActionListener(this);
            char2[j].setBounds(150 + j * 150, 350, 80, 30);
            myLabel.add(char2[j]);
            char2[j].setEnabled(false);
        }
    }
}
