/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Screens;
/*
 *
 * @author slayalir
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Board extends JPanel implements ActionListener {
    Dude p;
    public Image img;
    Timer time;
 
    public Board() {
        p = new Dude();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon (this.getClass().getResource("/gambar/backgroundocean1.png"));
        img = i.getImage();
        time = new Timer(5, this);
        time.start();
    }
 
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if ((p.getX() - 60) % 1600 == 0)// p.getX() == 590 || p.getX() == 2990) 590 & 2400
            p.nx = 0;
        if ((p.getX() - 860) % 1600 == 0)// p.getX() == 1790 || p.getX() == 4190) 1790 & 2400
            p.nx2 = 0;
        g2d.drawImage(img, 785-p.nx2, 0, null);
        if (p.getX() > 60)  //590
            g2d.drawImage(img, 785 - p.nx, 0, null); //685 - p.getnX
        
        g2d.drawImage(p.getImage(), 50, p.getY(), null);
    }
 
    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
 
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
    }
}