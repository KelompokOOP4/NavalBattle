package Codes.BaseEntities;

public abstract class Ship extends BaseObject {
    private int health;
    private int shield;

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
    
    
}
