/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Handlers;

import Codes.BaseEntities.BaseObject;
import Codes.BaseEntities.Bullet;
import Codes.Screens.GameScreen;
import java.awt.Graphics2D;

/**
 *
 * @author Abui
 */
public class BulletHandler extends OtherObjectHandler{

    public Bullet bullet;

    public BulletHandler(GameScreen gs) {
        setGs(gs);
    }
    
    @Override
    public void update() {
        for(int i=0;i<getPack().size();i++){
            bullet = (Bullet) getPack().get(i);
            bullet.update();
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        for(int i=0;i<getPack().size();i++){
            bullet = (Bullet) getPack().get(i);
            bullet.draw(g2d);
        }
    }

    public void addObj(Bullet bullet) {
        getPack().add(bullet);
    }

    public void removeObj(Bullet bullet) {
        getPack().remove(bullet);
    }

    
    
    
}
