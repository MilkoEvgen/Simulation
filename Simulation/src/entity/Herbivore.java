package entity;

import entity.Creature;
import game.GameMap;
import game.Simulation;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Herbivore extends Creature {

    public Herbivore(Point point, GameMap map) {
        super(point, map);
        speed = 3;
        hp = 10;
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83D\uDC07");
    }

    protected void attack(Point targetPoint) {
        hp = hp + 4;
        map.removeEntity(targetPoint);
        map.moveEntity(targetPoint, this);
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp <= 0) {
            this.map.removeEntity(this.point);
        }
    }
}
