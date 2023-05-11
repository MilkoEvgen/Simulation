package entity;

import game.GameMap;

import java.awt.*;

public class Tree extends Entity{

    public Tree(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public String getSprite() {
        return "\uD83C\uDF33";
    }
}
