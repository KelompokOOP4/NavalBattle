package Codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Bar {
    private int bounds;
    private String color;
    private String orientation;
    JProgressBar jb;

    public Bar(int boundsX,int boundsY, int boundsWidth, int boundsHeight,Color color, int orientation)
    {

        jb = new JProgressBar(0,100);
        jb.setBounds(boundsX,boundsY,boundsWidth,boundsHeight);
        jb.setBackground(color);
        jb.setBackground(color);
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


