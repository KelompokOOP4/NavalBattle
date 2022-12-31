package Codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bar extends JFrame implements ActionListener {
    private JFrame frame;
    private JProgressBar jbar;
    private JButton jbttn;

    public Bar()
    {
        frame = new JFrame("ProgressBar");
        frame.setLayout(new FlowLayout());
        frame.setSize(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(320,127,800,450);
        frame.setLayout(null);
        frame.setVisible(true);

        jbttn = new JButton("Button");
        jbttn.setBounds(250,150,100,29);
        jbttn.addActionListener(this);
        frame.add(jbttn);

        jbar = new JProgressBar(0,100);
        jbar.setBounds(190,111,30,160);
        jbar.setValue(0);
        jbar.setBackground(new Color(0,191,255));
        jbar.setForeground(new Color(127,255,0));
        jbar.setStringPainted(true);
        jbar.setOrientation(SwingConstants.VERTICAL);
        frame.add(jbar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jbar.setValue(jbar.getValue() + 10);
    }
}
