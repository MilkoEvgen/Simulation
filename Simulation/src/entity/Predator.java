package entity;

import game.GameMap;
import game.Simulation;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Predator extends Creature {
    int attackPower;

    public Predator(Point point, GameMap map) {
        super(point, map);
        speed = 4;
        hp = 10;
        attackPower = 4;
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83E\uDD96");
    }

    @Override
    public Set<Point> getTargetPoints(){
        return map.getCreaturePoints(Herbivore.class);
    }

    protected void attack(Point targetPoint) {
        Herbivore herbivore = (Herbivore) map.getEntity(targetPoint);
        hp = hp + attackPower;
        herbivore.takeDamage(attackPower);
        if (herbivore.hp < 0) {
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        }
    }
}
