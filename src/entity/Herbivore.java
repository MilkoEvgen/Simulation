package entity;

import game.GameMap;

import java.awt.*;

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
        Grass grass = (Grass) map.getEntityByPoint(targetPoint);
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
