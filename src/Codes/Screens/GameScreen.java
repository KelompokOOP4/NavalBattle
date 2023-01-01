/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Screens;

import Codes.BaseEntities.PlayerOne;
import Codes.BaseEntities.PlayerTwo;
import Codes.Handlers.Player1Control;
import Codes.Handlers.Player2Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Abui
 */
public class GameScreen extends JPanel implements Runnable{

    private Player1Control p1c = new Player1Control();
    private Player2Control p2c = new Player2Control();
    private Thread gameThread;
    private boolean isMultiplayer;
    private PlayerOne p1 = new PlayerOne(this, p1c);
    private PlayerTwo p2 = new PlayerTwo(this, p2c);
    public Image img1,img2,img3;

    public GameScreen(boolean isMultiplayer) {
        this.setPreferredSize(new Dimension(800, 450));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(p1c);
        this.addKeyListener(p2c);
        this.setFocusable(true);
        this.isMultiplayer = isMultiplayer;
        
        ImageIcon i = new ImageIcon (this.getClass().getResource("/Resources/backgroundocean1.png"));
        img1 = i.getImage();
        img2 = i.getImage();
        img3 = i.getImage();
    }
    
    
    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
        
        
    }

    public void update() {
        p1.update();
        if(isMultiplayer){
         p2.update();
        }
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        p1.draw(g2);
        if(isMultiplayer){
         p2.draw(g2);
        }
        g2.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60; //Untuk bikin 60 FPS max. 1000000000 = 1s
        double frameUpdateTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
            update();
            repaint();
            
            try {
                double sleepTime = frameUpdateTime- System.nanoTime();
                sleepTime /= 1000000;
                if(sleepTime < 0){
                    sleepTime = 0;
                }
                
                Thread.sleep((long)sleepTime);
                frameUpdateTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}