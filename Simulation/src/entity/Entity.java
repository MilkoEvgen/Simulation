package entity;


import java.awt.*;

public abstract class Entity {
public Point point;

    public Entity(Point point) {
        this.point = point;
    }

    public abstract void printEntity();
}
