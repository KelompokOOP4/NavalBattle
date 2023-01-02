package Codes.BaseEntities;

import java.util.ArrayList;

public abstract class Ship extends BaseObject {
    private int health;
    private int shield;
    private ArrayList<Bullet> ammo = new ArrayList<>();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public ArrayList<Bullet> getAmmo() {
        return ammo;
    }
    
}
