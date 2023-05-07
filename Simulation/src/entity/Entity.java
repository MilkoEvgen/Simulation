package entity;


import game.GameMap;

import java.awt.*;

public abstract class Entity {

    GameMap map;
    public Point point;

    public Entity(Point point, GameMap map) {
        this.point = point;
        this.map = map;
    }

    public abstract void printEntity();

}
