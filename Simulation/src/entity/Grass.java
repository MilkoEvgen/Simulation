package entity;

import game.GameMap;

import java.awt.*;

public class Grass extends Entity {
    public Grass(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83C\uDF3C");
    }
}
