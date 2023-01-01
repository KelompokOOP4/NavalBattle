/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Abui
 */
public class Player1Control implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode==KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (keyCode==KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (keyCode==KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (keyCode==KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (keyCode==KeyEvent.VK_J){
            shootPressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode==KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (keyCode==KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (keyCode==KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (keyCode==KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (keyCode==KeyEvent.VK_SPACE){
            shootPressed = false;
        }
    }
}
