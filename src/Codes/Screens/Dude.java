/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Screens;
/*
 *
 * @author slaya
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
 
public class Dude {
    int x, dx, y, dy, nx2, nx;
    Image ship;
 
    public Dude() {
        ImageIcon i = new ImageIcon (this.getClass().getResource("/gambar/ship1.png"));
        ship = i.getImage();
        x = 50; //posisi kapal dalam koordinat x
        y = -50; //posisi kapal dalam koordinat y
        nx2 = 787; //set pointt panjang background
        nx = 0;
    }
 
    public void move() {
        x = x + dx;
        y = y + dy;
        nx2 = nx2 +dx;
        nx = nx +dx;
    }
 
    public int getX() {
        return x;
    }
 
    public int getY() {
        return y;
    }
 
    public Image getImage() {
        return ship;
    }
 
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dx = -1;
 
        if (key == KeyEvent.VK_RIGHT)
            dx = 1;
        
        if (key == KeyEvent.VK_UP)
            dy = -1;
 
        if (key == KeyEvent.VK_DOWN)
            dy = 1;
    }
 
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
 
        if (key == KeyEvent.VK_LEFT)
            dx = 0;
 
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
        
        if (key == KeyEvent.VK_UP)
            dy = 0;
 
        if (key == KeyEvent.VK_DOWN)
            dy = 0;
    }
 
}
