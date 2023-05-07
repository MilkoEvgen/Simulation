package entity;

import game.GameMap;

import java.awt.*;

public class Rock extends Entity {

    public Rock(Point point, GameMap map) {
        super(point, map);
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83D\uDDFB");
    }
}
