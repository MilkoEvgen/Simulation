package entity;

import entity.Creature;
import game.GameMap;

import java.awt.*;
import java.util.Optional;
import java.util.Set;

public class Herbivore extends Creature {

    public Herbivore(Point point) {
        super(point);
        speed = 3;
        hp = 10;
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83D\uDC07");
    }

    @Override
    public void makeMove(Set<Point> grass, GameMap map) {
        Optional<Point> target = getTargetToAttack(grass);
        if (target.isPresent()) {
            Point targetPoint = target.get();
            hp = hp + 4;
            map.removeEntity(targetPoint);
            map.moveEntity(targetPoint, this);
        } else {
            //Ищем путь и ходим
        }
    }

    public Optional<Point> getTargetToAttack(Set<Point> grass){
        Point neighbour = new Point();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            neighbour.x = point.x + dir[0];
            neighbour.y = point.y + dir[1];
            if (grass.contains(neighbour)) {
                return Optional.of(neighbour);
            }
        }
        return Optional.empty();
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp <= 0) {
            alive = false;

        } else {

        }
    }
}
