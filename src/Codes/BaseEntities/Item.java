package Codes.BaseEntities;

public abstract class Item extends BaseObject {
    @Override
    public void update() {
        double x = getxLocation();
        if(x%29==0){
            setxLocation((x-getSpeed()-1));
        }else{
            setxLocation((x+getSpeed()));
        }
    }

    @Override
    public void setDefaultValues() {
        setSpeed(1.5);
    }
}
