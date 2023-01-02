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
public class Player2Control implements KeyListener{
     public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode==KeyEvent.VK_W) {
            upPressed = true;
        }
        if (keyCode==KeyEvent.VK_S) {
            downPressed = true;
        }
        if (keyCode==KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (keyCode==KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (keyCode==KeyEvent.VK_Z) {
            shootPressed = true;
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode==KeyEvent.VK_W) {
            upPressed = false;
        }
        if (keyCode==KeyEvent.VK_S) {
            downPressed = false;
        }
        if (keyCode==KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (keyCode==KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (keyCode==KeyEvent.VK_Z) {
            shootPressed = false;
        }
        
    }
}
