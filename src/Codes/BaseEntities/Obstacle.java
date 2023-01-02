package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Obstacle extends BaseObject {
    private boolean isRock, isCrystal;
    GameScreen gs;
    public Obstacle(GameScreen gs){
        this.gs = gs;
        setDefaultValues();
        getImage();
    }

    @Override
    public void setDefaultValues() {
        setSpeed(1.5);
    }

    @Override
    public void getImage() {
        try{ 
            if (isRock == true) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/obstacle_rock2.png")));
            }
            if (isCrystal == true) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/obstacle_crystal2.png")));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update() {
        double x = getxLocation();
        if(x%29==0){
            setxLocation((x-2.5));
        }
        else{
            setxLocation((x+1.5));
        }
        double y = getyLocation();
        int centerxImage = (int) (x +(getSpriteWidth()/2));
        int centeryImage = (int) (y +(getSpriteHeight()/2));
        double speed = getSpeed();
        setyLocation(y-speed);
        setxLocation(x-speed);
        if(centerxImage>800 || centeryImage>450 || centerxImage<0 || centeryImage<0){
            setIsDead(true);
        }
    }
}
    