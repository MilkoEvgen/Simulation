package entity;

import game.GameMap;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Predator extends Creature {
    int attackPower;

    public Predator(Point point) {
        super(point);
        speed = 4;
        hp = 10;
        attackPower = 4;
    }

    @Override
    public void printEntity() {
        System.out.print("\uD83E\uDD96");
    }

    @Override
    public void makeMove(Set<Point> herbivores, GameMap map) {
        Optional<Point> target = getTargetToAttack(herbivores);
        if (target.isPresent()) {
            Point targetPoint = target.get();
            Herbivore targetHerbivore = (Herbivore) map.getEntity(targetPoint);
            attack(targetHerbivore);
            if (!targetHerbivore.isAlive()){
                map.removeEntity(targetPoint);
                map.moveEntity(targetPoint, this);
            }
        } else {
            List<Point> closestPath = getClosestPath(herbivores, map);
        }

    }

    public Optional<Point> getTargetToAttack(Set<Point> herbivores){
        Point neighbour = new Point();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            neighbour.x = point.x + dir[0];
            neighbour.y = point.y + dir[1];
            if (herbivores.contains(neighbour)) {
                return Optional.of(neighbour);
            }
        }
        return Optional.empty();
    }

    public void attack (Herbivore herbivore){
        hp = hp + attackPower;
        herbivore.takeDamage(attackPower);
    }


}
