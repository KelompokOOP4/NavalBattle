/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.BaseEntities;

import Codes.Handlers.Player1Control;
import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Abui
 */
public class PlayerOne extends Ship{

    GameScreen gs;
    Player1Control controller;

    public PlayerOne(GameScreen gs, Player1Control eh) {
        this.gs = gs;
        this.controller = eh;
        setDefaultValues();
        getImage();
    }
    @Override
    public void setDefaultValues(){
        setxLocation(100);
        setyLocation(100);
        setSpeed(4);
        setHealth(200);
    }
    @Override
    public void getImage(){
        try{
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ship 1.png")));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(){
        double x = getxLocation();
        double y = getyLocation();
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
//            bm.addBullet(new Bullet(gs, x+(getSpriteWidth()/2), y+(getSpriteHeight()/2)));
        }
        
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
    }
    
}
