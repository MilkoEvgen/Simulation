package entity;

import game.GameMap;
import java.awt.*;
import java.util.Set;

public abstract class Creature extends Entity {
    int speed;
    int hp;

    public Creature(Point point) {
        super(point);
    }

    public abstract void makeMove(Set<Point> points, GameMap map);
}
