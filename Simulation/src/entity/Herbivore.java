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
    public void printEntity() {
        System.out.print("\uD83D\uDC07");
    }

    @Override
    public Set<Point> getTargetPoints(){
        return map.getCreaturePoints(Grass.class);
    }

    protected void attack(Point targetPoint, int attackPower) {
        System.out.println("Травоядное " + point.x + " " + point.y + " атакует c силой "+ attackPower);
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
