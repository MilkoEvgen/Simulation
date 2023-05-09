package entity;

import game.GameMap;

import java.awt.*;

public class Tree extends Entity{

    public Tree(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83C\uDF33"+ " ");
    }
}
