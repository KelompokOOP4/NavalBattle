/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Handlers;

import Codes.BaseEntities.BaseObject;
import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.util.LinkedList;

/**
 *
 * @author Abui
 */
public abstract class OtherObjectHandler {
     private LinkedList pack = new LinkedList();
     private GameScreen gs;

    public GameScreen getGs() {
        return gs;
    }

    public void setGs(GameScreen gs) {
        this.gs = gs;
    }

    public LinkedList getPack() {
        return pack;
    }
    public abstract void update();
    public abstract void draw(Graphics2D g2d);
}
