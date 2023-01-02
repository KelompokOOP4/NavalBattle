/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.BaseEntities;

import Codes.Handlers.Player2Control;
import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Abui
 */
public class PlayerTwo extends Ship {
    GameScreen gs;
    public Player2Control controller;
    Rectangle area = new Rectangle();
    int shootedBullet = 0,bulletPerSecond = 1, shootDelay=50;

    public PlayerTwo(GameScreen gs, Player2Control eh) {
        this.gs = gs;
        this.controller = eh;
        this.isDead = false;
        setDefaultValues();
        getImage();
    }
    @Override
    public void setDefaultValues(){
        setxLocation(100);
        setyLocation(200);
        setSpeed(4);
        setHealth(100);
        createCollisionArea();
    }
    @Override
    public void getImage(){
        try{
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ship.png")));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(){
        double x = getxLocation();
        double y = getyLocation();
        int centerxImage = (int) (x +(getSpriteWidth()/2));
        int centeryImage = (int) (y +(getSpriteHeight()/2));
        double speed = getSpeed();
        
        if(controller.upPressed==true){
            setyLocation(y-speed);
        }
        if(controller.downPressed==true){
            setyLocation(y+speed);
        }
        if(controller.leftPressed==true){
            setxLocation(x-speed);
        }
        if(controller.rightPressed==true){
            setxLocation(x+speed);
        }
        if(controller.shootPressed==true){
           if (shootedBullet<bulletPerSecond) {
                shootedBullet++;
                getAmmo().add(new Bullet(gs, (int)x+(getSpriteWidth()/2), (int)y+(getSpriteHeight()/2)));
            }else if(shootedBullet>shootDelay){
                shootedBullet=0;
            }else{
                shootedBullet++;
            }
        }
        if(centerxImage==getWindowWidth()){
            setxLocation(x-speed);
        }
        if(centeryImage==20){
            setyLocation(y+speed);
        }
        if(centerxImage==0){
            setxLocation(x+speed);
        }
        if(centeryImage==420){
            setyLocation(y-speed);
        }
        createCollisionArea();
    }
    
    @Override
    public void createCollisionArea() {
        area.width = (int) (getSpriteWidth() /3);
        area.height = (int) (getSpriteHeight() /3);
        area.x =  (int) ((getxLocation()+getSpriteWidth()/2) - (area.width/2));
        area.y = (int) ((getyLocation()+getSpriteHeight()/2) - (area.height/2));
        setCollisionArea(area);
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!isDead){
            super.draw(g2);
        }
        
    }
    
    
}
