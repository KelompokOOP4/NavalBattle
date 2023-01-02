/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Abui
 */
public class Enemy extends Ship{

    GameScreen gs;
    Rectangle area = new Rectangle();

    public Enemy(GameScreen gs,int x,int y) {
        this.gs = gs;
        setxLocation(x);
        setyLocation(y);
        setDefaultValues();
        getImage();
    }
    
    @Override
    public void setDefaultValues() {
        setSpeed(4);
        setHealth(100);
        createCollisionArea();
    }

    @Override
    public void getImage() {
        try{
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ship_medium.png")));
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-getSprite().getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            setSprite(op.filter(getSprite(), null));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        double x = getxLocation();
        double y = getyLocation();
        int centerxImage = (int) (x +(getSpriteWidth()/2));
        int centeryImage = (int) (y +(getSpriteHeight()/2));
        double speed = getSpeed();
        setxLocation(x-speed);
        if(centerxImage<0 || centeryImage<0 || centeryImage>getWindowHeight()){
            this.isDead=true;
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
