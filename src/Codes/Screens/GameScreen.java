/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Screens;

import Codes.Bar;
import Codes.BaseEntities.Bullet;
import Codes.BaseEntities.Enemy;
import Codes.BaseEntities.PlayerOne;
import Codes.BaseEntities.PlayerTwo;
import Codes.Handlers.Player1Control;
import Codes.Handlers.Player2Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
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
    private Image img1, img2, img3;
    private int nx1, nx2, nx3;
    private double finish=9000;
    private ArrayList<Bullet> ammoP1 = p1.getAmmo();
    private ArrayList<Bullet> ammoP2 = p2.getAmmo();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    Random randomizer = new Random();
    Bar objectiveBar;

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
        objectiveBar = new Bar((int) finish,20,20,700,50,0);
    }
    
    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start(); 
    }
    
    public void moveBackground(){
        nx1-=1;
        nx2-=1;
        nx3-=1;
        if(nx1<0){
            nx3=nx2+800;
        }
        if(nx2<0){
            nx1=nx3+800;
        }
        if(nx3<0){
            nx2=nx1+800;
        }
    }
    public void drawBackground(Graphics2D g2){
        g2.drawImage(img1, nx1,0, null);
        g2.drawImage(img2, nx2,0, null);
        g2.drawImage(img3, nx3,0, null);
    }
    public void checkCollision(){
        for(Bullet bullet : ammoP1){
            for(Enemy enemy : enemies){
                if(enemy.getCollisionArea().intersects(bullet.getCollisionArea())){
                    enemy.isDead = true;
                }   
            }
        }
        for(Bullet bullet : ammoP2){
            for(Enemy enemy : enemies){
                if(enemy.getCollisionArea().intersects(bullet.getCollisionArea())){
                    enemy.isDead = true;
                }   
            }
        }
    }
    
    public void enemySpawner(){
        int appearProx = randomizer.nextInt(500);
        int randomX = randomizer.nextInt(800,1600);
        int randomY = randomizer.nextInt(16,276);
        if(appearProx==7){
            enemies.add(new Enemy(this, randomX, randomY));
        }
    }

    public void update(){
        finish -= 0.5;
        objectiveBar.add((int) finish);
//        System.out.println(finish);
        enemySpawner();
        p1.update();
        System.out.println(p1.getyLocation());
        if(isMultiplayer){
            p2.update();
            for(Bullet bullet : ammoP2){
                bullet.update();
            }
        }
        for(Bullet bullet : ammoP1){
            bullet.update();
        }
        for(Enemy enemy : enemies){
            enemy.update();
        }
        checkCollision();
        moveBackground();
        
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        p1.draw(g2);
        for(Bullet bullet : ammoP1){
            bullet.draw(g2);
        }
        if(isMultiplayer){
            p2.draw(g2);
            for(Bullet bullet : ammoP2){
                bullet.draw(g2);
            }
        }
        for(Enemy enemy : enemies){
            enemy.draw(g2);
        }
        g2.dispose();
    }

    @Override
    public void run(){
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
                
            }catch(InterruptedException ex){
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}