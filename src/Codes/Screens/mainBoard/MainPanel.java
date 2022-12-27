package Codes.Screens.mainBoard;


import Codes.Screens.Screen2.Screen2Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener{
    private JButton buttonsMenu[];
    private MainFrame parentWindow;



    public MainPanel (MainFrame mainWindow) {

        this.setLayout(null);
        buttonsMenu = new JButton[4];
        buttonsMenu[0] = new JButton("START");
        buttonsMenu[1] = new JButton("ABOUT");
        buttonsMenu[2] = new JButton("HOW TO PLAY");
        buttonsMenu[3] = new JButton("EXIT");
        buttonsMenu[3].setBounds(350, 330 , 80, 30);
        buttonsMenu[3].addActionListener(this);
        this.add(buttonsMenu[3]);
        this.configureLevelButtons();
        this.parentWindow = mainWindow;
    }

    public void paintComponent (Graphics g) {
        super .paintComponent (g) ;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black) ;
        g2.drawString("SPACE SHOOTER", 250, 85);
        g2.setColor (new Color(100, 50, 150));
        g2.drawString("Berani coba?", 250, 120);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == buttonsMenu[0]) {
            new Screen2Frame();
            parentWindow.setVisible(false);
            parentWindow.dispose();

        } else if (obj == buttonsMenu[3]) {
            System.exit(1);

        }
    }

    private void configureLevelButtons ()
    {
        for (int i = 0; i < 3; i++) {
            buttonsMenu[i].setOpaque(false);
            buttonsMenu[i].addActionListener(this);
            buttonsMenu[i].setBackground(Color.BLACK);
            buttonsMenu[i].setForeground(Color.BLUE);
            buttonsMenu[i].setBounds(200+ i * 150, 250 , 80, 30);
            this.add(buttonsMenu[i]);
        }
    }
}
