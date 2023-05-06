package entity;



import game.GameMap;
import java.awt.*;
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
            Point pointToAttack = target.get();
            attack((Herbivore) map.getEntity(pointToAttack));
        } else {
            //Ищем путь и ходим
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
        System.out.println("Predator attacking!");
    }


}
