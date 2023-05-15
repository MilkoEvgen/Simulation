package entity;

import game.GameMap;
import java.awt.*;

public class Predator extends Creature {

    public Predator(Point point, GameMap map) {
        super(point, map);
        speed = 4;
        hp = 10;
        attackPower = 5;
    }

    @Override
    protected Class<? extends Entity> getTargetType() {
        return Herbivore.class;
    }

    @Override
    public String getSprite() {
        return "\uD83E\uDD96";
    }

    protected void attack(Point targetPoint, int attackPower) {
        Herbivore herbivore = (Herbivore) map.getEntityByPoint(targetPoint);
        herbivore.takeDamage(attackPower);
        if (herbivore.hp < 0) {
            herbivore.isAlive = false;
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        }
    }
}
