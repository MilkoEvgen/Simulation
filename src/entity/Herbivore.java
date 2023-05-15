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
        attackPower = 4;
    }

    @Override
    protected Class<? extends Entity> getTargetType() {
        return Grass.class;
    }

    @Override
    public String getSprite() {
        return "\uD83D\uDC07";
    }

    protected void attack(Point targetPoint, int attackPower) {
        Grass grass = (Grass) map.getEntity(targetPoint);
        hp = hp + attackPower;
        grass.takeDamage(attackPower);
        if (grass.hp < 0) {
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        }
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
    }
}
