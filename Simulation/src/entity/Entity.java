package entity;


import java.awt.*;

public abstract class Entity {
public Point point;
    boolean alive;

    public Entity(Point point) {
        this.point = point;
        alive = true;
    }

    public abstract void printEntity();

    public boolean isAlive(){
        return alive;
    }
}
