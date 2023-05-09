package entity;

import game.GameMap;
import java.awt.*;
import java.util.Set;

public class Predator extends Creature {

    public Predator(Point point, GameMap map) {
        super(point, map);
        speed = 4;
        hp = 10;
        attackPower = 5;
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83E\uDD96"+ " ");
    }

    @Override
    public Set<Point> getTargetPoints(){
        return map.getCreaturesByClass(Herbivore.class).keySet();
    }

    protected void attack(Point targetPoint, int attackPower) {
        Herbivore herbivore = (Herbivore) map.getEntity(targetPoint);
        herbivore.takeDamage(attackPower);
        if (herbivore.hp < 0) {
            herbivore.isAlive = false;
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        }
    }
}
