package Codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Bar {
    private int bounds;
    private int orientation;
    JProgressBar jb;

    public Bar(int progresBarmax, int boundsX,int boundsY, int boundsWidth, int boundsHeight,int orientation)
    {

        jb = new JProgressBar(0,progresBarmax);
        jb.setBounds(boundsX,boundsY,boundsWidth,boundsHeight);
        jb.setBackground(new Color(0,191,255));
        jb.setForeground(new Color(0,255,127));
        if(orientation == 0)
        {
            jb.setOrientation(SwingConstants.HORIZONTAL);
        }
        else
        {
            jb.setOrientation(SwingConstants.VERTICAL);
        }
        jb.setValue(0);
        jb.setStringPainted(true);

    }
    public void add(int input)
    {
        jb.setValue(input);
    }

}


