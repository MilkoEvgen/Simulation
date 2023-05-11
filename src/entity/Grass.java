package entity;

import game.GameMap;

import java.awt.*;

public class Grass extends Entity {
    int hp;

    public Grass(Point point, GameMap map) {
        super(point, map);
        hp = 10;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    @Override
    public String getSprite() {
        return "\uD83C\uDF3C";
    }
}
