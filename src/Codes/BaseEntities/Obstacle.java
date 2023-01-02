package Codes.BaseEntities;

public abstract class Obstacle extends BaseObject {

    @Override
    public void update() {
        double x = getxLocation();
        if(x%29==0){
            setxLocation((x-2.5));
        }else{
            setxLocation((x+1.5));
        }
    }
    
}