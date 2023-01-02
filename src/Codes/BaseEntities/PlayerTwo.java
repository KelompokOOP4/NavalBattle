/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.BaseEntities;

import Codes.Handlers.Player2Control;
import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Abui
 */
public class PlayerTwo extends Ship {
    GameScreen gs;
    Player2Control controller;

    public PlayerTwo(GameScreen gs, Player2Control eh) {
        this.gs = gs;
        this.controller = eh;
        setDefaultValues();
        getImage();
    }
    @Override
    public void setDefaultValues(){
        setxLocation(400);
        setyLocation(400);
        setSpeed(4);
        setIsDead(false);
    }
    @Override
    public void getImage(){
        try{
            setSprite(ImageIO.read(getClass().getResourceAsStream("/images/ship.png")));
            
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
        if(centerxImage>768 || centeryImage>576 || centerxImage<0 || centeryImage<0){
            setIsDead(true);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!getIsDead()){
            super.draw(g2);
        }
        
    }
    
    
}
